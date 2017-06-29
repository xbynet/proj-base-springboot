package com.github.xbynet.util.algorithm;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 随机数工具集.
 * 
 * 1. 获取无锁的ThreadLocalRandom, 性能较佳的SecureRandom
 * 
 * 2. 保证没有负数陷阱，也能更精确设定范围的nextInt/nextLong/nextDouble (copy from Common Lang
 * RandomUtils，但默认使用性能较优的ThreadLocalRandom，并可配置其他的Random)
 * 
 * 3. 随机字符串
 * 
 * @author calvin
 */
public class RandomUtil {

	/////////////////// 获取Random实例//////////////
	/**
	 * 返回无锁的ThreadLocalRandom
	 */
	public static Random threadLocalRandom() {
		return java.util.concurrent.ThreadLocalRandom.current();
	}

	/**
	 * 使用性能更好的SHA1PRNG, Tomcat的sessionId生成也用此算法.
	 * 
	 * 但JDK7中，需要在启动参数加入 -Djava.security=file:/dev/./urandom （中间那个点很重要）
	 * 
	 * 详见：《SecureRandom的江湖偏方与真实效果》http://calvin1978.blogcn.com/articles/securerandom.html
	 */
	public static SecureRandom secureRandom() {
		try {
			return SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			return new SecureRandom();
		}
	}




}

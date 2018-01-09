package com.github.xbynet.util.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.github.xbynet.config.GlobalContext;

/**
 * RedisSessionFilter
 * Created by taojw .
 */
public class RedisSessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest){
            HttpServletRequest request=(HttpServletRequest)servletRequest;
            RedisSessionRequestWrapper reqWrapper=new RedisSessionRequestWrapper(request);
            filterChain.doFilter(reqWrapper,servletResponse);
            if(reqWrapper.shouldFilterSave()){
                GlobalContext.getBean(RedisSessionRepository.class).save(reqWrapper.getRedisSession());
            }
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

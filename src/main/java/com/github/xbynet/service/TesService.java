package com.github.xbynet.service;

import com.github.xbynet.dao.BaseService;
import com.github.xbynet.entity.Tes;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author taojiawei
 * @create 2018/1/9
 **/
@Service
//@Transactional
public class TesService extends BaseService<Tes,String>{
	public void insert11(){
		Tes t=new Tes();
		t.setName("name--"+UUID.randomUUID().toString());
		super.save(t);
	}
}

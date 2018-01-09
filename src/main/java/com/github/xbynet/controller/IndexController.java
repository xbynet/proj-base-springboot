package com.github.xbynet.controller;

import com.github.xbynet.config.GlobalContext;
import com.github.xbynet.service.TesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author taojiawei
 * @create 2018/1/8
 **/
//@RestController
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private TesService tesService;
	@GetMapping("")
	@ResponseBody
	public String hello(){
		return "okqqq2221"+ GlobalContext.getRootPath();
	}
	@GetMapping("test")
	@ResponseBody
	public String test(){
		tesService.insert11();
		return "ok";
	}
	@GetMapping("main")
	public String main(){
		return "main";
	}
}

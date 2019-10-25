package com.zay.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zay.entity.Person;
import com.zay.service.PersonService;
import com.zay.util.XDateUtils;

@Controller
@RequestMapping("/web")
public class WebController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/hi")
	public String hi(Map<String, Object> model) {
		Person person = personService.getPersonById(0);
		model.put("time", XDateUtils.nowToString());
		model.put("message", "这是测试的内容。。。");
		model.put("toUserName", null != person ? person.getFirstName():"测试");
		model.put("fromUserName", "老许");
		return "welcome"; //自动寻找resources/templates中名字为welcome.ftl/welcome.vm的文件作为模板，拼装后返回
	}
}

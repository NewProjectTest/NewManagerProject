package com.zhiyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.service.Dservice;

@Controller
public class Dcontroller {
	@Autowired
	Dservice service;
	@RequestMapping("/D")
	public String upload(MultipartFile file) {
		String string = service.addVideo(file);
		System.out.println(string);
		return null;
	}

}

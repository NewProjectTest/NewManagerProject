package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.Speaker;
import com.zhiyou.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService service;
	@RequestMapping(value = "adminLogin")
	public ModelAndView  adminLogin(String accounts, String password, HttpServletRequest req, HttpServletResponse resp) {
		
		
		Integer num = service.adminLogin(accounts, password, req);
		ModelAndView model = new ModelAndView();
		if (num == 1) {

			model.setViewName("forward:show");


		} else if (num == 2) {
			model.addObject("msg", "密码错误");
			//model.setViewName("forward:ShouYe.jsp");
		} else {

			model.addObject("msg", "账号错误");
			//model.setViewName("forward:ShouYe.jsp");
		}
		return model;
	}

	@RequestMapping(value = "show")
	public ModelAndView show(HttpServletRequest req, HttpServletResponse resp) {
		// List<Speaker> list = service.videoShow();
		ModelAndView model = new ModelAndView();
		System.out.println(111);
		model.addObject("list", service.videoShow());
		model.setViewName("backstage/show");
		return model;
	}

	@RequestMapping(value = "speakerShow")
	public ModelAndView speakerShow(Integer page, HttpServletRequest req, HttpServletResponse resp) {

		if (page == null) {
			page = 1;
		}
		int num = service.count();
		ModelAndView model = new ModelAndView();
		model.addObject("count", num);
		model.addObject("list", service.speakerShow(((page - 1) * 2)));
		model.addObject("pagee", page);
		model.setViewName("backstage/speaker/speakerShow");

		return model;
	}

	@RequestMapping(value = "Uspeaker")
	public ModelAndView Uspeaker(Integer id, HttpServletRequest req, HttpServletResponse resp) {

		ModelAndView model = new ModelAndView();
		model.addObject("speaker", service.SpeakerSelectById(id));
		model.setViewName("speaker/speakerUpdate");
		return model;
	}

	@RequestMapping(value = "SpeakerSelectById")
	public ModelAndView SpeakerSelectById(Integer id, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView model = new ModelAndView();
		model.addObject("speaker", service.SpeakerSelectById(id));
		model.setViewName("backstage/speaker/speakerUpdate");
		return model;
	}

	@RequestMapping(value = "Dspeaker")
	public ModelAndView DeleteSpeaker(Integer id, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView model = new ModelAndView();
		service.DeleteSpeaker(id);
		model.addObject("msg", "3");
		model.setViewName("forward:speakerShow");
		return model;
	}

	@RequestMapping(value = "updateSpeaker")
	public ModelAndView updateSpeaker(Speaker speaker, Integer id, HttpServletRequest req, HttpServletResponse resp) {

		ModelAndView model = new ModelAndView();
		if (speaker.getId() != null) {
			Integer num = service.updateSpeaker(speaker);
			model.addObject("msg", "1");
		} else {

			service.AddSpeaker(speaker);
			model.addObject("msg", "2");
		}
		model.setViewName("forward:speakerShow");
		return model;
	}

}
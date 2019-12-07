package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.Speaker;
import com.zhiyou.service.AdminService;
import com.zhiyou.uitl.FTPUtil;

@Controller
public class AdminController {

	@Autowired
	AdminService service;
	
	@ResponseBody
	@RequestMapping(value = "adminLogin")
	public String  adminLogin(String accounts, String password, HttpServletRequest req, HttpServletResponse resp) {
		

		Integer num = service.adminLogin(accounts, password, req);
	
		if (num == 1) {
			
			return "success";
		} else if (num == 2) {

			return "false";
			
		} else {

			return "NoAccount";
		}
	}

	@RequestMapping(value = "show")
	public ModelAndView show(HttpServletRequest req, HttpServletResponse resp) {
		// List<Speaker> list = service.videoShow();
		ModelAndView model = new ModelAndView();
		
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
		model.setViewName("backstage/speaker/speakerUpdate");
		return model;
	}

	/*
	 * @RequestMapping(value = "SpeakerSelectById") public ModelAndView
	 * SpeakerSelectById(Integer id, HttpServletRequest req, HttpServletResponse
	 * resp) { ModelAndView model = new ModelAndView(); model.addObject("speaker",
	 * service.SpeakerSelectById(id));
	 * model.setViewName("backstage/speaker/speakerUpdate"); return model; }
	 */

	@RequestMapping(value = "Dspeaker")
	public ModelAndView DeleteSpeaker(Integer id, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView model = new ModelAndView();
		service.DeleteSpeaker(id);
		model.addObject("msg", "3");
		model.setViewName("forward:speakerShow");
		return model;
	}

	@RequestMapping(value = "updateSpeaker",method=RequestMethod.POST)
	public ModelAndView updateSpeaker(MultipartFile img, Speaker speaker, Integer id, HttpServletRequest req, HttpServletResponse resp) throws IOException  {

		ModelAndView model = new ModelAndView();
		System.out.println(speaker.getPic_url());
		String imgUrl = FTPUtil.upload(img.getInputStream(), img.getOriginalFilename());
		
		if (speaker.getId() != null) {
				if (imgUrl != null) {
					speaker.setPic_url(imgUrl);
				}
			
			
				Integer num = service.updateSpeaker(speaker);
				model.addObject("msg", "1");
		} else {
				if (imgUrl != null) {
					speaker.setPic_url(imgUrl);
				}
				
				
				service.AddSpeaker(speaker);
				model.addObject("msg", "2");
		}
		model.setViewName("forward:speakerShow");
		return model;
	}

}
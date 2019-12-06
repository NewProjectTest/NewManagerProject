package com.zhiyou.controller;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;
import com.zhiyou.service.VideoService;


@Controller
public class VideoController {
	@Autowired
	VideoService Service;
	@RequestMapping("voidShow")
	public ModelAndView voidShow(  Integer page,HttpServletRequest req,HttpServletResponse resp) {
	
		if (page==null) {
			page=1;
		}
		
		
		int num = Service.count();
		
		List<Video> list = Service.videoShow(((page-1)*3));
	
		ModelAndView model = new ModelAndView();
	
		List<Speaker> slist =  Service.selectspeaker();
		List<Course> clist =Service.course();
		
		model.addObject("list",list);
		model.addObject("count", num);
		model.addObject("pagee", page);
		
		
		model.addObject("slist", slist);
		model.addObject("clist", clist);
		model.setViewName("backstage/void/videoShow");
		return model;

	}
	@RequestMapping("Dvideo")
	public ModelAndView Dvideo(Integer id,HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView model = new ModelAndView();
		
		Service.Dvideo(id);
		model.setViewName("forward:voidShow");
		return model;
		
	}
	@RequestMapping(value = "videoA")
	public ModelAndView videoA(Integer id, HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView model = new ModelAndView();
		
		
		List<Speaker> slist =  Service.selectspeaker();
		List<Course> clist =Service.course();
		model.addObject("slist", slist);
		model.addObject("clist", clist);
		if (id != null) {
			Video video = Service.selectById(id);
			model.addObject("video", video);
		}
		
		
		
		model.setViewName("backstage/void/videoUpdate");
		return model;
		
	}
	
	@RequestMapping(value = "videoP",method = RequestMethod.POST)
	public ModelAndView videoP(MultipartFile MP , MultipartFile IMG,String sid,String cid,Video video) {
		
		ModelAndView model = new ModelAndView();
		 if (video.getVideo_id() == null) {
			 if (!MP.isEmpty()) {
				 //String videoName = Service.addVideo(file);
				 video.setImage_url(Service.addVideo(MP));
			}
			 if (!IMG.isEmpty()) {
				 // String imgName = Service.addVideoIMG(img);
				 video.setVideo_url(Service.addVideoIMG(IMG));
			}
			 
			Service.videoAdd(video);
		}else {
			Service.save(video);
		}
		 model.setViewName("forward:voidShow");
		return model;
	}
	@RequestMapping(value = "like")
	public ModelAndView like(Integer sid,Integer cid,String text,HttpServletRequest req,HttpServletResponse resp) {
		List<Video> list = Service.like(sid,cid,text);
		ModelAndView model = new ModelAndView();
		List<Speaker> slist =  Service.selectspeaker();
		List<Course> clist =Service.course();
		model.addObject("slist", slist);
		model.addObject("clist", clist);
		model.addObject("list", list);
		model.addObject("msg", "1");
		model.setViewName("backstage/void/videoShow");
		return model;
		
		
	}
	@ResponseBody
	@RequestMapping(value = "dAll")
	public String  dAll(@RequestParam("userIds[]")  Integer[] userIds,HttpServletRequest req,HttpServletResponse resp) {
		List<Integer> userIdList = Arrays.asList(userIds);
		int num = Service.dAll(userIdList,resp);
		if (num == 1||num == 2||num == 3) {
			return "ok";
		}
		return "error";
		
	}
}

package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;
import com.zhiyou.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	CourseService Service;
	
	@RequestMapping("courseAll")
	private ModelAndView courseAll(Integer page,HttpServletRequest req,HttpServletResponse resp) {
		

		if (page==null) {
			page=1;
		}
		
		List<Course> list = Service.courseAll(((page-1)*2));
		int num = Service.count();
		ModelAndView model = new ModelAndView();
		model.addObject("list",list);
		model.addObject("count", num);
		model.addObject("pagee", page);
		model.setViewName("backstage/course/courseShow");
		return model;

	}
	@ResponseBody
	@RequestMapping("Dcourse")
	private void Dcourse(HttpServletRequest req,HttpServletResponse resp) {
		Integer id = Integer.valueOf(req.getParameter("name"));
		Service.Dcourse(id);
			
	}
	@RequestMapping("Ucourse")
	private ModelAndView Ucourse( Integer id, HttpServletRequest req,HttpServletResponse resp) {
		Course course = Service.Ucourse(id);
		List<Subject> list = Service.subjectId();
		
		ModelAndView model = new ModelAndView();
		model.addObject("course",course);
		model.addObject("list", list);
		model.setViewName("backstage/course/courseUpdate");
		return model;
	}
	
	
	  @RequestMapping("updateCourse") 
	  private ModelAndView courseUpdate(Course course, HttpServletRequest req,HttpServletResponse resp) {
		  ModelAndView model = new ModelAndView(); 
			if (!course.getId().equals("")) {
				Service.courseUpdate(course);
				model.addObject("msg", "1");
			} else {
				Service.courseAdd(course);
				model.addObject("msg", "2");
			}
			model.setViewName("forward:courseAll");
		  
			return model; 
		
	  }
	 
	  @RequestMapping("ACourse") 
	  private ModelAndView ACourse( HttpServletRequest req,HttpServletResponse resp) {
		  
		  ModelAndView model = new ModelAndView(); 
		  List<Subject> list = Service.subjectId();
			model.addObject("list", list);
		  model.setViewName("backstage/course/courseUpdate");
		  return model; 
	  }
	  
	
}

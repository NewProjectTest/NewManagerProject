package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;
import com.zhiyou.service.CourseShowService;

@Controller
public class CourseShowController {

	@Autowired
	CourseShowService service;

	@RequestMapping("WebCourseShow")
	public String WebCourseShow(Integer number, HttpServletRequest req, HttpServletResponse resp) {

		List<Subject> subjectList = service.selectBySubject(number);
		req.getSession().setAttribute("subjectList", subjectList.get(0));
		List<Course> courseList = service.selectByCourse(number);
		req.getSession().setAttribute("courseList", courseList);
		for (int i = 0; i <= courseList.size() - 1; i++) {
			List<Video> videoList = service.selectByVideo(Integer.valueOf(courseList.get(i).getId()));
			req.getSession().setAttribute("videoList" + i, videoList);
		}
		return "frontDesk/KeChengZhanShi";
	}

	@RequestMapping(value = "VideoCourseShow")
	public String VideoCourseShow(String course_desc, String subject_name, String title, String video_url,
			String detail, Integer speaker_id, HttpServletRequest req, HttpServletResponse resp) {

		List<Speaker> speaker = service.selectBySpeaker(speaker_id);
		req.setAttribute("subject_name", subject_name);
		req.setAttribute("title", title);
		req.setAttribute("speaker", speaker.get(0));
		req.setAttribute("detail", detail);
		req.setAttribute("course_desc", course_desc);
		req.setAttribute("video_url", video_url);

		return "frontDesk/ShiPinBoFang";
	}

	@RequestMapping(value = "otherVideoCourseShow")
	public String otherVideoCourseShow(Integer number, HttpServletRequest req, HttpServletResponse resp) {

		List<Subject> subjectList = service.selectBySubject(number);
		req.getSession().setAttribute("subjectList", subjectList.get(0));
		List<Course> courseList = service.selectByCourse(number);
		req.getSession().setAttribute("courseList", courseList);
		for (int i = 0; i <= courseList.size() - 1; i++) {
			List<Video> videoList = service.selectByVideo(Integer.valueOf(courseList.get(i).getId()));
			courseList.get(i);
			req.getSession().setAttribute("videoList" + i, videoList);
		}

		return "frontDesk/ShiPinBoFang";
	}

}

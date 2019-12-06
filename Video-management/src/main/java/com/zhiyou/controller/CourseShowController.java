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
	public String VideoCourseShow(String course_id, Integer subject_id, Integer video_id, HttpServletRequest req,
			HttpServletResponse resp) {
		List<Course> course = service.selectByCourse_id(Integer.valueOf(course_id));
		List<Subject> subject = service.selectBySubject(subject_id);
		List<Video> video = service.selectByVideo_id(video_id);
		Integer integer = video.get(0).getPlay_num()==null?0:video.get(0).getPlay_num();
		video.get(0).setPlay_num(integer + 1);
		service.updateVideo_Play_Num(video.get(0));
		req.setAttribute("subject", subject.get(0));
		req.setAttribute("course", course.get(0));
		req.setAttribute("video", video.get(0));

		List<Speaker> speakers = service.selectBySpeaker(video.get(0).getSpeaker_id());
		req.setAttribute("speaker1", speakers.get(0));
		List<Video> videos = service.selectByVideo(Integer.valueOf(course_id));
		req.setAttribute("videos", videos);
		for (int i = 0; i <=videos.size()-1; i++) {
			List<Speaker> speaker2 = service.selectBySpeaker(videos.get(i).getSpeaker_id());
			req.setAttribute("speakers" + i, speaker2.get(0));
		}
		return "frontDesk/ShiPinBoFang";
	}

}

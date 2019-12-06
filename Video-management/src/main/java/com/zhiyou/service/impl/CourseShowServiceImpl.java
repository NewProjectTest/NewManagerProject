package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.CourseShowMapper;
import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;
import com.zhiyou.service.CourseShowService;

@Service
public class CourseShowServiceImpl implements CourseShowService {

	@Autowired
	CourseShowMapper mapper;

	public List<Course> selectByCourse(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByCourse(id);
	}

	public List<Speaker> selectBySpeaker(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectBySpeaker(id);
	}

	public List<Subject> selectBySubject(Integer subject_id) {
		// TODO Auto-generated method stub
		return mapper.selectBySubject(subject_id);
	}

	public List<Video> selectByVideo(Integer video_id) {
		// TODO Auto-generated method stub
		return mapper.selectByVideo(video_id);
	}

	public List<Video> selectBySpeaker_IdGetVideo(Integer speaker_id) {
		// TODO Auto-generated method stub
		return mapper.selectBySpeaker_IdGetVideo(speaker_id);
	}

	public List<Video> selectByVideo_id(Integer video_id) {
		// TODO Auto-generated method stub
		return mapper.selectByVideo_id(video_id);
	}

	public List<Course> selectByCourse_id(Integer Course_id) {
		// TODO Auto-generated method stub
		return mapper.selectByCourse_id(Course_id);
	}

	public void updateVideo_Play_Num(Video Video) {
		// TODO Auto-generated method stub
		mapper.updateVideo_Play_Num(Video);
	}
}

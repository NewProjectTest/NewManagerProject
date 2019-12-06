package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.CourseMapper;
import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;
import com.zhiyou.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper mapper;
	public List<Course> courseAll(Integer page) {
		
		return mapper.courseAll(page);
	}
	public Course Ucourse(Integer id) {
		// TODO Auto-generated method stub
		return mapper.Ucourse(id);
	}
	public void courseUpdate(Course course) {
		// TODO Auto-generated method stub
		mapper.courseUpdate(course);
	}
	public void courseAdd(Course course) {
		mapper.courseAdd( course);
		
	}
	public List<Subject> subjectId() {
		// TODO Auto-generated method stub
		return mapper.subjectId();
	}
	public void Dcourse(Integer id) {
		mapper.Dcourse(id);
		
	}
	public int count() {
		// TODO Auto-generated method stub
		return mapper.count();
	}

}

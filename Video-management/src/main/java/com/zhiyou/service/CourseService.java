package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;

public interface CourseService {

	List<Course> courseAll(Integer page);

	Course Ucourse(Integer id);

	void courseUpdate(Course course);

	void courseAdd(Course course);

	List<Subject> subjectId();

	void Dcourse(Integer id);

	int count();

}

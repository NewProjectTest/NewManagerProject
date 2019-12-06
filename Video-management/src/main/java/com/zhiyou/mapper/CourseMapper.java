package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Course;
import com.zhiyou.model.Subject;

public interface CourseMapper {

	List<Course> courseAll(Integer page);

	Course Ucourse(Integer id);

	void courseUpdate(Course course);

	void courseAdd(Course course);

	List<Subject> subjectId();

	void Dcourse(Integer id);

	int count();

	int dAll(@Param("userIdList")List<Integer> userIdList);

}

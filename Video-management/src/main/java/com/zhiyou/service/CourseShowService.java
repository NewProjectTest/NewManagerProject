package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;

public interface CourseShowService {
	List<Course> selectByCourse(Integer id);

	List<Speaker> selectBySpeaker(Integer id);

	List<Subject> selectBySubject(Integer subject_id);

	List<Video> selectByVideo(Integer video_id);
}

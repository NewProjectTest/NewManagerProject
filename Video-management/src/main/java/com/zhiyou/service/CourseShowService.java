package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Subject;
import com.zhiyou.model.Video;

public interface CourseShowService {
	List<Course> selectByCourse(Integer subject_id);

	List<Speaker> selectBySpeaker(Integer id);

	List<Subject> selectBySubject(Integer subject_id);

	List<Video> selectByVideo(Integer course_id);

	List<Video> selectByVideo_id(Integer video_id);

	List<Course> selectByCourse_id(Integer Course_id);

	List<Video> selectBySpeaker_IdGetVideo(Integer speaker_id);

	void updateVideo_Play_Num(Video Video);
}

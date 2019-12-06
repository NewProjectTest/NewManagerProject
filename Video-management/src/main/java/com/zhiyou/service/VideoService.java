package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;

public interface VideoService {

	List<Video> videoShow(Integer page);

	int count();

	void Dvideo(Integer id);
	String addVideo(MultipartFile file);

	String  addVideoIMG(MultipartFile img);

	void videoAdd(Video video);

	List<Speaker> selectspeaker();

	List<Course> course();

	Video selectById(Integer id);

	void save(Video video);

	List<Video> like(Integer sid, Integer cid, String text);

	int dAll(List<Integer> userIdList,HttpServletResponse resp);
}

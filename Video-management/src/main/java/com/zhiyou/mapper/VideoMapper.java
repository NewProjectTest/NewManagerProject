package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Course;
import com.zhiyou.model.D;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;

public interface VideoMapper {

	List<Video> videoShow(Integer page);

	int count();

	void Dvideo(Integer id);

	void videoAdd(Video video);

	

	List<Course> course();

	List<Speaker> selectspeaker();

	Video selectById(Integer id);

	void save(Video video);

	List<Video> like(@Param("sid")Integer sid,@Param("cid") Integer cid,@Param("text") String text);

	int dAll(@Param("userIdList")List<Integer> userIdList);


}

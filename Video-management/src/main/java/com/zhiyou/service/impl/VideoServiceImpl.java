package com.zhiyou.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.mapper.CourseMapper;
import com.zhiyou.mapper.VideoMapper;
import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;
import com.zhiyou.service.VideoService;
import com.zhiyou.uitl.FTPUtil;
@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoMapper mapper;
	
	
	
	public List<Video> videoShow(Integer page) {
		// TODO Auto-generated method stub
		return mapper.videoShow(page);
	}
	public int count() {
		// TODO Auto-generated method stub
		return mapper.count();
	}
	public void Dvideo(Integer id) {
		mapper.Dvideo(id);
		
	}
	public String  addVideo( MultipartFile file) {
		String fileName = file.getOriginalFilename();
		try {
			//保存文件到指定的目录
			file.transferTo(new File("D:\\mp4\\" +System.currentTimeMillis()+ fileName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//加个时间戳
		return ("D:\\mp4\\"+System.currentTimeMillis()+fileName);
		
		
	}
	public String addVideoIMG(MultipartFile img) {
		try {
			String imgName = FTPUtil.upload(img.getInputStream(), img.getOriginalFilename());
			return imgName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void videoAdd(Video video) {
		mapper.videoAdd(video);
		
	}
	public List<Speaker> selectspeaker() {
		// TODO Auto-generated method stub
		return mapper.selectspeaker();
	}
	public List<Course> course() {
		// TODO Auto-generated method stub
		return mapper.course();
	}
	public Video selectById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}
	public void save(Video video) {
		mapper.save(video);
		
	}
	public List<Video> like(Integer sid, Integer cid, String text) {

		if (text.equals("")) {
			text = null;
		}
		return mapper.like(sid,cid,text);
	}
	public int dAll(List<Integer> userIdList,HttpServletResponse resp) {
		return mapper.dAll(userIdList);
	}

}

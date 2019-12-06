package com.zhiyou.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.mapper.D;
import com.zhiyou.service.Dservice;
@Service
public class DserviceImpl implements Dservice {

	@Autowired
			D d;
	
	public String addVideo( MultipartFile file) {
		String fileName = file.getOriginalFilename();
		try {
			//保存文件到指定的目录
			file.transferTo(new File("D:\\mp4\\" + fileName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ("D:\\mp4\\"+fileName);
	}

}

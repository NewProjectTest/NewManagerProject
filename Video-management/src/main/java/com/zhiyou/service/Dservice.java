package com.zhiyou.service;

import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.mapper.D;

public interface Dservice {
	String addVideo(MultipartFile file);
}

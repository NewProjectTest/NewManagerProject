package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.model.Speaker;

public interface AdminService {

	Integer adminLogin(String accounts, String password, HttpServletRequest req);

	List<Speaker> videoShow();

	List<Speaker> speakerShow(Integer page);

	Speaker SpeakerSelectById(Integer id);

	Integer updateSpeaker(Speaker speaker);

	void AddSpeaker(Speaker speaker);

	void DeleteSpeaker(Integer id);

	int count();

}

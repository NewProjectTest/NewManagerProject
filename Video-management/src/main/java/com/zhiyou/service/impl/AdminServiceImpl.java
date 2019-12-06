package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.AdminMapper;
import com.zhiyou.model.Admin;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper mapper;

	public Integer adminLogin(String accounts, String password, HttpServletRequest req) {

		Admin admin = mapper.adminLogin(accounts);
		if (admin != null) {

			if (admin.getPassword().equals(password)) {
				req.getSession().setAttribute("MaxAdmin", admin);
				return 1;
			}

			return 2;
		}

		return 3;
	}

	public List<Speaker> videoShow() {

		return mapper.videShow();
	}

	public List<Speaker> speakerShow(Integer page) {

		return mapper.speakerShow(page);

	}

	public Speaker SpeakerSelectById(Integer id) {

		return mapper.SpeakerSelectById(id);
	}

	public Integer updateSpeaker(Speaker speaker) {

		return mapper.updateSpeaker(speaker);
	}

	public void AddSpeaker(Speaker speaker) {
		mapper.AddSpeaker(speaker);

	}

	public void DeleteSpeaker(Integer id) {
		mapper.DeleteSpeaker(id);

	}

	public int count() {
		// TODO Auto-generated method stub
		return mapper.count();
	}

}

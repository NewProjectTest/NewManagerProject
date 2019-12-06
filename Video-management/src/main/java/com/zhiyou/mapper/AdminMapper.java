package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.Admin;
import com.zhiyou.model.Speaker;

public interface AdminMapper {

	Admin adminLogin(String accounts);

	List<Speaker> videShow();

	List<Speaker> speakerShow(Integer page);

	Speaker SpeakerSelectById(Integer id);

	Integer updateSpeaker(Speaker speaker);

	void AddSpeaker(Speaker speaker);

	void DeleteSpeaker(Integer id);

	int count();

}

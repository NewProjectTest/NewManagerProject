package com.zhiyou.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class Speaker {
	private Integer id;
	private String speaker_name;
	private String speaker_desc;
	private String speaker_job;
	private String pic_url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpeaker_name() {
		return speaker_name;
	}

	public void setSpeaker_name(String speaker_name) {
		this.speaker_name = speaker_name;
	}

	public String getSpeaker_desc() {
		return speaker_desc;
	}

	public void setSpeaker_desc(String speaker_desc) {
		this.speaker_desc = speaker_desc;
	}

	public String getSpeaker_job() {
		return speaker_job;
	}

	public void setSpeaker_job(String speaker_job) {
		this.speaker_job = speaker_job;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	@Override
	public String toString() {
		return "Speaker [id=" + id + ", speaker_name=" + speaker_name + ", speaker_desc=" + speaker_desc
				+ ", speaker_job=" + speaker_job + ", pic_url=" + pic_url + "]";
	}

}

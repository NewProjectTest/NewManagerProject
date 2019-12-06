package com.zhiyou.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
	private String id;
	private String course_title;
	private String course_desc;
	private String subject_id;
	private Subject subject;

}

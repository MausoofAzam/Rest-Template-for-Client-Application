package com.snort.app.entity;

import lombok.Data;

@Data
public class Posts {

	//request response payload 
	//it returns json response
	
	private int userId;
	private int id;
	private String title;
	private String body;
}

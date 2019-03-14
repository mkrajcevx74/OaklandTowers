package com.group9.OaklandTowers.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class PostalInfo
{
	private @Id @GeneratedValue int post_id;
	private String post_name;
	private String post_country;
	private String post_state;
	private String post_city;
	private short post_code;
	private String post_streetAddr;

	public PostalInfo(String post_name, String post_country, String post_state, String post_city, short post_code, String post_streetAddr)
	{
		this.post_name = post_name;
		this.post_country = post_country;
		this.post_state = post_state;
		this.post_city = post_city;
		this.post_code = post_code;
		this.post_streetAddr = post_streetAddr;
	}
}
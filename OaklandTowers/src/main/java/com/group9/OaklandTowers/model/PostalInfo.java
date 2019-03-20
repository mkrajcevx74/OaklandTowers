package com.group9.OaklandTowers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "POSTAL_INFO")
@Data @Entity @NoArgsConstructor
public class PostalInfo extends AbstractModelEO<Integer>
{
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

	@Column(name = "post_id")
	@Id @GeneratedValue
	public Integer getId()
	{
		return super.onGetId();
	}
}
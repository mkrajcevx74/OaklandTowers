package com.group9.OaklandTowers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "USER")
@Data @Entity @NoArgsConstructor
public class User extends AbstractModelEO<Integer>
{
	private String user_name;
	private String user_password;
	private String user_email;
	private byte user_type;
	private double user_balance;

	private PostalInfo postalInfo;

	public User(String user_name, String user_password, String user_email, byte user_type, double user_balance)
	{
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_type = user_type;
		this.user_balance = user_balance;
	}

	public User(String user_name, String user_password, String user_email, byte user_type, double user_balance, PostalInfo postalInfo)
	{
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_type = user_type;
		this.user_balance = user_balance;
		this.postalInfo = postalInfo;
	}

	@Column(name = "user_id")
	@Id @GeneratedValue @Override
	public Integer getId()
	{
		return super.onGetId();
	}

	@ManyToOne
	@JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "user_ibfk_1"))
	public PostalInfo getPostalInfo()
	{
		return postalInfo;
	}
}
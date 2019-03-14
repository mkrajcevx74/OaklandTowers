package com.group9.OaklandTowers.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Data
@Entity
@NoArgsConstructor
public class User
{
	private @Id @GeneratedValue int user_id;
	private String user_name;
	private String user_password;
	private String user_email;
	private byte user_type;
	private double user_balance;

	@JoinColumn(name = "postal_id", foreignKey = @ForeignKey(name = "user_ibfk_1"))
	private int postal_id;

	public User(String user_name, String user_password, String user_email, byte user_type, double user_balance, int postal_id)
	{
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_type = user_type;
		this.user_balance = user_balance;
		this.postal_id = postal_id;
	}
}
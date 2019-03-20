package com.group9.OaklandTowers.model;

import java.sql.Date;

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

@Table(name = "PAYMENT_INFO")
@Data @Entity @NoArgsConstructor
public class PaymentInfo extends AbstractModelEO<Integer>
{
	private String pmnt_name;
	private byte pmnt_type;
	private long pmnt_num;
	private String pmnt_name_last;
	private String pmnt_name_first;
	private char pmnt_name_mi;
	private Date pmnt_date_expr;

	private User pmnt_user;

	public PaymentInfo(String pmnt_name, byte pmnt_type, long pmnt_num, String pmnt_name_last, String pmnt_name_first, char pmnt_name_mi, Date pmnt_date_expr, User pmnt_user)
	{
		this.pmnt_name = pmnt_name;
		this.pmnt_type = pmnt_type;
		this.pmnt_num = pmnt_num;
		this.pmnt_name_last = pmnt_name_last;
		this.pmnt_name_first = pmnt_name_first;
		this.pmnt_name_mi = pmnt_name_mi;
		this.pmnt_date_expr = pmnt_date_expr;
		this.pmnt_user = pmnt_user;
	}

	@Column(name = "pmnt_id")
	@Id @GeneratedValue
	public Integer getId()
	{
		return super.onGetId();
	}

	@ManyToOne
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "pmnt_ibfk_1"), nullable = false)
	public User getUser()
	{
		return pmnt_user;
	}
}
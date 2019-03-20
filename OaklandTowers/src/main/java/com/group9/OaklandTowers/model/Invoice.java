package com.group9.OaklandTowers.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "INVOICE")
@Data @Entity @NoArgsConstructor
public class Invoice extends AbstractModelEO<Integer>
{
	private double invc_amount;
	private String invc_desc;

	private PaymentInfo invc_paymentInfo;

	public Invoice(double invc_amount, String invc_desc, PaymentInfo invc_paymentInfo)
	{
		this.invc_amount = invc_amount;
		this.invc_desc = invc_desc;
		this.invc_paymentInfo = invc_paymentInfo;
	}

	@Column(name = "invc_id")
	@Id @GeneratedValue
	public Integer getId()
	{
		return super.onGetId();
	}

	@ManyToOne
	@JoinColumn(name = "pmnt_id", foreignKey = @ForeignKey(name = "invc_ibfk_1"), nullable = false)
	public PaymentInfo getInvc_paymentInfo()
	{
		return invc_paymentInfo;
	}
}
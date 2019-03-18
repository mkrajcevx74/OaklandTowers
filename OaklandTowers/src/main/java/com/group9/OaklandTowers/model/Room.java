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

@Table(name = "ROOM")
@Data @Entity @NoArgsConstructor
public class Room extends AbstractModelEO<Integer>
{
	private short room_num;
	private byte room_type;
	private byte room_beds_num;
	private byte room_beds_size;

	private PostalInfo postalInfo;

	public Room(short room_num, byte room_type, byte room_beds_num, byte room_beds_size, int postal_id)
	{
		this.room_num = room_num;
		this.room_type = room_type;
		this.room_beds_num =  room_beds_num;
		this.room_beds_size = room_beds_size;
	}

	@Column(name = "room_id")
	@Id @GeneratedValue @Override
	public Integer getId()
	{
		return super.onGetId();
	}

	@ManyToOne
	@JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "room_ibfk_1"), nullable = false)
	public PostalInfo getPostalInfo()
	{
		return postalInfo;
	}
}
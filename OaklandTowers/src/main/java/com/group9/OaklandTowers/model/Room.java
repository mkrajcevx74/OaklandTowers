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
public class Room
{
	private @Id @GeneratedValue int room_id;
	private short room_num;
	private byte room_type;
	private byte room_beds_num;
	private byte room_beds_size;

	@JoinColumn(name = "postal_id", foreignKey = @ForeignKey(name = "room_ibfk_1"))
	private int postal_id;

	public Room(short room_num, byte room_type, byte room_beds_num, byte room_beds_size, int postal_id)
	{
		this.room_num = room_num;
		this.room_type = room_type;
		this.room_beds_num =  room_beds_num;
		this.room_beds_size = room_beds_size;
		this.postal_id = postal_id;
	}
}
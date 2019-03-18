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

@Table(name = "RESERVATION")
@Data @Entity @NoArgsConstructor
public class Reservation extends AbstractModelEO<Integer>
{
	private User user;

	private Room room;

	private Date rsrv_dateTime_start;
	private Date rsrv_dateTime_end;
	private double rsrv_cost;

	public Reservation(User user, Room room, Date rsrv_dateTime_start, Date rsrv_dateTime_end, double rsrv_cost)
	{
		this.user = user;
		this.room = room;
		this.rsrv_dateTime_start =  rsrv_dateTime_start;
		this.rsrv_dateTime_end = rsrv_dateTime_end;
		this.rsrv_cost = rsrv_cost;
	}

	@Column(name = "rsrv_id")
	@Id @GeneratedValue @Override
	public Integer getId()
	{
		return super.onGetId();
	}

	@ManyToOne
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "rsrv_ibfk_1"), nullable = false)
	public User getUser()
	{
		return user;
	}

	@ManyToOne
	@JoinColumn(name = "room_id", foreignKey = @ForeignKey(name = "rsrv_ibfk_2"), nullable = false)
	public Room getRoom()
	{
		return room;
	}
}
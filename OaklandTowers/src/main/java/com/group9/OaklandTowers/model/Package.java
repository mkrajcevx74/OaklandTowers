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

@Table(name = "PACKAGE")
@Data @Entity @NoArgsConstructor
public class Package extends AbstractModelEO<Integer>
{
	private byte pkg_type;
	private Reservation pkg_rsrv;

	public Package(byte pkg_type, Reservation pkg_rsrv)
	{
		this.pkg_type = pkg_type;
		this.pkg_rsrv = pkg_rsrv;
	}

	@Column(name = "pkg_id")
	@Id @GeneratedValue
	public Integer getId()
	{
		return super.onGetId();
	}

	@ManyToOne(targetEntity = Reservation.class)
	@JoinColumn(name = "rsrv_id", foreignKey = @ForeignKey(name = "pkg_ibfk_1"))
	public Reservation getPkg_rsrv()
	{
		return pkg_rsrv;
	}
}
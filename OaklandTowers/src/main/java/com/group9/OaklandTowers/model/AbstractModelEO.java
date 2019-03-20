package com.group9.OaklandTowers.model;

public abstract class AbstractModelEO<T extends Number> implements ModelEO<T>
{
	private T id;

	protected T onGetId()
	{
		return id;
	}

	public void setId(T id)
	{
		this.id = id;
	}

	public String getEntityType()
	{
		return this.getClass().getName().toLowerCase() + "s";
	}
}
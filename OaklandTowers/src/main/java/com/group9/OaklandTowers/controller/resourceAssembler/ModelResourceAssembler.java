package com.group9.OaklandTowers.controller.resourceAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;

import com.group9.OaklandTowers.controller.ModelController;
import com.group9.OaklandTowers.model.AbstractModelEO;

public abstract class ModelResourceAssembler<M extends AbstractModelEO<Integer>> implements ResourceAssembler<M, Resource<M>>
{
	@Override
	public Resource<M> toResource(M entity)
	{
		return new Resource<>(entity,
			linkTo(methodOn(getController()).one(entity.getId())).withSelfRel(),
			linkTo(methodOn(getController()).all()).withRel(getRei(entity))
		);
	}

	protected String getRei(M entity)
	{
		return entity.getClass().getName().toLowerCase() + "s";
	}

	protected abstract <C extends ModelController> Class<C> getController();
}
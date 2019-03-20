package com.group9.OaklandTowers.controller.resourceAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.http.ResponseEntity;

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

	public ResponseEntity<Resource<M>> toResponse(Resource<M> resource)
	{
		ResponseEntity<Resource<M>> response = ResponseEntity.notFound().build();
		try
		{
			response = ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
		return response;
	}

	protected String getRei(M entity)
	{
		return entity.getClass().getName().toLowerCase() + "s";
	}

	protected abstract <C extends ModelController> Class<C> getController();
}
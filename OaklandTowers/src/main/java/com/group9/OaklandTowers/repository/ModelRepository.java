package com.group9.OaklandTowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.group9.OaklandTowers.model.AbstractModelEO;

@NoRepositoryBean
public interface ModelRepository<M extends AbstractModelEO<Integer>> extends JpaRepository<M, Integer>
{

}
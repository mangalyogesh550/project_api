package com.project.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.project.api.entity.CountyEntity;

@Repository
public interface CountyRepo extends JpaRepository<CountyEntity, Long>, JpaSpecificationExecutor<CountyEntity> {

	CountyEntity findByName(String name);

	List<CountyEntity> findByState(String state);

}

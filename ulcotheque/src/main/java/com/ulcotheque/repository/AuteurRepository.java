package com.ulcotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulcotheque.entity.AuteurEntity;

@Repository
public interface AuteurRepository extends JpaRepository<AuteurEntity, Integer>{
	
}

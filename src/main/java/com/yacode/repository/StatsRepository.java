package com.yacode.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.yacode.service.Stats;


public interface StatsRepository extends Repository<Stats, Integer>{
	
	List<Stats>findAll();
	Stats save(Stats p);
}

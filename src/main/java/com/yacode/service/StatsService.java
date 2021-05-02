package com.yacode.service;

import java.util.Collection;
import java.util.List;

import com.yacode.model.StatsResponse;

public interface StatsService {

	
	StatsResponse listar();
	Stats add(Stats p);

}

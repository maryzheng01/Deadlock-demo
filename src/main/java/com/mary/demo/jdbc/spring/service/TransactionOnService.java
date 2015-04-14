package com.mary.demo.jdbc.spring.service;

import java.util.List;

import com.mary.demo.jdbc.spring.data.DemoData;

public interface TransactionOnService {

	void save(DemoData demoData);

	List<String> findByLastName(String lastName);

}

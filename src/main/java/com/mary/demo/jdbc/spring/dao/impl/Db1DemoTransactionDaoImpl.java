package com.mary.demo.jdbc.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mary.demo.jdbc.spring.dao.BaseDao;
import com.mary.demo.jdbc.spring.dao.Db1DemoTransactionDao;

@Repository
public class Db1DemoTransactionDaoImpl extends BaseDao implements Db1DemoTransactionDao {

	@Autowired
	@Qualifier("db1NamedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate db1NamedParameterJdbcTemplate;

	@Autowired
	@Qualifier("db1JdbcTemplate")
	public JdbcTemplate db1JdbcTemplate;

	@Override
	@Transactional(value="transactionManager", readOnly=false)
	public void insertData(String lastname, String firstname, String name,
			String city, String message) {
		insertData(lastname, firstname, name, city, message, db1JdbcTemplate);
	}

	@Override
	@Transactional(value="transactionManager", readOnly=true)
	public List<String> findGuidsByLastname(String lastName) {
		 return findGuidsByLastname(db1NamedParameterJdbcTemplate, lastName);
	}

}

package com.mary.demo.jdbc.spring.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseDao {

	private final static String SQL_INSERT = " insert into demo_jdbc_type ( guid, lastName, firstName, name, address, city, budget , status, active, message)"
			+ " values(  ?, ?, ?,?, '123 street', ?, 123456.12, 'A', 1, ?  )";

	private final static String SQL_SELECT = " select guid from demo_jdbc_type where lastName=:lastName ";

	private final static String SQL_SELECT_NOLOCK = " select guid from demo_jdbc_type (nolock) where lastName=:lastName ";

	public BaseDao() {
		super();
	}

	public void insertData(String lastname, String firstname, String name, String city, String message,
			JdbcTemplate jdbcTemplate) {
		System.out.println("Start insertData");
		String uuid = java.util.UUID.randomUUID().toString().toUpperCase();

		int count = jdbcTemplate.update(SQL_INSERT, new Object[] { uuid, lastname, firstname, name, city, message });

		System.out.println("End insertData, affected count =" + count);
	}

	public List<String> findGuidsByLastname(NamedParameterJdbcTemplate namedParameterJdbcTemplate, String lastName) {
		System.out.println("Start findGuidsByLastname");

		List<String> ret = namedParameterJdbcTemplate.queryForList(SQL_SELECT,
				Collections.singletonMap("lastName", lastName), String.class);
		System.out.println("End findGuidsByLastname");
		return ret;
	}

	public List<String> findGuidsByLastnameWithNolock(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
			String lastName) {
		System.out.println("Start findGuidsByLastnameWithNolock");
		List<String> ret = namedParameterJdbcTemplate.queryForList(SQL_SELECT_NOLOCK,
				Collections.singletonMap("lastName", lastName), String.class);
		System.out.println("End findGuidsByLastnameWithNolock");
		return ret;

	}

}
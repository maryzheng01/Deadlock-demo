package com.mary.demo.jdbc.spring.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseDao {

	public BaseDao() {
		super();
	}

	public void insertData(String lastname, String firstname, String name,
			String city, String message, JdbcTemplate jdbcTemplate) {
		System.out.println("start insertData");
		String uuid = java.util.UUID.randomUUID().toString().toUpperCase();
		String insertSql = " insert into demo_jdbc_type ( guid, lastName, firstName, name, address, city, budget , status, active, message)"
				+ " values(  ?, ?, ?,?, '123 stree', ?, 123456.12, 'A', 1, ?  )";

		int count = jdbcTemplate.update(insertSql, new Object[] { uuid,
				lastname, firstname, name, city, message });

		System.out.println("end insertData, affected count =" + count);
	}

	public List<String> findGuidsByLastname(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate,
			String lastName) {
		System.out.println("start findGuidsByLastname");
		String sqlIn = "   select   guid from demo_jdbc_type   where lastName=:lastName ";

		List<String> ret = namedParameterJdbcTemplate.queryForList(sqlIn,
				Collections.singletonMap("lastName", lastName), String.class);
		System.out.println("end findGuidsByLastname");
		return ret;
	}

}
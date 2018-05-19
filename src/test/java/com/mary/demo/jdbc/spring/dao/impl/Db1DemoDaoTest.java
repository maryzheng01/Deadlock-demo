package com.mary.demo.jdbc.spring.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mary.demo.jdbc.spring.dao.Db1DemoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/application-context.xml" })
public class Db1DemoDaoTest {

	@Autowired
	private Db1DemoDao dao;

	@Test
	public void test_findByName() {
		List<String> dd = dao.findGuidsByLastname("zheng");
		assertNotNull(dd);
	}

	@Test
	@Transactional
	public void test_findByGuids_PreparedQuery() {
		dao.insertData("lastname", "firstname", "name", "city", "message");
		List<String> dd = dao.findGuidsByLastname("lastname");
		assertNotNull(dd);
	}

}

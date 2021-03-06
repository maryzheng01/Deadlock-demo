package com.mary.demo.jdbc.spring.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mary.demo.jdbc.spring.data.DemoData;
import com.mary.demo.jdbc.spring.service.TransactionOnService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/application-context.xml" })
public class TransactionOnServiceImplTest {

	@Autowired
	private TransactionOnService demoService;

	@Test
	@Transactional(value = "transactionManager")	
	public void test_save() {

		DemoData demoData = new DemoData();
		demoData.setFirstName("FirstName");
		demoData.setLastName("LastName");
		demoData.setCity("Chesterfield");
		demoData.setName("Name");
		demoData.setMessage("Test message from Mary unit2");
		demoService.save(demoData);
		List<String> foundData = demoService.findByLastName("LastName");
		assertTrue(foundData.size() > 0);
		assertTrue(foundData.get(0).length() == 36); //UUID length
	}

	@Test
	@Transactional(value = "transactionManager", isolation = Isolation.READ_UNCOMMITTED)
	// this will not wait for the lock
	public void findByLastName_with_ReadUncommitted_then_noLock() {
		List<String> foundData = demoService.findByLastName("Zheng");
		assertTrue(foundData.size() > 0);
	}

	@Test
	@Transactional
	public void test_findByLastName_stillwaitforlock() {
		List<String> foundData = demoService.findByLastName("Zheng");
		assertTrue(foundData.size() > 0);
	}

	@Test
	@Transactional(isolation = Isolation.DEFAULT)
	public void test_findByLastName_stillwaitforlock_default_stillwaitforlock() {
		List<String> foundData = demoService.findByLastName("Zheng");
		assertTrue(foundData.size() > 0);
	}

	@Test
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void test_findByLastName_stillwaitforlock_committed_stillwaitforlock() {
		List<String> foundData = demoService.findByLastName("Zheng");
		assertTrue(foundData.size() > 0);
	}

	@Test
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public void test_findByLastName_stillwaitforlock_repeat_stillwaitforlock() {
		List<String> foundData = demoService.findByLastName("Zheng");
		assertTrue(foundData.size() > 0);
	}

	@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void test_findByLastName_stillwaitforlock_new_stillwaitforlock() {
		List<String> foundData = demoService.findByLastName("Zheng");
		assertTrue(foundData.size() > 0);
	}

}

package com.mary.demo.jdbc.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mary.demo.jdbc.spring.dao.Db1DemoDao;
import com.mary.demo.jdbc.spring.data.DemoData;

@Service
public class TransactionOnServiceImpl implements TransactionOnService {

	@Autowired
	private Db1DemoDao demoDao;

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_UNCOMMITTED)
	public void save(DemoData demoData) {

		demoDao.insertData(demoData.getLastName(), demoData.getFirstName(),
				demoData.getName(), demoData.getCity(), demoData.getMessage());

		try {
			System.out.println("Sleep for 30 seconds");
			Thread.sleep(30000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 30 seconds

	}

	@Transactional(readOnly = true)
	public List<String> findByLastName(String lastName) {
		return demoDao.findGuidsByLastname(lastName);	
	}

}

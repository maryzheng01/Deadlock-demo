package com.mary.demo.jdbc.spring.dao;

import java.util.List;


public interface Db1DemoDao {
 
    void insertData(String lastname, String firstname, String name, String city, String message);
    
    List<String> findGuidsByLastname(String lastName);
    
    List<String> findGuidsByLastnameNoLock(String lastName);
}

package com.mary.demo.jdbc.spring.dao;

import java.util.List;


public interface Db1DemoTransactionDao {
 
    void insertData(String lastname, String firstname, String name, String city, String message);
    
    List<String> findGuidsByLastname(String lastName);
                   
}

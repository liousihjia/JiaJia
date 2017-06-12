package com.programcreek.helloworld.controller;

import java.util.List;

public interface testDAO {
	public void saveOrUpdate(TestItem i);
    
    public void delete(String i);
     
    public TestItem get(String i);
     
    public List<TestItem> list();
}

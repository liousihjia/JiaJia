package com.programcreek.helloworld.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class testDAOImlp implements testDAO{
    private JdbcTemplate jdbcTemplate;
    
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

 
    public void saveOrUpdate(TestItem i) {
        if (i.getTestId() != null && !i.getTestId().equals("")) {
            // update
            String sql = "UPDATE testTable SET test_name=? WHERE test_id=?";
            jdbcTemplate.update(sql, i.getTestName(), i.getTestId());
        } else {
            // insert
        	java.util.UUID uuid = java.util.UUID.randomUUID();
            String sql = "INSERT INTO testTable (test_id, test_name)"
                        + " VALUES (?, ?)";
            jdbcTemplate.update(sql, uuid, i.getTestName());
        }
    }
 
    public void delete(String i) {
    	String sql = "DELETE FROM testTable WHERE test_id=?";
        jdbcTemplate.update(sql, i);
    }
 
    public List<TestItem> list() {    
    	String sql = "SELECT * FROM testTable";
    List<TestItem> listContact = jdbcTemplate.query(sql, new RowMapper<TestItem>() {
 
        public TestItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        	TestItem TestItem = new TestItem();
 
        	TestItem.setTestId(rs.getString("test_id"));
        	TestItem.setTestName(rs.getString("test_name"));
 
            return TestItem;
        }
 
    });
 
    return listContact;
}
 
    public TestItem get(String i) {    String sql = "SELECT * FROM testTable WHERE test_id='" + i +"'";
    return jdbcTemplate.query(sql, new ResultSetExtractor<TestItem>() {
 
        public TestItem extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            if (rs.next()) {
            	TestItem TestItem = new TestItem();
            	TestItem.setTestId(rs.getString("test_id"));
            	TestItem.setTestName(rs.getString("test_name"));
                return TestItem;
            }
 
            return null;
        }
 
    });
}
}

package org.group8.schoolbus.org.group8.project;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectionUtilTest {
	
	Connection con = ConnectionUtil.conDB();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
	ConnectionUtilTest(){
        con = ConnectionUtil.conDB();
	}
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDatabaseDown() {
		if(con == null)
			fail("Server error");
	}
	
	@Test
	void testDatabaseUp() {
		if(con != null)
			assertTrue(true);
	}

}

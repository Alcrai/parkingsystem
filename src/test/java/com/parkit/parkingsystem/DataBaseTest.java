package com.parkit.parkingsystem;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;


public class DataBaseTest {

	private  DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
	
	Connection con = null;

	@BeforeEach
	public  void setUp() throws Exception {
		

	}

	@Test
	public void getConnectionTest() throws ClassNotFoundException, SQLException {

		con = dataBaseTestConfig.getConnection();
		assertThat(con.isValid(1)).isTrue();
		con.close();

	}

	@Test
	public void closeConnectionTest() throws SQLException, ClassNotFoundException {
		con = dataBaseTestConfig.getConnection();
		dataBaseTestConfig.closeConnection(con);
		assertThat(con.isClosed()).isTrue();
	}
	
	
	
	

}

package com.parkit.parkingsystem;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;

public class TicketDAOTest {

	private DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
	private TicketDAO ticketDAO;
	private Ticket ticket;
	static String vehiculeNumber = "ABCDAO";

	@BeforeEach
	public void setUp() throws Exception {
		Date inTime = new Date();
		Date outTime = new Date();
		ticketDAO = new TicketDAO();
		ticketDAO.dataBaseConfig = dataBaseTestConfig;
		ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
		ticket = new Ticket();
		ticket.setId(1);
		ticket.setParkingSpot(parkingSpot);
		ticket.setInTime(inTime);
		ticket.setOutTime(outTime);
		ticket.setVehicleRegNumber(vehiculeNumber);
		ticket.setPrice(0);

	}

	@AfterEach
	public void tearDown() {
		 
	}

	@Test
	void saveTicketTest() {
		ticketDAO.saveTicket(ticket);
		assertThat(ticketDAO.getTicket(vehiculeNumber).getVehicleRegNumber()).isEqualTo(ticket.getVehicleRegNumber());

	}

	@Test
	void getTicketTest() {
		Ticket ticketTest;
		ticketTest = ticketDAO.getTicket(vehiculeNumber);
		assertThat(ticketTest.getVehicleRegNumber()).isEqualTo(ticket.getVehicleRegNumber());

	}

	@Test
	void updateTicketTest() {
		ticketDAO.updateTicket(ticket);
		assertThat(ticketDAO.getTicket(vehiculeNumber).getOutTime()).isNotEqualTo(ticket.getOutTime());

	}

	@Test
	void isCustomerTest() {
		assertThat(ticketDAO.isCustomer(vehiculeNumber)).isNotNull();
	}

}

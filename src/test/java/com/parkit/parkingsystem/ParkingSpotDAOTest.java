package com.parkit.parkingsystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.util.InputReaderUtil;

@ExtendWith(MockitoExtension.class)
public class ParkingSpotDAOTest {

	private  DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();

	@Mock
	private  InputReaderUtil inputReaderUtil;
	private  ParkingSpotDAO parkingSpotDAO;

	@BeforeEach
	public void setUp() throws Exception {
		parkingSpotDAO = new ParkingSpotDAO();
		parkingSpotDAO.dataBaseConfig = dataBaseTestConfig;

	}

	@AfterEach
	public void tearDown() {

	}

	@Test
	public void getNextAvailableSlotTest() {
		assertThat(parkingSpotDAO.getNextAvailableSlot(ParkingType.CAR)).isNotEqualTo(0);

	}

	@Test
	public void updateParkingTest() {
		ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, true);
		assertThat(parkingSpotDAO.updateParking(parkingSpot)).isTrue();

	}

}

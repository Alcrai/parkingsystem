package com.parkit.parkingsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;


public class ParkingSpotModelTest {
	private  ParkingSpot parkingSpot;
	
	@BeforeEach	public  void  setUp() {
		parkingSpot = new ParkingSpot(1,ParkingType.CAR,true);
	}
	
	@Test
	public void setIdTest() {
		parkingSpot.setId(2);
		assertThat(parkingSpot.getId()).isEqualTo(2);
	}
	
	@Test
	public void equalsTest() {
		assertThat(parkingSpot.equals(parkingSpot)).isEqualTo(true);
	}
	
	@Test
	public void hasCodeTest() {
		assertThat(parkingSpot.hashCode()).isEqualTo(1);
	}
	
	@Test
	public void isAvailableTest() {
		assertThat(parkingSpot.isAvailable()).isEqualTo(true);
	}
	
	
}

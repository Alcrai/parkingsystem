package com.parkit.parkingsystem;

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
		assertThat(parkingSpot.getId(), is(2));
	}
	
	@Test
	public void equalsTest() {
		assertThat(parkingSpot.equals(parkingSpot), is(true));
	}
	
	@Test
	public void hasCodeTest() {
		assertThat(parkingSpot.hashCode(), is(1));
	}
	
	@Test
	public void isAvailableTest() {
		assertThat(parkingSpot.isAvailable(), is(true));
	}
	
	
}

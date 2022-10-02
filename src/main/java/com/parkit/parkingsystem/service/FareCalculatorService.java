package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {

	public void calculateFare(Ticket ticket) {
		if ((ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime()))) {
			throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString());
		}

		long inHour = ticket.getInTime().getTime();
		long outHour = ticket.getOutTime().getTime();

		double duration = ((double) outHour - inHour) / (60 * 60 * 1000);
		
		
		if (free30Min(duration)) {
			ticket.setPrice(0);
		} else {
			switch (ticket.getParkingSpot().getParkingType()) {
				case CAR:
					if (!ticket.isNewCustomer()) {
						ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR * 0.95);
					}else 
					ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR);
					break;
				case BIKE:
					if (!ticket.isNewCustomer()) {
						ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR * 0.95);
					}else 
					ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR);
					break;
				default:
					throw new IllegalArgumentException("Unkown Parking Type");
			}
		}
	}

	public boolean free30Min(double duration) {
		return duration <= 0.5;
	}
}
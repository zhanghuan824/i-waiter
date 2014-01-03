package com.paipai.server.domain;

import com.paipai.server.domain.table.TableCategory;

public class QueueStatus {

	private Restaurant restaurant;
	
	public QueueStatus(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public float getHistoricalVelocity() {
		return 0.0f;
	}
	
	public float getHistoricalVelocity(TableCategory category) {
		return 0.0f;
	}
	
	public float getVelocity() {
		return 0.0f;
	}
	
	public float getVelocity(TableCategory category) {
		return 0.0f;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}
}

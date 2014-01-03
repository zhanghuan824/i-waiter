package com.paipai.server.domain;

import com.paipai.server.domain.table.TableCategory;

public class QueueStatus {

	private Restaurant restaurant;
	
	public QueueStatus(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public int getAverageVelocity() {
		return 0;
	}
	
	public float getVelocity() {
		return 0.0f;
	}
	
	public float getVelocity(TableCategory category) {
		return 0.0f;
	}
}

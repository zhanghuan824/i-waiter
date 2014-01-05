package com.paipai.server.domain;

import javax.xml.bind.annotation.XmlRootElement;

import com.paipai.server.domain.table.TableCategory;

@XmlRootElement
public class QueueStatus {

	private Restaurant restaurant;
	
	public QueueStatus() {}
	
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

package com.paipai.server.domain;

import java.util.Date;

import com.paipai.server.domain.table.TableCategory;

public class Reservation {

	private long id;
	private Restaurant restaurant;
	private Customer customer;
	private int seatsRequired;
	private Date startTime;
	private int globalOrder;
	
	public Reservation(Customer customer, Restaurant restaurant, Date time, int seats) {
		this.customer = customer;
		this.restaurant = restaurant;
		this.startTime = time;
		this.seatsRequired = seats;
	}
	
	public TableCategory getTableCategory() {
		return restaurant.getTableStrategy().getTableCategory(seatsRequired);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getSeatsRequired() {
		return seatsRequired;
	}
	public void setSeatsRequired(int seatsRequired) {
		this.seatsRequired = seatsRequired;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public int getGlobalOrder() {
		return globalOrder;
	}
	public void setGlobalOrder(int globalOrder) {
		this.globalOrder = globalOrder;
	}
	
}

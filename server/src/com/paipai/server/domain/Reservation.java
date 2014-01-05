package com.paipai.server.domain;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.paipai.server.domain.table.TableCategory;

@XmlRootElement
public class Reservation {

	private long id;
	private Restaurant restaurant;
	private Customer customer;
	private int seatsRequired;
	private Date startTime;
	private Date createTime;
	private int globalOrder;
	private ReservationStatusEnum status;
	
	public Reservation() {}
	
	public Reservation(Customer customer, Restaurant restaurant, int seats) {
		this.customer = customer;
		this.restaurant = restaurant;
		this.seatsRequired = seats;
		this.setStatus(ReservationStatusEnum.Pending);
	}
	
	public void start() {
		TableCategory tc = this.restaurant.getTableStrategy().getTableCategory(seatsRequired);
		this.restaurant.getQueue().add(tc, this);
		this.status = ReservationStatusEnum.Inline;
		globalOrder = restaurant.getCallNumber();
		restaurant.addCallNumber();
		this.startTime = Calendar.getInstance().getTime();
	}
	
	public void close() throws Exception {
		TableCategory tc = this.restaurant.getTableStrategy().getTableCategory(seatsRequired);
		Reservation reservationToRemove = this.restaurant.getQueue().remove(tc, this);
		if(reservationToRemove == null) {
			this.status = ReservationStatusEnum.Invalid;
			String msg = String.format("No reservation {0} to close", id);			
			throw new Exception(msg);
		} else {
			this.status = ReservationStatusEnum.Dining;
		}
	}
	
	public void quit() throws Exception {
		TableCategory tc = this.restaurant.getTableStrategy().getTableCategory(seatsRequired);
		Reservation reservationToRemove = this.restaurant.getQueue().remove(tc, this);
		if(reservationToRemove == null) {
			this.status = ReservationStatusEnum.Invalid;
			String msg = String.format("No reservation {0} to quit", id);			
			throw new Exception(msg);
		} else {
			this.status = ReservationStatusEnum.Quit;
		}
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

	public ReservationStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ReservationStatusEnum status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}	
}

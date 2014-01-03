package com.paipai.server.domain;

import com.paipai.server.domain.queue.PaipaiQueue;
import com.paipai.server.domain.table.TableCategory;

public class ReservationStatus {

	private Reservation reservation;
	private int minuteForcast;
	private int internalOrder;
	private int order;
	
	public ReservationStatus(Reservation reservation) {
		this.reservation = reservation;
		this.query();
	}
	
	public void query() {
		this.internalOrder = this.queryInternalOrder();
		this.order = this.queryOrder();
		
		Restaurant restaurant = this.reservation.getRestaurant();
		TableCategory tc = restaurant.getTableStrategy().getTableCategory(this.reservation.getSeatsRequired());
		this.minuteForcast = Math.round(restaurant.getQueueStatus().getVelocity(tc) * internalOrder);
	}
	
	public int getOrder() {
		return this.order;
	}
	
	public int getInternalOrder() {
		return this.internalOrder;
	}
	
	private int queryOrder() {
		int order = 0;
		PaipaiQueue queue = reservation.getRestaurant().getQueue();
		Reservation[] array = queue.getReservationsInGlobalOrder();
		for(Reservation r : array) {
			order++;
			if(r.equals(this)) {
				return order;
			}
		}		
		return 0;
	}
	
	private int queryInternalOrder() {
		int order = 0;
		Restaurant restaurant = reservation.getRestaurant();
		TableCategory tc = restaurant.getTableStrategy().getTableCategory(reservation.getSeatsRequired());
		PaipaiQueue queue = restaurant.getQueue();
		Reservation[] array = (Reservation[])queue.getInternalQueues().get(tc).getReservations().toArray();
		for(Reservation r : array) {
			order++;
			if(r.equals(this)) {
				return order;
			}
		}		
		return 0;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public int getMinuteForcast() {
		return minuteForcast;
	}
}

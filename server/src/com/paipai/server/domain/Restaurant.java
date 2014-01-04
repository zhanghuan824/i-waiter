package com.paipai.server.domain;

import java.util.List;

import com.paipai.server.domain.basic.Location;
import com.paipai.server.domain.queue.PaipaiQueue;
import com.paipai.server.domain.table.Table;
import com.paipai.server.domain.table.TableCategoryStrategy;

public class Restaurant {

	private long id;
	private String name;
	private Location location;
	private RestaurantType type;
	private List<Table> tables;
	private String telPhoneNumber;
	private String mobileNumber;
	private String contactPerson;
	private PaipaiQueue queue;
	private QueueStatus queueStatus;
	private TableCategoryStrategy tableStrategy;
	private int callNumber = 0; //Ã¿Ìì½ÐºÅ
	private String barCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public RestaurantType getType() {
		return type;
	}
	public void setType(RestaurantType type) {
		this.type = type;
	}
	public List<Table> getTables() {
		return tables;
	}
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	public String getTelPhoneNumber() {
		return telPhoneNumber;
	}
	public void setTelPhoneNumber(String telPhoneNumber) {
		this.telPhoneNumber = telPhoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public PaipaiQueue getQueue() {
		return queue;
	}
	public void setQueue(PaipaiQueue queue) {
		this.queue = queue;
	}
	public TableCategoryStrategy getTableStrategy() {
		return tableStrategy;
	}
	public void setTableStrategy(TableCategoryStrategy tableStrategy) {
		this.tableStrategy = tableStrategy;
	}
	public int getCallNumber() {
		return callNumber;
	}
	public synchronized void addCallNumber() {
		callNumber++;
	}
	public synchronized void clearCallNumber() {
		callNumber = 0;
	}
	
	public ReservationStatus requestReservation(Customer customer, int diners) {
		Reservation reservation = new Reservation(customer, this, diners);
		reservation.start();
		ReservationStatus rs = new ReservationStatus(reservation);
		return rs;
	}
	public QueueStatus getQueueStatus() {
		return queueStatus;
	}
	public void setQueueStatus(QueueStatus queueStatus) {
		this.queueStatus = queueStatus;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
}

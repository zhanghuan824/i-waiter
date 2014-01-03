package com.paipai.server.domain.queue;

import java.util.HashMap;
import java.util.Queue;

import com.paipai.server.domain.Reservation;
import com.paipai.server.domain.table.TableCategory;

public class PaipaiQueue {
	private HashMap<TableCategory, InternalQueue> internalQueues;
	
	public class InternalQueue {
		Queue<Reservation> customers;
		int order;
		
		public boolean add(Reservation c) {
			return customers.add(c);
		}
		
		public Reservation remove() {
			return customers.remove();
		}
		
		public int getOrder() {
			return order;
		}
		
		public void setOrder(int order) {
			this.order = order;
		}
		
		public Queue<Reservation> getCustomers() {
			return customers;
		}
		
		public void setCustomers(Queue<Reservation> customers) {
			this.customers = customers;
		}
	}

	public HashMap<TableCategory, InternalQueue> getInternalQueues() {
		return internalQueues;
	}

	public void setInternalQueue(HashMap<TableCategory, InternalQueue> internalQueues) {
		this.internalQueues = internalQueues;
	}
	
	public int getAmountInLine() {
		return 0;
	}
	
	public boolean add(TableCategory category, Reservation c) {
		return this.internalQueues.get(category).add(c);
	}
	
	public Reservation remove(TableCategory category) {
		return this.internalQueues.get(category).remove();
	}
}

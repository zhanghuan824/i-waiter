package com.paipai.server.domain.queue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;

import com.paipai.server.domain.Reservation;
import com.paipai.server.domain.table.TableCategory;

public class PaipaiQueue {
	private HashMap<TableCategory, InternalQueue> internalQueues;
	
	public class InternalQueue {
		Queue<Reservation> reservations;
		
		public synchronized boolean add(Reservation c) {
			return reservations.add(c);
		}
		
		public synchronized Reservation remove(Reservation reservation) {
			if(reservations.remove(reservation) == true)
				return reservation;
			return null;
		}
		
		public Reservation[] toArray() {
			return (Reservation[])reservations.toArray();
		}
		
		public Queue<Reservation> getReservations() {
			return reservations;
		}
		
		public void setReservations(Queue<Reservation> reservations) {
			this.reservations = reservations;
		}
		
		public int getDinersInLine() {
			return reservations.size();
		}
	}

	public HashMap<TableCategory, InternalQueue> getInternalQueues() {
		return internalQueues;
	}

	public void setInternalQueue(HashMap<TableCategory, InternalQueue> internalQueues) {
		this.internalQueues = internalQueues;
	}
	
	public Reservation[] getReservationsInGlobalOrder() {
		TableCategory[] keys = (TableCategory[])internalQueues.keySet().toArray();
		int count = keys.length;
		
		if(count == 0) return null;
		
		Reservation[][] q = new Reservation[count][];
		for(int i = 0; i < count; i++) {			
			q[i] = (Reservation[])((InternalQueue)internalQueues.get(keys[i])).getReservations().toArray();
		}
		
		if(count == 1) {
			return q[0];
		} else {
			int j = 1;
			Reservation[] array = q[0];
			while(j < count) {
				array = mergeSort(array, q[j]);
				j++;
			}
			return array;
		}
	}
	
	private Reservation[] mergeSort(Reservation[] q1, Reservation[] q2) {
		Reservation[] q = new Reservation[q1.length + q2.length];
		int i=0, j=0, k = 0;
		while(i < q1.length && j < q2.length && k < q.length) {
			if(q1[i].getGlobalOrder() < q2[j].getGlobalOrder()) {
				q[k] = q1[i];
				i++;
			} else {
				q[k] = q2[j];
				j++;
			}
			k++;
		}
		while(i < q1.length && k < q.length) {
			q[k] = q1[i];
			k++; i++;
		}
		while(j < q2.length && k < q.length) {
			q[k] = q2[j];
			k++; j++;
		}
		return q;
	}
	
	public int getDinersInLine() {
		int total = 0;
		Iterator<TableCategory> it = internalQueues.keySet().iterator();
		while(it.hasNext()) {
			total += internalQueues.get(it.next()).getDinersInLine();
		}
		return total;
	}
	
	public boolean add(TableCategory category, Reservation c) {
		return this.internalQueues.get(category).add(c);
	}
	
	public Reservation remove(TableCategory category, Reservation reservation) {
		return this.internalQueues.get(category).remove(reservation);
	}
}

package com.paipai.server.domain.table;

public class Table {

	private TableCategory category;
	private int amount;
	
	public Table(TableCategory category, int amount) {
		this.category = category;
		this.setAmount(amount);
	}

	public TableCategory getCategory() {
		return category;
	}

	public void setCategory(TableCategory category) {
		this.category = category;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

package com.paipai.server.domain.table;

public class Table {

	private TableCategory category;
	
	public Table(TableCategory category) {
		this.category = category;
	}

	public TableCategory getCategory() {
		return category;
	}

	public void setCategory(TableCategory category) {
		this.category = category;
	}
	
}

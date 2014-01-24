package com.paipai.client.data;

import android.R.string;

public class RestaurantItem {
	private string _name;
	private byte _rate;
	private float _price;
	private string _address;

	public string getName() {
		return _name;
	}

	public void setName(string restaurantName) {
		_name = restaurantName;
	}
	public byte getRate() {
		return _rate;
	}
	public void setRate(byte rate) {
		_rate=rate;
	}
	public double getAveragePrice() {
		return _price;
	}
	public void setAveragePrice(float price) {
		_price=price;
	}
	public string getAddress() {
		return _address;
	}
	public void setAddress(string address) {
		_address=address;
	}
}

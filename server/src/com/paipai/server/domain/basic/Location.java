package com.paipai.server.domain.basic;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
	
	private long id;
	private String province;
	private String city;
	private String district;	
	private String address; //œÍœ∏µÿ÷∑
	private float longitude = 0.0f;
	private float latitude = 0.0f;
	
	public Location() {}
	
	public Location(long id, 
			String province,
			String city,
			String district,
			String address) {
		this.setId(id);
		this.setProvince(province);
		this.setCity(city);
		this.setDistrict(district);
		this.setAddress(address);
	}
	
	public float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public float getLatitude() {
		return latitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setProvince(String province) {
		this.province = province;
	}


	public String getProvince() {
		return province;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCity() {
		return city;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getDistrict() {
		return district;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddress() {
		return address;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
}

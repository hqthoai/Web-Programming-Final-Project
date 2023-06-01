package com.maneyshop.model;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shippinginfo")
public class ShippingInfo {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shippingID;
	
    private String shipppingAddress;
     
    private double shippingCost;
    
    private String shippingPhone;

	public ShippingInfo() {
		super();
	}

	public ShippingInfo(String shipppingAddress, double shippingCost, String shippingPhone) {
		super();
		this.shipppingAddress = shipppingAddress;
		this.shippingCost = shippingCost;
		this.shippingPhone = shippingPhone;
	}

	public int getShippingID() {
		return shippingID;
	}

	public void setShippingID(int shippingID) {
		this.shippingID = shippingID;
	}

	public String getShipppingAddress() {
		return shipppingAddress;
	}

	public void setShipppingAddress(String shipppingAddress) {
		this.shipppingAddress = shipppingAddress;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

    
    
}

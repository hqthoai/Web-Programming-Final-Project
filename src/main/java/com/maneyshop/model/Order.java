package com.maneyshop.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "`order`")
public class Order {
	private static final long serialVersionUID = 5974334775305260216L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String deliveryStatus;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne
    @JoinColumn(name = "account_id")
	private Account customer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shippingInfo_id")
	private ShippingInfo shippingInfo;
	
	private Date orderDate;
	private long totalAmount;
	
	
	public Order() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Account getCustomer() {
		return customer;
	}
	public void setCustomer(Account customer) {
		this.customer = customer;
	}
	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

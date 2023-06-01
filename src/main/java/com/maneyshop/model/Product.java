package com.maneyshop.model;

import java.io.Serializable;
import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "productID")
	private String productID;

	@Column(name = "postedData")
	private String postedData;

	@Column(name = "productCost")
	private long productCost;

	@Column(name = "productName")
	private String productName;

	@Column(name = "productDes")
	private String productDes;

	@Column(name = "productBrand")
	private String productBrand;

	@Column(name = "productImage")
	private String productImage;

	@Column(name = "sellerID")
	private String sellerID;

	public Product() {
		super();
	}

	public Product(String productID, String postedData, long productCost, String productName, String productDes,
			String productBrand, String productImage, String sID) {
		super();
		this.productID = productID;
		this.postedData = postedData;
		this.productCost = productCost;
		this.productName = productName;
		this.productDes = productDes;
		this.productBrand = productBrand;
		this.productImage = productImage;
		this.sellerID = sID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getPostedData() {
		return postedData;
	}

	public void setPostedData(String postedData) {
		this.postedData = postedData;
	}

	public long getProductCost() {
		return productCost;
	}

	public void setProductCost(long productCost) {
		this.productCost = productCost;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public String getPriceCurrencyFormat() {
		String formattedCost = String.format("%,d đ", productCost);
		return formattedCost;
	}

}
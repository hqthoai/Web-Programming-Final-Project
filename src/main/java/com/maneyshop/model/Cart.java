package com.maneyshop.model;

import java.io.Serializable;
import java.util.List;
import java.util.TreeSet;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="cart")
public class Cart implements Serializable {
	/**
	 * 
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private static final long serialVersionUID = 5974334775305260216L;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity=LineItem.class)
	private List<LineItem> items;
	
	@Column(name="cusId")
	private int cusId;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	public Cart() {
       
    }
	public Cart(List<LineItem> items) {
	       this.items = items;
    }

	public List<LineItem> getItems() {
	    return (List<LineItem>)items;
	}

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem item) {
        String code = item.getProduct().getProductID();
        int quantity = item.getQuantity();
        for (LineItem cartItem : items) {
            if (cartItem.getProduct().getProductID().equals(code)) {
                cartItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        String code = item.getProduct().getProductID();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getProductID().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
    public long getTotalPrice() {
        long totalPrice = 0;
        for (LineItem lineItem : items) {
            totalPrice += lineItem.getTotal();
        }
        return totalPrice;
    }
}
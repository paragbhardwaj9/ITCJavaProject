package com.itc.service;

import java.util.List;

import com.itc.bean.Item;
import com.itc.bean.Order;

public interface ShoppingService {
	   public List<Item> getItems();


	public Item getItem(int gid);

	public Order placeOrder(Order order);

}

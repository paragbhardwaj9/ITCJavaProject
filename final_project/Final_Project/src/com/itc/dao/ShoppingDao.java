package com.itc.dao;

import java.util.List;

import com.itc.bean.Item;
import com.itc.bean.Order;

public interface ShoppingDao {
	
	   public List<Item> getItems();

	public Item getItem(int gid);

	public Order placeOrder(Order order);

}

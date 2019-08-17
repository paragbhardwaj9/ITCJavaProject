package com.itc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.bean.Item;
import com.itc.bean.Order;
import com.itc.dao.ShoppingDao;


@Service
public class ShoppingServiceImpl implements ShoppingService{
	@Autowired
	private ShoppingDao sDao;

	@Override
	public List<Item> getItems() {
		return sDao.getItems();
	}

	@Override
	public Item getItem(int gid) {
		// TODO Auto-generated method stub
		return sDao.getItem(gid);
	}

	@Override
	public Order placeOrder(Order order) {
		// TODO Auto-generated method stub
		return sDao.placeOrder(order);
	}

}

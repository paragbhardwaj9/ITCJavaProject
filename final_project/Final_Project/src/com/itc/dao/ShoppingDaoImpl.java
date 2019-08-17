package com.itc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itc.bean.Item;
import com.itc.bean.Order;

@Service
@Transactional
@Repository
public class ShoppingDaoImpl implements ShoppingDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Item> getItems() {
		String sql = "select item from Item item";
		TypedQuery<Item> query = entityManager.createQuery(sql,Item.class);
		return query.getResultList();
	}

	@Override
	public Item getItem(int gid) {
		Item item = null;
		item = entityManager.find(Item.class,gid);
		return item;
	}

	@Override
	public Order placeOrder(Order order) {
		entityManager.persist(order);
		return order;
	}

}

package com.itc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itc.bean.Item;
import com.itc.bean.Order;
import com.itc.service.ShoppingService;

@Controller
public class ShoppingController {
	@Autowired
	private ShoppingService shopService;
	private List<Item> sList;
	private List<Order> oList;

	@RequestMapping(value = "/items")
	public String getItems(Model model) {
		sList = shopService.getItems();
		model.addAttribute("slist", sList);
		return "buyItems";

	}
	
	@RequestMapping(value="/buyItem")
	public String buyItem(Model model,@RequestParam("itemid") int gid){
		Item item = shopService.getItem(gid);
		model.addAttribute("item", item);
		model.addAttribute("itemid", gid);
		return "buyForm";
		
	}
	
	@RequestMapping(value="/confirmBuyItem")
	String placeOrder(Model model,@ModelAttribute(value="item")@Valid Item item,@RequestParam("req") int req){
		Order order = new Order();
		order.setItemId(item.getId());
		order.setQuantity(req);
		model.addAttribute("order", order);
		return "orderForm";
		
	}
	
	@RequestMapping(value="/confirmorder")
	public String confirmOrder(Model model,@ModelAttribute(value="order")@Valid Order order){
		Order newOrder =   shopService.placeOrder(order);
		if(newOrder==null){
			return"orderFail";
		}
		else{
			model.addAttribute("orderid", newOrder.getId());
			return"Success";
		}
	}

}

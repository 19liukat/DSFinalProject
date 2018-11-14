package application.Restaurants;

import application.Item;
import application.Lists.ArrayIndexedList;

public class Restaurant1ItemList {

	ArrayIndexedList<Item> itemList;
	//String name, String description, String type, double price
	public Restaurant1ItemList(){
		itemList = new ArrayIndexedList<Item>();
		Item item1 = new Item("Mango Tango", "salmon*, mango, edamame, avocado, cilantro, thai chili ginger, sweet shoyu, crispy onion, tobiko", "Entree", 10.95);
		Item item2 = new Item("Spicy Tuna", "ahi tuna*, edamame, jalapeno, cucumber, sriracha aioli, sweet shoyu, crispy onion, tobiko", "Entree", 10.95);
		Item item3 = new Item("Curry Coconut Shrimp", "shrimp, mango, cilantro, carrots, toasted coconut, curry aioli, crispy onion", "Entree", 9.95);
		Item item4 = new Item("Cilantro Chicken", "chicken, edamame, carrots, kale, thai chili ginger, cilantro lime, crispy onion", "Entree", 10.95);
		Item item5 = new Item("Zen Bowl", "shiitake, sweet potato, avocado, carrots, cucumbers, daikon, cilantro lime, classic sauce", "Entree", 10.95);
		Item item6 = new Item("Seaweed Salad", "cucumbers, tobiko", "Side", 3.95);
		Item item7 = new Item("Truffle Crab Salad", "gluten-free rice crackers", "Side", 3.95);
		itemList.add(item1);	
		itemList.add(item2);	
		itemList.add(item3);	
		itemList.add(item4);	
		itemList.add(item5);	
		itemList.add(item6);	
		itemList.add(item7);	
	}
	public ArrayIndexedList<Item> getList(){
		return itemList;
	}
}

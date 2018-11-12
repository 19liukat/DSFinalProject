package application;

public class Item {
	private String name;
	private String description;
	private String type;
	private double price;
	
	public Item() {
		name="";
		description="";
		type="";
		price=0;
	}
	public Item(String name, String description, String type, double price) {
		this.name=name;
		this.description=description;
		this.type=type;
		this.price=price;
	}
	
}



public class Item {
	private String item; // pizza, chicken, sandwich, side, sauce, drink, or dessert
	private String type; // type of pizza, chicken, etc.
	private String size; // size of pizza or drink
	private String crust; // pizza only
	private int quantity;
	
	// pizza
	public Item(String item, String type, String size, String crust, int quantity) {
		this.item = item;
		this.type = type;
		this.size = size;
		this.crust = crust;
		this.quantity = quantity;
	}
	
	// chicken, sandwich, side, sauce, dessert
	public Item(String item, String type, int quantity) {
		this.item = item;
		this.type = type;
		this.quantity = quantity;
	}
		
	// drinks
	public Item(String item, String type, String size, int quantity) {
		this.item = item;
		this.type = type;
		this.size = size;
		this.quantity = quantity;
	}
	
	public String getItem() {
		return item;
	}
	
	public String getType() {
		return type;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getCrust() {
		return crust;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setCrust(String crust) {
		this.crust = crust;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public String toString() {
		String string = "";
		if (item.equals("Pizza")) {
			string = size + " " + crust + " " + type;
		} else if (item.equals("Chicken") || item.equals("Sandwich") || item.equals("Side")
				|| item.equals("Sauce") || item.equals("Dessert")) {
			string = type; 
		} else if (item.equals("Drink")) {
			string = type + " " + size;
		}
		return string;
	}
	
}

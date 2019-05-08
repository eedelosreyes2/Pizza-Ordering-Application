

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PizzaDatabase {
	private List<Item> items;

	public PizzaDatabase() {
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public int getSize() {
		return items.size();
	}
	
	public void setItemQuantity(String item, int quantity) {
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item i = it.next();
			if (i.toString().equals(item)) {
				i.setQuantity(quantity);
			}
		}
	}
	
	public void removeItem(Item item) {
		if (items.contains(item)) {
			items.remove(item);
		}
	}
	
	public void removeItem(String removeItem) {
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item item = it.next();
			if (item.toString().equals(removeItem)) {
				it.remove();
			}
		}
	}
	
	public void clearItems() {
		items.clear();
	}
	
	public void combineItems() {
		if (items.size() > 1) {
			for (int i = 0; i < items.size(); i++) {
				for (int j = i + 1; j < items.size(); j++) {
					Item item1 = items.get(i);
					Item item2 = items.get(j);
					
					// pizzas
					if (item1.getItem().equals("Pizza") &&
							item1.getItem().equals(item2.getItem()) &&
							item1.getType().equals(item2.getType()) &&
							item1.getSize().equals(item2.getSize()) &&
							item1.getCrust().equals(item2.getCrust())) {
						item1.setQuantity(item1.getQuantity() + item2.getQuantity());
						removeItem(item2);
					}
					
					// chicken
					if (item1.getItem().equals("Chicken") &&
							item1.getItem().equals(item2.getItem()) &&
							item1.getType().equals(item2.getType())) {
						item1.setQuantity(item1.getQuantity() + item2.getQuantity());
						removeItem(item2);
					}
					
					// sandwich
					if (item1.getItem().equals("Sandwich") &&
							item1.getItem().equals(item2.getItem()) &&
							item1.getType().equals(item2.getType())) {
						item1.setQuantity(item1.getQuantity() + item2.getQuantity());
						removeItem(item2);
					}
					
					//side
					if (item1.getItem().equals("Side") &&
							item1.getItem().equals(item2.getItem()) &&
							item1.getType().equals(item2.getType())) {
						item1.setQuantity(item1.getQuantity() + item2.getQuantity());
						removeItem(item2);
					}
					
					// sauce
					if (item1.getItem().equals("Sauce") &&
							item1.getItem().equals(item2.getItem()) &&
							item1.getType().equals(item2.getType())) {
						item1.setQuantity(item1.getQuantity() + item2.getQuantity());
						removeItem(item2);
					}
					
					// drinks
					if (item1.getItem().equals("Drink") &&
							item1.getItem().equals(item2.getItem()) &&
							item1.getType().equals(item2.getType()) &&
							item1.getSize().equals(item2.getSize())) {
						item1.setQuantity(item1.getQuantity() + item2.getQuantity());
						removeItem(item2);
					}
					
					// dessert
					if (item1.getItem().equals("Dessert") &&
							item1.getItem().equals(item2.getItem()) &&
							item1.getType().equals(item2.getType())) {
						item1.setQuantity(item1.getQuantity() + item2.getQuantity());
						removeItem(item2);
					}
				}
			}
		}
	}
	
	public String cartAsString() {
		String cart = "";
		for (Item item : items) {
			cart += '\n';
			cart += item.getQuantity() + ": " + item.toString();
		}
		return cart;
	}
	
	public void printCart() {
		Iterator<Item> it = iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		} System.out.println();
	}
	
	public Iterator<Item> iterator() {
		return items.iterator();
	}
	
}


package application;
// Omar Suliman Alfoqahaa 1200207 sec1 
public class ToGo extends PizzaOrder {  // ToGo class extends PizzaOrder class

	public ToGo() {   // defult constructor
		super();
		
	}

	public ToGo(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {  //constructor with inheritance
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		
	}
	
	public double calculateOrderPrice() { //calculate Order Price method that was Overrided
		
		return super.calculateOrderPrice();
	}

}

package application;
// Omar Suliman Alfoqahaa 1200207 sec1 
public class Seated extends PizzaOrder { // the class Seated extends PizzaOrder class

	double serviceCharge; // declare variables
	int numberOfPeople;

	public Seated() {     //defult constructor
		super();
	}

	public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge,int numberOfPeople) {   //constructor with inheritance
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.serviceCharge = serviceCharge;
		this.numberOfPeople = numberOfPeople;
	}

	public double calculateOrderPrice() { //calculate Order Price method that was Overrided

		return super.calculateOrderPrice() + (serviceCharge * numberOfPeople);

	}

}

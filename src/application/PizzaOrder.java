package application;
// Omar Suliman Alfoqahaa 1200207 sec1 
import java.util.*;

public class PizzaOrder implements Comparable<PizzaOrder> {  // the class PizzaOrder implements Comparable 

	private String customerName; //declare variables
	private Date dateOrdered;
	private int pizzaSize;
	final static int SMALL = 1, MEDIUM = 2, LARGE = 3;
	private int numberOfToppings;
	private double toppingPrice;

	public PizzaOrder() {  // defult constructor
		super();
	}

	public PizzaOrder(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) { // constructor using fields
		super();
		this.customerName = customerName;
		dateOrdered = new Date();
		this.pizzaSize = pizzaSize;
		this.numberOfToppings = numberOfToppings;
		this.toppingPrice = toppingPrice;
	}
    
	// getters & setters
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public int getNumberOfToppings() {
		return numberOfToppings;
	}

	public void setNumberOfToppings(int numberOfToppings) {
		this.numberOfToppings = numberOfToppings;
	}

	public double getToppingPrice() {
		return toppingPrice;
	}

	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}

	public String toString() {  // overrides java.lang.Object.toString
		return customerName + "\t " + calculateOrderPrice();

	}

	public int getPizzaSize() {
		return pizzaSize;
	}
	
	public void setPizzaSize(int pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public double calculateOrderPrice() {   //calculate Order Price method

		return (numberOfToppings * toppingPrice) * pizzaSize;
	}

	public void printOrderInfo() { // printOrderInfo method
		System.out.print(customerName + "  your order price is : " + calculateOrderPrice());

	}

	@Override
	public int compareTo(PizzaOrder o) {  // compareTo method 
		if (calculateOrderPrice() > o.calculateOrderPrice()) {
			return 1;
		}
		if (calculateOrderPrice() < o.calculateOrderPrice()) {
			return -1;
		}
		return 0;

	}

}

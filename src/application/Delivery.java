package application;
// Omar Suliman Alfoqahaa 1200207 sec1 
public class Delivery extends PizzaOrder {    //the class Delivery extends PizzaOrder class

	private double tripRate; //declare variables
	private int zone; 

	public Delivery() {   //defult constructor 
		super();
	}

	public Delivery(double tripRate, int zone) { // Delivery constructor
		super();
		this.tripRate = tripRate;
		this.zone = zone;
	}

	public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate,int zone) { //constructor with inheritance
		
		super(customerName, pizzaSize, numberOfToppings, toppingPrice); 
		this.tripRate = tripRate;
		this.zone = zone;
	}
// getters & setters
	public double getTripRate() {
		return tripRate;
	}

	public void setTripRate(double tripRate) {
		this.tripRate = tripRate;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public double calculateOrderPrice() {     //calculateOrderPrice method
		return super.calculateOrderPrice() + (tripRate / 100 * super.calculateOrderPrice() * zone);

	}

	@Override
	public String toString() {  //toString method that was Overrided
		String size = "";
		if (getPizzaSize() == 1) //if statment to set the size is typed as a String not number
			size = "small";
		else if (getPizzaSize() == 2)
			size = "Midum";
		else if (getPizzaSize() == 3)
			size = "large";
		
		return "Customer Name = " + getCustomerName() +"\nDate Ordered = "
		+ getDateOrdered() +"\nPizza Size = " + size+"\nNumber of Toppings = "
				+ getNumberOfToppings()+"\nTopping Price="
						+ getToppingPrice()+ "\nTrip Rate = " + tripRate +"\nZone = " + zone + "\nOrder price="+calculateOrderPrice() +"\n";
		
	}

}

// Omar Suliman Alfoqahaa 1200207 sec1 
package application;

import java.util.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Main extends Application {

	ArrayList<PizzaOrder> pizzes = new ArrayList<>();  // array list dec.

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Alfoqhaa pizza"); // for title
		Label name = new Label("coustmer name ");
		TextField t1 = new TextField();
		HBox h = new HBox();
		h.setAlignment(Pos.CENTER);
		h.getChildren().addAll(name, t1);

		Label pizzaSize = new Label("pizza Size"); //label 

		HBox h2 = new HBox();
		h2.setSpacing(10);
		h2.setAlignment(Pos.CENTER);
		RadioButton b1 = new RadioButton("To Go");    // Radio Button for ordar tybe
		RadioButton b2 = new RadioButton("Delivery");
		RadioButton b3 = new RadioButton("Seated");
		b1.setSelected(true); //by defult 
		ToggleGroup to = new ToggleGroup();
		to.getToggles().addAll(b1, b2, b3); //get Toggles method 

		HBox h3 = new HBox();
		h3.setSpacing(10);
		h3.setAlignment(Pos.CENTER);
		RadioButton c1 = new RadioButton("SMALL");   // Radio Button for size 
		RadioButton c2 = new RadioButton("MEDIUM");
		RadioButton c3 = new RadioButton("LARGE");
		c1.setSelected(true); //by defult
		ToggleGroup too = new ToggleGroup();  //get Toggles method 
		too.getToggles().addAll(c1, c2, c3);  

		Label ListOfToppings = new Label("List Of Toppings "); // label
		HBox h7 = new HBox();
		h7.setAlignment(Pos.CENTER);
		h7.getChildren().addAll(ListOfToppings);

		HBox h6 = new HBox();
		h6.setSpacing(10);
		h6.setAlignment(Pos.CENTER);
		CheckBox o1 = new CheckBox("Onions");   // Check Box for Addition 
		CheckBox o2 = new CheckBox("Olives");
		CheckBox o3 = new CheckBox("Green Peppers");

		Label numTopping = new Label("number of toppings  "); //label
		TextField numToppingT = new TextField();
		numToppingT.setText("10");  //by defult 
		HBox h13 = new HBox();
		h13.setAlignment(Pos.CENTER);
		h13.getChildren().addAll(numTopping, numToppingT);

		Label toppingPrice = new Label("topping Price ");  // label 
		TextField t2 = new TextField();
		t2.setText("10");
		HBox h1 = new HBox();
		h1.setAlignment(Pos.CENTER);
		h1.getChildren().addAll(toppingPrice, t2);

		Label orderPrice = new Label("order Price"); // label
		TextField t3 = new TextField();
		t3.setText("0");
		HBox h8 = new HBox();
		h8.getChildren().addAll(orderPrice, t3);
		h8.setAlignment(Pos.CENTER);

		HBox h4 = new HBox();
		h4.setAlignment(Pos.CENTER);
		h4.setLayoutY(250);  
		Button p1 = new Button("Process Order");  //Button
		Button p2 = new Button("Print Orders");
		
		p2.setOnAction(e->{   // Print Orders by p2 Button from pizzes Array list 
			Collections.sort(pizzes);
			Stage s = new Stage();
			TextArea t = new TextArea(pizzes.toString());
			Scene scene = new Scene(t);
			s.setScene(scene);
			s.show();
		});
		Button p3 = new Button("Reset"); // Button
		 // sort ////////////////////////////////////////////////////////////////////////////
		p3.setOnAction(e -> pizzes.clear());  //clear by p2 Button from pizzes Array list
		h4.setSpacing(10);
		h4.getChildren().addAll(p1, p2, p3);

		VBox box = new VBox(10, h, pizzaSize, h2, h3, h7, h6, h13, h1, h8, h4);   // sort in in vertical box 
		box.setAlignment(Pos.CENTER);

		Label tripRate = new Label("Trip Rate"); //label 
		TextField tripRateT = new TextField(); //Text Field
		tripRateT.setText("0");
		HBox h10 = new HBox();
		h10.getChildren().addAll(tripRate, tripRateT);
		h10.setAlignment(Pos.CENTER);

		Label zone = new Label("Zone");
		TextField zoneT = new TextField();
		zoneT.setText("0");
		HBox h9 = new HBox();
		h9.getChildren().addAll(zone, zoneT);
		h9.setAlignment(Pos.CENTER);

		b2.setOnAction(e -> {   // open new field 
			if (box.getChildren().size() == 10) {
				box.getChildren().add(3, h9);
				box.getChildren().add(4, h10);
			} else {
				box.getChildren().set(3, h9);
				box.getChildren().set(4, h10);
			}
		});

		b1.setOnAction(e -> {   // remove field 
			if (box.getChildren().size() > 10) { //sort
				box.getChildren().remove(3);
				box.getChildren().remove(3);
			}
		});

		Label serviceCharge = new Label("Service Charge");
		TextField serviceChargeT = new TextField();
		serviceChargeT.setText("0");
		HBox h11 = new HBox();
		h11.getChildren().addAll(serviceCharge, serviceChargeT);
		h11.setAlignment(Pos.CENTER);

		Label numberOfPeople = new Label("number Of People"); //label
		TextField numberOfPeopleT = new TextField();
		numberOfPeopleT.setText("0"); //by defult
		HBox h12 = new HBox();
		h12.getChildren().addAll(numberOfPeople, numberOfPeopleT);
		h12.setAlignment(Pos.CENTER);

		b3.setOnAction(e -> { // open new field
			if (box.getChildren().size() == 10) {
				box.getChildren().add(3, h11);
				box.getChildren().add(4, h12);
			} else {
				box.getChildren().set(3, h11);
				box.getChildren().set(4, h12);
			}
		});

		p1.setOnAction(e -> { // for size 
			int size;
			if (c1.isSelected())
				size = PizzaOrder.SMALL;
			else if (c2.isSelected())
				size = PizzaOrder.MEDIUM;
			else
				size = PizzaOrder.LARGE;

			PizzaOrder oreder; 
			if (b1.isSelected())
				oreder = new ToGo(t1.getText(), size, Integer.parseInt(numToppingT.getText()),
						Integer.parseInt(t2.getText()));
			else if (b2.isSelected())
				oreder = new Delivery(t1.getText(), size, Integer.parseInt(numToppingT.getText()),
						Integer.parseInt(t2.getText()), Double.parseDouble(tripRateT.getText()),
						Integer.parseInt(zoneT.getText()));
			else
				oreder = new Seated(t1.getText(), size, Integer.parseInt(numToppingT.getText()),
						Integer.parseInt(t2.getText()), Double.parseDouble(serviceChargeT.getText()),
						Integer.parseInt(numberOfPeopleT.getText()));

			t3.setText(oreder.calculateOrderPrice() + "");
			pizzes.add(oreder);
		});

		h2.getChildren().addAll(b1, b2, b3);
		h3.getChildren().addAll(c1, c2, c3);
		h6.getChildren().addAll(o1, o2, o3);

		Scene s = new Scene(box, 500, 500); //Scene
		primaryStage.setScene(s);
		
		primaryStage.show();  // show 
	}

	public static void main(String[] args) {
		launch();
	}
}

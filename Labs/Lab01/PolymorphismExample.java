
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

 

public class PolymorphismExample extends Application{
 BorderPane bp = new BorderPane();
 int width = 400, height = 420;
 TextField tf = new TextField();
 TextArea ta = new TextArea();
 
 public void start(Stage primaryStage) throws Exception {
  bp.setCenter(ta);
  
  HBox hbox = new HBox();
  hbox.setAlignment(Pos.CENTER);
  hbox.getChildren().addAll(new Label("Today's Recipe..."), tf);
  
  bp.setBottom(hbox);
  
  tf.setOnAction(this::findRecipe);
    
  Scene scene = new Scene(bp, width, height);
     primaryStage.setTitle("Polymorphism Example"); // Set the stage title
     primaryStage.setScene(scene); // Place the scene in the stage
     primaryStage.show(); // Display the stage
 }
 
 public void findRecipe(ActionEvent e) {
  
  Edible[] edibles = new Edible[4];
  edibles[0] = new Apple();
  edibles[1] = new Orange();
  edibles[2] = new Mango();
  edibles[3] = new Watermelon();

  
  try{
   String str = tf.getText();
   
   if(str.equals("Apple")){
    ta.setText("Apple, " + edibles[0].howToCook());
   }else if(str.equals("Orange")){
    ta.setText("Orange, " + edibles[1].howToCook());
   }else if (str.equals("Mango")){
    ta.setText("Mango, " + edibles[2].howToCook());
   }else if (str.equals("Watermelon")){

   }else{
    ta.setText(tf.getText() + "Fruit is not defined yet...");
   }
   
  }catch(Exception ex){
   ta.setText(tf.getText() + "'Fruit is not defined yet...");
  }
  
  tf.setText("");
 }
  
 
 public static void main(String[] args) {
  launch(args);
  
  }
}

 

interface Edible{
 boolean isEdible();
 String howToCook();
}

interface MakeSound{
 boolean makeSound();
 String howToMakeSound();
}

class Animal implements Edible, MakeSound{

 @Override
 public boolean makeSound() {
  // TODO Auto-generated method stub
  return false;
 }

 @Override
 public String howToMakeSound() {
  // TODO Auto-generated method stub
  return "It depends...";
 }

 @Override
 public boolean isEdible() {
  // TODO Auto-generated method stub
  return false;
 }

 @Override
 public String howToCook() {
  // TODO Auto-generated method stub
  return "It depends...";
 }
 
}

class Chicken extends Animal{
 @Override
 public boolean makeSound() {
  // TODO Auto-generated method stub
  return true;
 }

 @Override
 public String howToMakeSound() {
  // TODO Auto-generated method stub
  return "Koo koo koo";
 }

 @Override
 public boolean isEdible() {
  // TODO Auto-generated method stub
  return true;
 }

 @Override
 public String howToCook() {
  // TODO Auto-generated method stub
  return "Make a soup!";
 }
}

class Rouster extends Chicken{

 @Override
 public String howToMakeSound() {
  // TODO Auto-generated method stub
  return "cock-a-doodle-doo";
 }

}

class Pig extends Animal{
 @Override
 public boolean makeSound() {
  // TODO Auto-generated method stub
  return true;
 }

 @Override
 public String howToMakeSound() {
  // TODO Auto-generated method stub
  return "gulp gulp gulp";
 }

 @Override
 public boolean isEdible() {
  // TODO Auto-generated method stub
  return true;
 }

 @Override
 public String howToCook() {
  // TODO Auto-generated method stub
  return "Make a BBQ!";
 }
}

class Boar extends Pig{
 
 @Override
 public String howToMakeSound() {
  // TODO Auto-generated method stub
  return "gulp gulp gulp";
 }

 
 @Override
 public String howToCook() {
  // TODO Auto-generated method stub
  return "Make a Pork Chops!";
 }
}

class Tiger extends Animal{
 @Override
 public boolean makeSound() {
  // TODO Auto-generated method stub
  return true;
 }

 @Override
 public String howToMakeSound() {
  // TODO Auto-generated method stub
  return "Raar...raar...";
 }
 
 @Override
 public String howToCook() {
  // TODO Auto-generated method stub
  return "Don't even think about it!";
 }
 

import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HW01 extends Application {
	BorderPane bp = new BorderPane();
	
	HTreePane pane = new HTreePane();
	TextField txt;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//create a label
		Label lb = new Label("Enter an order   ");
		
		//create a text field
		txt = new TextField(" ");
		
		Button display = new Button("Display");
	
//		Button inc = new Button("+");// one text field
//		Button dec = new Button("-");//
		HBox  hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(lb,txt, display);
		bp.setBottom(hb);
		
		//set actionEvent for the TextField
		//set actionEvent for the Button
		
//		dec.setOnAction(this::decreaseOrder);
//		inc.setOnAction(this::increaseOrder);
		
		bp.setCenter(pane);
		
		Scene scene = new Scene(bp, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("My  HTree");
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
		
	}
	
	
	public void decreaseOrder(ActionEvent e){
		pane.setOrder(-1);
	
	}
	
	public void increaseOrder(ActionEvent e){
		pane.setOrder(1);
		
	}
	
}
//inheritance
class HTreePane extends Pane{
	private int order = 0;
	
	public void setOrder(int n){
		this.order  += n;
		if(order  < 0){
			order = 0;
		}
			paint();
			
	}
	
	
	public void paint(){
		double x = this.getWidth() / 2;
		double y = this.getHeight() / 2;
		double length = (x > y ? y: x);
		this.getChildren().clear();
		displayHTree(order, x , y, length);
	}
	
	public void displayHTree(int order, double x, double y, double length){
		double size  = length / 2;
		if( order >= 0){
			Line hline = new Line(x - size, y , x + size, y);
			Line vline = new Line(x - size, y - size, x - size, y + size);
			Line vRline = new Line( x + size, y - size, x + size, y + size);
			this.getChildren().addAll(hline, vline, vRline);
			
			
			//recursive call
			displayHTree(order - 2, x - size, y - size, size);
			displayHTree(order - 2, x - size, y + size, size);
			displayHTree(order - 2, x + size, y - size, size);
			displayHTree(order - 2, x + size, y + size, size);
			
			
			
		}
			
		
	}
}

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

public class HW02 extends Application {
	/* 1. Draw a square in the center with each side 1/3th of the size of the square as
     shown in Figure a.
   2. Around the square, draw eight (8) squares as shown in Figure b.
   3. Repeat step 2 to draw eight (8) squares for order 2, 3, 4…so on. In each of
    these 8 squares, recursively draw again a square as shown in Figure c and d.
	 */
	BorderPane bp= new BorderPane();
	HTreePane pane = new HTreePane();
	TextField text;

	@Override
	public void start(Stage primaryStage) throws Exception {
		//create a label
		Label lb = new Label("Enter an Order: ");
		//create a button
		Button display = new Button("Display");
		display.setOnAction(this::setOrder1);
		//create a text field
		text = new TextField(" ");
		
	
		//create a HBox
		HBox hb = new HBox();
		hb.getChildren().addAll(lb,text,display);
		hb.setAlignment(Pos.CENTER);
		
	
		bp.setBottom(hb);
		bp.setCenter(pane);

		//create scene
		Scene scene = new Scene(bp, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sierpinsky Carpet fractal");
		primaryStage.show();



	}

	public void setOrder1(ActionEvent e){
		pane.setOrder2(Integer.parseInt(text.getText()));
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

//inheritance
class HTreePane extends Pane{
	private int order = 0;

	public void setOrder1(int n){
		this.order  += n;
		if(order  < 0){
			order = 0;
		}
		paint();

	}
	
	public void setOrder2(int n){
		this.order += n;
		if(order < 0){
			setOrder1(0);
		}
		paint();
	}


	public void paint(){
		double x = this.getWidth() / 2;
		double y = this.getHeight() / 2;
		double length = (x > y ? y: x);
		this.getChildren().clear();
		displaySquares(order, x , y, length);
	}

	public void displaySquares(int order, double x, double y, double length){
		double size  = length / 2;
		if( order >= 0){
			Line hline = new Line(x - size, y , x + size, y);
			Line vline = new Line(x - size, y - size, x - size, y + size);
			Line vRline = new Line( x + size, y - size, x + size, y + size);
			this.getChildren().addAll(hline, vline, vRline);

			//I got confused
			//recursive call
			displaySquares(order - 2, x - size, y - size, size);
			displaySquares(order - 2, x - size, y + size, size);
			displaySquares(order - 2, x + size, y - size, size);
			displaySquares(order - 2, x + size, y + size, size);



		}


	}
}

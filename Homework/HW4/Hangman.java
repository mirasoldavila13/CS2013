import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Hangman extends Application {
	private TextField letter;
	private Scene scene;
	private ArrayList<Shape> body;
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	String[] guesses = {"July", "Pi", "Apple", "Discrete", "Data", "rain", "structures"};
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//stage1
		BorderPane bPane = new BorderPane();
		letter = new TextField();
		//create hBox
		HBox hb = new HBox();
		hb.getChildren().addAll(new Label("Enter a letter  "), letter);
		hb.setAlignment(Pos.CENTER);
		bPane.setBottom(hb);
		
		
		scene = new Scene(bPane, 700, 400);
		primaryStage.setTitle("Hangman");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}

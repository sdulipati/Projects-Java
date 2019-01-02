package controllers;



import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The Library Management  Project which uses MVC simulated 
 * approach that performs Book operations like add, update and delete. In addition
 * Administrator can add,update and delete staff members. Students can search books/articles,
 * borrow books/artilces from the library. 
 * @authors		 		Sreenidhi Rajesh Dulipati and Ritesh Shenoy
 * Userid	 		:	sdulipati and rshenoy
 * Date 	 		:   Dec 7 2018
 * Project			:   Final Project
 */


public class LibraryManagementMain extends Application {
public static Stage stage;
ObservableList<String> choicesList = FXCollections.observableArrayList("@hawk.iit.edu","@iit.edu");

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("/views/Login.fxml"));
			Scene scene1 = new Scene(root);
			stage.setTitle("Login");
			stage.setScene(scene1);
			stage.show();
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	public static void main(String[] args) throws SQLException {
		
		//launch of login Screen
		launch(args);
	}
	}



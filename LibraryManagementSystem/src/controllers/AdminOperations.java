package controllers;

import java.io.IOException;
import java.sql.SQLException;
import javafx.stage.Stage;

public interface AdminOperations {

	void buttonSearchClicked() throws IOException, SQLException ;
	void start(Stage primaryStage);
	void intialize1() throws IOException;
	void additionOfBook() throws IOException;
	void updationOfBook() throws IOException;
	void deletionOfBook();

	
}

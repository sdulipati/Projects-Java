package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Student extends Application{
	@FXML
    private RadioButton articlesSelection;

    @FXML
    private RadioButton booksSelection;

    @FXML
    private RadioButton researchSelection;

    @FXML
    private Button serachClicked;

    @FXML
    private TextField textArea;
    
    @FXML
    private MenuItem borrowedBooks;

    @FXML
    private MenuItem borrowedArticles;

    @FXML
    private MenuItem returnBook;

    
    @FXML
    private Button logoutButton;
	    
	    public static int articleSelected;
	    public static int bookSelected;
	    public static int articleSelection =0;
	    public static int bookSelection=0;
	    public static String query;
	    public static String studentEmail;
	
	
	 public void buttonSearchClicked() throws IOException, SQLException {
		if(articlesSelection.isSelected()) {
			articleSelected = 1;
			query = textArea.getText();
			if (query.length()==0){
				query = "art";
			}
			System.out.println(query.isEmpty());
			int lengthOfText =3;
			System.out.println("112121");
			System.out.println(query.length());
			if(query.length()>3) {
				//For selecting only first three characters from the SearchBox
				query = query.substring(0, Math.min(query.length(), 3));
			}
			System.out.println(query.replace(" ", "").length());
			if(query.length()>=lengthOfText && query.replace(" ", "").length()>=lengthOfText && query.length()==3) {
				System.out.println(query);
				start(null);
			}else {
				JOptionPane.showMessageDialog(null, "Enter minimum of 3 letters in Search Box");
				textArea.clear();
			}
			
		}
		else if(booksSelection.isSelected()) {
			bookSelected =  2;
			query = textArea.getText();
			if (query.length()==0){
				query = "bok";
			}
			System.out.println(query.isEmpty());
			int lengthOfText =3;
			System.out.println("112121");
			System.out.println(query.length());
			if(query.length()>3) {
				//For selecting only first three characters from the SearchBox
				query = query.substring(0, Math.min(query.length(), 3));
			}
			System.out.println(query.replace(" ", "").length());
			if(query.length()>=lengthOfText && query.replace(" ", "").length()>=lengthOfText && query.length()==3) {
				System.out.println(query);
				start(null);
			}else {
				JOptionPane.showMessageDialog(null, "Enter minimum of 3 letters in Search Box");
				textArea.clear();
			}
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Please select either articles/books in order to search");

			alert.showAndWait();
		}
		}
	 @Override
		public void start(Stage primaryStage) {
			try {
				
				if(articlesSelection.isSelected()) {
					
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/views/DisplayOfRecordsForStudent.fxml"));
					Scene scene1 = new Scene(root);
					LibraryManagementMain.stage.setTitle("Display of records");
					LibraryManagementMain.stage.setScene(scene1);
					LibraryManagementMain.stage.show();

				}
				else if(booksSelection.isSelected()) {
					System.out.println("I came in Display");
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/views/StudentBookDisplay.fxml"));
					Scene scene1 = new Scene(root);
					LibraryManagementMain.stage.setTitle("Display of records");
					LibraryManagementMain.stage.setScene(scene1);
					LibraryManagementMain.stage.show();

				}else if(articleSelection==3) {
					System.out.println("i am in anchorpane"+ articleSelection);
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/views/BorrowedDetails.fxml"));
					Scene scene1 = new Scene(root);
					LibraryManagementMain.stage.setTitle("Display of Borrowed records");
					LibraryManagementMain.stage.setScene(scene1);
					LibraryManagementMain.stage.show();

				}else if(bookSelection==4) {
					System.out.println("i am in anchorpane"+ bookSelection);
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/views/BorrowedDetails.fxml"));
					Scene scene1 = new Scene(root);
					LibraryManagementMain.stage.setTitle("Display of Borrowed records");
					LibraryManagementMain.stage.setScene(scene1);
					LibraryManagementMain.stage.show();

				}

				
			} catch (Exception e) {
				System.out.println("Error occured while inflating view: " + e);
			}
		}
	
	public void showPage(String studentUsername) throws IOException{
		studentEmail= studentUsername;
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/StudentPage.fxml"));
          Parent root = loader.load();
          //Show scene 2 in new window            
          LibraryManagementMain.stage.setScene(new Scene(root));
          LibraryManagementMain.stage.setTitle("Student Page");
          LibraryManagementMain.stage.show();
	}
	public void borrowedSection() {
		
		articleSelection =3;
		start(null);
	}
	public void borrowedBookSection() {
		
		bookSelection =4;
		System.out.println(bookSelection);
		start(null);
	}
	@FXML
   public void logoutButtonClicked() throws IOException {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("/views/Login.fxml"));
			Scene scene1 = new Scene(root);
			LibraryManagementMain.stage.setTitle("Login");
			LibraryManagementMain.stage.setScene(scene1);
			LibraryManagementMain.stage.show();

		  
    }
	@FXML
    public void backButtonClicked() throws IOException {
    	AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/Login.fxml"));
		Scene scene1 = new Scene(root);
		LibraryManagementMain.stage.setTitle("Login Page");
		LibraryManagementMain.stage.setScene(scene1);
		LibraryManagementMain.stage.show();

 		  
     }


}
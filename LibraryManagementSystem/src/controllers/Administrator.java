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






public class Administrator extends Application implements AdminOperations{
	
	
	    @FXML
	    private RadioButton articlesSelection;

	    @FXML
	    private RadioButton booksSelection;

	    @FXML
	    private RadioButton researchSelection;

	    @FXML
		public TextField textArea;

	    @FXML
	    private Button serachClicked;
	    
	    @FXML
	    private MenuItem about;
	    
	    @FXML
	    private Button back;
	    
	    @FXML
	    private MenuItem addBookClicked;
	    
	    @FXML
	    private MenuItem updateBookClicked;

	    @FXML
	    private MenuItem deleteBookClicked;

	    @FXML
	    private MenuItem addStaffClicked;

	    @FXML
	    private MenuItem updateStaffClicked;

	    @FXML
	    private MenuItem deleteStaffClicked;
	    
	    @FXML
	    private Button logoutButton;
	    
	    public static boolean articleSelected;
	    public static boolean bookSelected;
	    public static String query;
	
		
	 public void buttonSearchClicked() throws IOException, SQLException {
		 System.out.println("I cam into button");
		if(articlesSelection.isSelected()) {
			articleSelected = true;
			query = textArea.getText();
			if (query.length()==0){
				query = "art";
			}
			System.out.println(query.isEmpty());
			int lengthOfText =3;
			System.out.println("121");
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
			bookSelected =  true;
			query = textArea.getText();
			if (query.length()==0){
				query = "bok";
			}
			System.out.println(query.isEmpty());
			int lengthOfText =3;
			System.out.println("121");
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
		}
	 @Override
		public void start(Stage primaryStage) {
			try {
				//Stage stage = primaryStage;
				if(articlesSelection.isSelected()) {
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/views/Display.fxml"));
					Scene scene1 = new Scene(root);
					LibraryManagementMain.stage.setTitle("Display of records");
					LibraryManagementMain.stage.setScene(scene1);
					LibraryManagementMain.stage.show();
					

				}
				else if(booksSelection.isSelected()) {
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/views/SearchBookDisplay.fxml"));
					Scene scene1 = new Scene(root);
					LibraryManagementMain.stage.setTitle("Display of records");
					LibraryManagementMain.stage.setScene(scene1);
					LibraryManagementMain.stage.show();
					

				}
				
			} catch (Exception e) {
				System.out.println("Error occured while inflating view: " + e);
			}
		}
	
	public void intialize1() throws IOException{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AdminPage.fxml"));
          Parent root = loader.load();
          //Show scene 2 in new window            
          LibraryManagementMain.stage.setScene(new Scene(root));
          LibraryManagementMain.stage.setTitle("Administrator Page");
          LibraryManagementMain.stage.show();
	}
	 @FXML
	    public void additionOfBook() throws IOException {
		 addBookPage(null);
	    }

	private void addBookPage(Stage primaryStage)  {
		// TODO Auto-generated method stub
		AnchorPane root;
		try {
			root = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("/views/AddBook.fxml"));
			Scene scene1 = new Scene(root);
			LibraryManagementMain.stage.setTitle("Addition of Records");
			LibraryManagementMain.stage.setScene(scene1);
			LibraryManagementMain.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
		@FXML
		public void updationOfBook() throws IOException {
			updateBookPage(null);
		    }

		private void updateBookPage(Stage primaryStage)  {
			// TODO Auto-generated method stub
			AnchorPane root;
			try {
				root = (AnchorPane) FXMLLoader.load(getClass()
						.getResource("/views/UpdateBook.fxml"));
				Scene scene1 = new Scene(root);
				LibraryManagementMain.stage.setTitle("Updation of Records");
				LibraryManagementMain.stage.setScene(scene1);
				LibraryManagementMain.stage.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
			@FXML
		   public void updationOfStaff() {
				AnchorPane root;
				try {
					root = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/views/UpdateStaff.fxml"));
					Scene scene1 = new Scene(root);
					LibraryManagementMain.stage.setTitle("Updation of Records");
					LibraryManagementMain.stage.setScene(scene1);
					LibraryManagementMain.stage.show();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}

		    }

		    @FXML
		    public void deletionOfBook() {
		    	AnchorPane root;
				try {
					root = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/views/DeleteBook.fxml"));
					Scene scene1 = new Scene(root);
					LibraryManagementMain.stage.setTitle("Deletion of Records");
					LibraryManagementMain.stage.setScene(scene1);
					LibraryManagementMain.stage.show();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}

		    }

		    @FXML
		    public void deletionOfStaff() {
		    	AnchorPane root;
				try {
					root = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/views/DeleteStaff.fxml"));
					Scene scene1 = new Scene(root);
					LibraryManagementMain.stage.setTitle("Deletion of Records");
					LibraryManagementMain.stage.setScene(scene1);
					LibraryManagementMain.stage.show();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}

		    }
		    @FXML
		   public  void additionOfStaff() {
		    	addStaffPage(null);
		    }

		private void addStaffPage(Stage primaryStage)  {
			// TODO Auto-generated method stub
			AnchorPane root;
			try {
				root = (AnchorPane) FXMLLoader.load(getClass()
						.getResource("/views/AddStaff.fxml"));
				Scene scene1 = new Scene(root);
				LibraryManagementMain.stage.setTitle("Addition of Staff Data");
				LibraryManagementMain.stage.setScene(scene1);
				LibraryManagementMain.stage.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}

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
		    @FXML
		    public void aboutSoftware() {
		    	System.out.println("I came");
		    	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Information Dialog");
		    	alert.setHeaderText(null);
		    	alert.setContentText("Library Management Project created by two IITians"
		    			+ " from Information Technology and Management department. With the help of this"
		    			+ " application students can search and borrow books. Please contact administrator"
		    			+ " for further information.");

		    	alert.showAndWait();
		    }
	}

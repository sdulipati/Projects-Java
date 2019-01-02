package controllers;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

import models.DaoModel;

public class StaffAddBook{

    @FXML
    public TextField addBookId;

    @FXML
    private TextField addBookName;

    @FXML
    private TextField addBookAuthor;

    @FXML
    private TextField addBookIsbn;

    @FXML
    private TextField addBookPublisher;

    
    @FXML
    private Button addButtonClicked;
    
    @SuppressWarnings("rawtypes")
	@FXML
    private ChoiceBox referralChoices;
    
    @FXML
    private RadioButton articleSelect;

    @FXML
    private RadioButton bookSelect;

    @FXML
    private RadioButton researchSelect;
    
    @FXML
    private Button logoutButton;
    
    @FXML
    private Button back;
	
    
    ObservableList<String> referralChoicesList = FXCollections.observableArrayList("Yes     ","No      ");

    @SuppressWarnings("unchecked")
	public void initialize() throws SQLException {
		//initData();
		
		referralChoices.setItems(referralChoicesList);
			/*try {
				loadData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			addBookId.getText();*/
			
			/* LibraryManagementMain.stage.setTitle("Display Page");
			 LibraryManagementMain.stage.show();
			 System.out.println("url");
		*/
	    
		
		
	}

	public void initData() throws SQLException, IOException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		DaoModel db1 = new DaoModel();
		ArrayList<String> bookData = new ArrayList<String>();
		if(addBookName.getText().length()>100 || addBookAuthor.getText().length()>45 || addBookIsbn.getText().length()>20
				|| addBookPublisher.getText().length()>100 || addBookId.getText().length()>9 ) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Ooops, One or more fields is too large!");
			alert.showAndWait();
	
		}else if(addBookName.getText().matches("^[0-9]+$") ||addBookAuthor.getText().matches("^[0-9]+$") ||
				addBookPublisher.getText().matches("^[0-9]+$") || addBookId.getText().matches("^[0-9]+$")){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Ooops, One or more fields contains numeric!");
			alert.showAndWait();
		}else if (addBookName.getText().length()==0 ||addBookAuthor.getText().length()==0 ||addBookId.getText().length()==0 ||
				addBookPublisher.getText().length()==0 ||referralChoices.getValue()==null || addBookIsbn.getText().length()==0  ){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Ooops, One or more fields is not entered!");
			alert.showAndWait();
		}else if(!(articleSelect.isSelected() || bookSelect.isSelected())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Ooops, Radio Button Articles/books is not selected!");
			alert.showAndWait();
		}else {		
		bookData.add(addBookId.getText());
		bookData.add(addBookName.getText());
		bookData.add(addBookAuthor.getText());
		bookData.add(addBookIsbn.getText());
		bookData.add(addBookPublisher.getText());
		bookData.add((String) referralChoices.getValue());
		if(articleSelect.isSelected()) {
			db1.insertBookRecords(bookData,1);
		}else {
			db1.insertBookRecords(bookData,2);
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Book added to Library Database");
		alert.showAndWait();
		addBookId.clear();
		addBookName.clear();
		addBookAuthor.clear();
		addBookIsbn.clear();
		addBookPublisher.clear();
		referralChoices.getSelectionModel().clearSelection();
		
		Staff st = new Staff();
		st.additionOfBook();
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
	public void clearButtonClicked() {
		addBookId.clear();
		addBookName.clear();
		addBookAuthor.clear();
		addBookIsbn.clear();
		addBookPublisher.clear();
		referralChoices.getSelectionModel().clearSelection();
    }
	@FXML
    public void backButtonClicked() throws IOException {
    	AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/StaffPage.fxml"));
		Scene scene1 = new Scene(root);
		LibraryManagementMain.stage.setTitle("Staff Page");
		LibraryManagementMain.stage.setScene(scene1);
		LibraryManagementMain.stage.show();

 		  
     }


}

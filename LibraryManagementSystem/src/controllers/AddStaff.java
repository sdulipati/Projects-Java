package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import models.DaoModel;

public class AddStaff{

    @FXML
    public TextField addStaffId;

    @FXML
    private TextField addStaffName;

    
    @FXML
    private TextField addStaffEmail;

    @FXML
    private TextField addStaffPassword;

    @FXML
    private TextField addStaffCell;

    @FXML
    private TextField addStaffAddress;    
    @FXML
    private Button addButtonClicked;
    
    @FXML
    private Button logoutButton;
	
    @FXML
    private MenuItem addBookClicked;
    
    @FXML
    private MenuItem updateBookClicked;

    @FXML
    private MenuItem deleteBookClicked;

    @FXML
    private MenuItem updateStaffClicked;

    @FXML
    private MenuItem deleteStaffClicked;

    @FXML
    private Button back;

    
	public void initialize() throws SQLException {
	
	}

	public void initData() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs =null;
		DaoModel db1 = new DaoModel();
		ArrayList<String> staffData = new ArrayList<String>();
		
		
		 if(addStaffName.getText().length()>30 || addStaffId.getText().length()>9) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Look, an Error Dialog");
			alert.setContentText("Ooops, Employee Name is too large!");
			alert.showAndWait();
	
	}else if(!(addStaffEmail.getText().substring(addStaffEmail.getText().lastIndexOf('@') + 1).equals("hawk.iit.edu")) ||
			(addStaffEmail.getText().substring(addStaffEmail.getText().lastIndexOf('@') + 1).equals("iit.edu"))){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText("Ooops, Employee Email is not of type @hawk.iit.edu or @iit.edu");
		alert.showAndWait();
	}
	else if(addStaffEmail.getText().length()>30 || addStaffEmail.getText().matches("^[0-9]+$") ) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText("Ooops, Employee Email is too large!");
		alert.showAndWait();
	}else if(addStaffCell.getText().length()>10 || addStaffCell.getText().matches("^([A-Za-z])+$") || addStaffCell.getText().contains(" ")
			|| addStaffCell.getText().length()==0) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText("Ooops, Employee Cell Number must be ten digits");
		alert.showAndWait();
	}else if(addStaffAddress.getText().length()>60 ||addStaffAddress.getText().matches("^[0-9]+$")|| addStaffAddress.getText().contains(" ")
			|| addStaffAddress.getText().length()==0) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText("Ooops, Employee Address is too large!");
		alert.showAndWait();
	}else if(addStaffName.getText().matches("^([A-Za-z])+$") || (addStaffName.getText().contains(" "))){
	
		staffData.add(addStaffId.getText());
		staffData.add(addStaffName.getText());
		staffData.add(addStaffEmail.getText());
		staffData.add(addStaffPassword.getText());
		staffData.add(addStaffCell.getText());
		staffData.add(addStaffAddress.getText());
		
		db1.insertStaffRecords(staffData);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Staff Data added to Library Database");
		alert.showAndWait();
	
		addStaffId.clear();
    	addStaffName.clear();
    	addStaffPassword.clear();
		addStaffEmail.clear();
		addStaffAddress.clear();
		addStaffCell.clear();
		Administrator adm = new Administrator(); 
		 adm.additionOfStaff();
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

    public void additionOfBook() throws IOException {
		 Administrator adm = new Administrator(); 
		 adm.additionOfBook();
	}
    
    @FXML
	public void updationOfBook() throws IOException {
    	Administrator adm = new Administrator();
    	adm.updationOfBook();
	}
    @FXML
    public void deletionOfBook() {
    	Administrator adm = new Administrator();
    	adm.deletionOfBook();
	
    }
    @FXML
	public void updationOfStaff() {
    	Administrator adm = new Administrator();
    	adm.updationOfStaff();
	
    }
    public void clearButtonClicked() {
    	addStaffId.clear();
    	addStaffName.clear();
    	addStaffPassword.clear();
		addStaffEmail.clear();
		addStaffAddress.clear();
		addStaffCell.clear();
		Administrator adm = new Administrator(); 
		 adm.additionOfStaff();
    }
	
    @FXML
    public void backButtonClicked() throws IOException {
    	AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/AdminPage.fxml"));
		Scene scene1 = new Scene(root);
		LibraryManagementMain.stage.setTitle("Administrator Page");
		LibraryManagementMain.stage.setScene(scene1);
		LibraryManagementMain.stage.show();

 		  
     }


}

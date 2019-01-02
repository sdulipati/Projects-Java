package controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.util.StringConverter;

import models.DaoModel;
import models.StaffModel;


public class UpdateStaff implements Initializable{
	

		@FXML
	    private ComboBox<StaffModel> updateStaffId;
	 
		@FXML
	    private TextField updateStaffName;

	    @FXML
	    private TextField updateStaffEmail;

	    @FXML
	    private TextField updateStaffCell;
	    
	    @FXML
	    private TextField updateStaffAddress;
	    
	    @FXML
	    private MenuItem addBookClicked;
	    
	    @FXML
	    private MenuItem updateBookClicked;

	    @FXML
	    private MenuItem deleteBookClicked;

	    @FXML
	    private MenuItem addStaffClicked;

	    @FXML
	    private MenuItem deleteStaffClicked;
	    

	    @FXML
	    private Button addButtonClicked;

	    @FXML
	    private Button updateButton;

	    @FXML
	    private Button clearfields;
	    
	    @FXML
	    private Button logoutButton;
	    
	    
	    Parent root = null;
	    ObservableList<StaffModel> data = 
	    					FXCollections.observableArrayList();
	    	
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/UpdateStaff.fxml"));
	    String idSelected = null;
	    	
	    public void initialize(URL location,ResourceBundle resources) {
	    	try {
	    		loadData();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	  }
	    	LibraryManagementMain.stage.setTitle("Update of Records");
	    	LibraryManagementMain.stage.show();
	    	System.out.println("url");
	    }

	    private void loadData() throws SQLException {
			ResultSet rs = null;
	    	DaoModel db1 = new DaoModel();
	    	rs = db1.retrieveStaffIDRecords();
	    	try{
	    		while(rs.next()) {
	    			data.add(new StaffModel(rs.getString("employeeId")));
	    		}
	    	}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	updateStaffId.setItems(data);
	    	
	    	updateStaffId.setConverter(converter);	     
	    }
	    
	    StringConverter<StaffModel> converter = new StringConverter<StaffModel>() {
		   @Override
		    public String toString(StaffModel object) {
			   return object.getIdStaff();
		     }

		    @Override
		    public StaffModel fromString(String string) {
		        return null;
		     }
		 };

	    	
		 
		public void comboBoxSelected() throws SQLException {
	    	ResultSet rs = null;
	    	DaoModel db1 = new DaoModel();
	    		System.out.println("combobox selected");
	    	StaffModel idSelect = updateStaffId.getSelectionModel().getSelectedItem();
	    	 idSelected = idSelect.getIdStaff();
	    		
	    	rs = db1.retrieveStaffDataOnId(idSelect.getIdStaff());
	    		
	    	while(rs.next()) {
	    		updateStaffName.setText(rs.getString("staffName"));
	    		updateStaffEmail.setText(rs.getString("username"));
	    		updateStaffCell.setText(rs.getString("phoneNumber"));
	    		updateStaffAddress.setText(rs.getString("address"));
	    		
			}
	    				
	   	}
	    
	    public void updateButtonClicked() throws SQLException {
	    	
			DaoModel db1 = new DaoModel();
			System.out.println("Update Button CLiked");
			ArrayList<String> staffData = new ArrayList<String>();
			System.out.println(!(updateStaffName.getText().contains(" ")));
			if(updateStaffName.getText().length()>30) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog");
					alert.setHeaderText("Look, an Error Dialog");
					alert.setContentText("Ooops, Employee Name is too large!");
					alert.showAndWait();
			
			}else if(!(updateStaffEmail.getText().substring(updateStaffEmail.getText().lastIndexOf('@') + 1).equals("hawk.iit.edu")) ||
					(updateStaffEmail.getText().substring(updateStaffEmail.getText().lastIndexOf('@') + 1).equals("iit.edu"))){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, Employee Email is not of type @hawk.iit.edu or @iit.edu");
				alert.showAndWait();
			}
			else if(updateStaffEmail.getText().length()>30 || updateStaffEmail.getText().matches("^[0-9]+$") ) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, Employee Email is too large!");
				alert.showAndWait();
	    	}else if(updateStaffCell.getText().length()>10 || updateStaffCell.getText().matches("^([A-Za-z])+$") || updateStaffCell.getText().contains(" ")
	    			|| updateStaffCell.getText().length()==0) {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, Employee Cell Number must be ten digits");
				alert.showAndWait();
	    	}else if(updateStaffAddress.getText().length()>60 || updateStaffAddress.getText().length()==0) {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, Employee Address is too large!");
				alert.showAndWait();
	    	}else if(updateStaffName.getText().matches("^([A-Za-z])+$") || (updateStaffName.getText().contains(" "))){
			staffData.add(updateStaffName.getText());
			staffData.add(updateStaffEmail.getText());
			staffData.add(updateStaffCell.getText());
			staffData.add(updateStaffAddress.getText());
			
			System.out.println(staffData);
			db1.insertupdatedStaffData(staffData);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Staff data has been updated!");

			alert.showAndWait();
	    	}else {
	    		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, Employee Name contains numbers or special characters");
				alert.showAndWait();
	    	}
	    }
	    
	    public void clearButtonClicked() {
	    	updateStaffName.clear();
	    	updateStaffEmail.clear();
	    	updateStaffCell.clear();
	    	updateStaffAddress.clear();
			updateStaffId.setValue(null);
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
	    public  void additionOfStaff() {
	    	Administrator adm = new Administrator();
	    	adm.additionOfStaff();
		
	    }
	    @FXML
		   public void updationOfStaff() {
	    	Administrator adm = new Administrator();
	    	adm.updationOfStaff();
		
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


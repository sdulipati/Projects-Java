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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

import models.DaoModel;
import models.StaffModel;

public class DeleteStaff implements Initializable{
	

		@FXML
	    private ComboBox<StaffModel> deleteBookId;
	 
		@FXML
	    private TextField deleteStaffName;

	    @FXML
	    private TextField deleteStaffEmail;

	    @FXML
	    private TextField deleteStaffCell;

	    @FXML
	    private TextField deleteStaffAddress;

	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Button clearfields;

	    @FXML
	    private Button logoutButton;
	    
	    @FXML
	    private Button back;

	    
	    Parent root = null;
	    ObservableList<StaffModel> data = 
	    					FXCollections.observableArrayList();
	    	
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/DeleteRecords.fxml"));
	    String idSelected = null;
	    	
	    public void initialize(URL location,ResourceBundle resources) {
	    	try {
	    		loadData();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	  }
	    	LibraryManagementMain.stage.setTitle("Deletion of Staff Details");
	    	LibraryManagementMain.stage.show();
	    	
	    }

	    private void loadData() throws SQLException {
			ResultSet rs = null;
	    	DaoModel db1 = new DaoModel();
	    	rs = db1.retrieveStaffIDDeletePage();
	    	try{
	    		while(rs.next()) {
	    			data.add(new StaffModel(rs.getString("employeeId")));
	    		}
	    	}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	deleteBookId.setItems(data);
	    	
	    	deleteBookId.setConverter(converter);	     
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
	    		
	    	StaffModel idSelect = deleteBookId.getSelectionModel().getSelectedItem();
	    	if(idSelect != null) {
	    	 idSelected = idSelect.getIdStaff();
	    		
	    	rs = db1.retrieveStaffDataId(idSelect.getIdStaff());
	    		
	    	while(rs.next()) {
	    		deleteStaffName.setText(rs.getString("staffName"));
	    		deleteStaffEmail.setText(rs.getString("username"));
	    		deleteStaffCell.setText(rs.getString("phoneNumber"));
	    		deleteStaffAddress.setText(rs.getString("address"));
	    		
	    		
			}
	    	}		
	   	}
	    
	    public void deleteButtonClicked() throws SQLException {
			DaoModel db1 = new DaoModel();
			System.out.println("Delete Button Clicked");
			ArrayList<String> StaffData = new ArrayList<String>();
			
			StaffData.add(deleteStaffName.getText());
			StaffData.add(deleteStaffEmail.getText());
			StaffData.add(deleteStaffCell.getText());
			StaffData.add(deleteStaffAddress.getText());
			
			System.out.println(StaffData);
			db1.deleteStaffData(StaffData);
			
			JOptionPane.showMessageDialog(null, "Book has been deleted from Library Database");
			deleteStaffName.clear();
			deleteStaffEmail.clear();
			deleteStaffCell.clear();
			deleteStaffAddress.clear();
			deleteBookId.getSelectionModel().clearSelection();
			
			Administrator ad = new Administrator();
			ad.deletionOfStaff();
			
	    }
	    
	    public void clearButtonClicked() {
	    	deleteStaffName.clear();
			deleteStaffEmail.clear();
			deleteStaffCell.clear();
			deleteStaffAddress.clear();
			deleteBookId.setValue(null);
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
					.getResource("/views/AdminPage.fxml"));
			Scene scene1 = new Scene(root);
			LibraryManagementMain.stage.setTitle("Administrator Page");
			LibraryManagementMain.stage.setScene(scene1);
			LibraryManagementMain.stage.show();

	 		  
	     }

	    	
	}	    	    


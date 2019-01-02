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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

import models.DaoModel;
import models.DisplayModel;

public class StaffDeleteRecords implements Initializable{
	

		@FXML
	    private ComboBox<DisplayModel> deleteBookId;
	 
		@FXML
	    private TextField deleteBookName;

	    @FXML
	    private TextField deleteBookAuthor;

	    @FXML
	    private TextField deleteBookIsbn;

	    @FXML
	    private TextField deleteBookPublisher;
	    
	    @FXML
	    private TextField deleteBookRefferal;

	    @FXML
	    private Button back;

	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Button clearfields;

	    @FXML
	    private RadioButton articleSelect;

	    @FXML
	    private RadioButton bookSelect;

	    @FXML
	    private RadioButton researchSelect;
	    
	    @FXML
	    private Button logoutButton;

	    
	    Parent root = null;
	    ObservableList<DisplayModel> data = 
	    					FXCollections.observableArrayList();
	    	
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/DeleteRecords.fxml"));
	    String idSelected = null;
	    	
	    public void initialize(URL location,ResourceBundle resources) {
	    	/*try {
	    		loadData();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	  }*/
	    	LibraryManagementMain.stage.setTitle("Deletion of Records");
	    	LibraryManagementMain.stage.show();
	    	
	    }

	    public void loadData() throws SQLException {
			ResultSet rs = null;
	    	DaoModel db1 = new DaoModel();
	    	rs = db1.retrieveIDRecordsForDeletePage();
	    	try{
	    		while(rs.next()) {
	    			data.add(new DisplayModel(rs.getString("id")));
	    		}
	    	}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	deleteBookId.setItems(data);
	    	
	    	deleteBookId.setConverter(converter);	     
	    }
	    public void loadBookData() throws SQLException {
			ResultSet rs = null;
	    	DaoModel db1 = new DaoModel();
	    	rs = db1.retrieveBookUpdateRecords();
	    	try{
	    		while(rs.next()) {
	    			data.add(new DisplayModel(rs.getString("id")));
	    		}
	    	}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	deleteBookId.setItems(data);
	    	
	    	deleteBookId.setConverter(converter);	     
	    }
	    
	    StringConverter<DisplayModel> converter = new StringConverter<DisplayModel>() {
		   @Override
		    public String toString(DisplayModel object) {
			   return object.getId();
		     }

		    @Override
		    public DisplayModel fromString(String string) {
		        return null;
		     }
		 };

	    	
		public void comboBoxSelected() throws SQLException {
	    	ResultSet rs = null;
	    	DaoModel db1 = new DaoModel();
	    		
	    	DisplayModel idSelect = deleteBookId.getSelectionModel().getSelectedItem();
	    	 idSelected = idSelect.getId();
	    		
	    	 if(articleSelect.isSelected()) {
		    		rs = db1.retrieveRecordsbasedOnId(idSelect.getId(),1);
		    	}else if(bookSelect.isSelected()) {
		    		articleSelect.setSelected(false);
		    		rs = db1.retrieveRecordsbasedOnId(idSelect.getId(),2);
		    	}
	    		
	    	while(rs.next()) {
	    		deleteBookName.setText(rs.getString("name"));
	    		deleteBookAuthor.setText(rs.getString("isbn"));
	    		deleteBookIsbn.setText(rs.getString("author"));
	    		deleteBookPublisher.setText(rs.getString("publishedBy"));
	    		deleteBookRefferal.setText(rs.getString("isRefferal"));
	    		
			}
	    				
	   	}
	    
	    public void deleteButtonClicked() throws SQLException {
	    	
			DaoModel db1 = new DaoModel();
			System.out.println("Delete Button Clicked");
			ArrayList<String> bookData = new ArrayList<String>();
			
			bookData.add(deleteBookName.getText());
			bookData.add(deleteBookAuthor.getText());
			bookData.add(deleteBookIsbn.getText());
			bookData.add(deleteBookPublisher.getText());
			bookData.add(deleteBookRefferal.getText());
			System.out.println(bookData);
			if(articleSelect.isSelected()) {
				db1.deleteRecordsTable(bookData,1);
			}else {
				db1.deleteRecordsTable(bookData,2);
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Book has been deleted from library");

			alert.showAndWait();
			deleteBookName.clear();
			deleteBookAuthor.clear();
			deleteBookIsbn.clear();
			deleteBookPublisher.clear();
			deleteBookRefferal.clear();
			deleteBookId.setValue(null);
			
			Staff st = new Staff();
    		st.deletionOfBook();

	    }
	    
	    public void clearButtonClicked() {
	    	deleteBookName.clear();
			deleteBookAuthor.clear();
			deleteBookIsbn.clear();
			deleteBookPublisher.clear();
			deleteBookRefferal.clear();
			deleteBookId.setValue(null);
			Staff st = new Staff();
    		st.deletionOfBook();

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
					.getResource("/views/StaffPage.fxml"));
			Scene scene1 = new Scene(root);
			LibraryManagementMain.stage.setTitle("Staff Page");
			LibraryManagementMain.stage.setScene(scene1);
			LibraryManagementMain.stage.show();

	 		  
	     }


	    	
	}	    	    


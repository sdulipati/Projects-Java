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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

import javafx.util.StringConverter;

import models.DaoModel;
import models.DisplayModel;

public class StaffUpdateBook implements Initializable{
	

	@FXML
	    private ComboBox<DisplayModel> updateBookId;
	 
	    @FXML
	    private TextField updateBookName;

	    @FXML
	    private TextField updateBookAuthor;

	    @FXML
	    private TextField updateBookIsbn;

	    @FXML
	    private TextField updateBookPublisher;

	    @SuppressWarnings("rawtypes")
		@FXML
	    private ChoiceBox referralChoices;

	    @FXML
	    private Button addButtonClicked;

	    @FXML
	    private RadioButton articleSelect;

	    @FXML
	    private RadioButton bookSelect;
	    
	    @FXML
	    private RadioButton researchSelect;
	    
	    @FXML
	    private Button updateButton;

	    @FXML
	    private Button clearfields;
	    
	    @FXML
	    private Button logoutButton;
	    
	    ObservableList<String> referralChoicesList = FXCollections.observableArrayList("Yes     ","No      ");
	    Parent root = null;
	    ObservableList<DisplayModel> data = 
	    					FXCollections.observableArrayList();
	    	
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/UpdateBook.fxml"));
	    String idSelected = null;
	    
	    	
	    public void initialize(URL location,ResourceBundle resources) {
	    	/*try {
	    		loadData();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	  }*/
	    	LibraryManagementMain.stage.setTitle("Update of Records");
	    	LibraryManagementMain.stage.show();
	    	System.out.println("url");
	    }

	    @SuppressWarnings("unchecked")
		public void loadData() throws SQLException {
			ResultSet rs = null;
	    	DaoModel db1 = new DaoModel();
	    	rs = db1.retrieveIDRecords();
	    	try{
	    		while(rs.next()) {
	    			data.add(new DisplayModel(rs.getString("id")));
	    		}
	    	}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	updateBookId.setItems(data);
	    	referralChoices.setItems(referralChoicesList);
	    	updateBookId.setConverter(converter);	     
	    }
	    
	    public void BookloadData() throws SQLException {
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
	    	updateBookId.setItems(data);
	    	referralChoices.setItems(referralChoicesList);
	    	updateBookId.setConverter(converter);	     
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
	    		
	    	DisplayModel idSelect = updateBookId.getSelectionModel().getSelectedItem();
	    	 idSelected = idSelect.getId();
	    		
	    	if(articleSelect.isSelected()) {
	    		bookSelect.setSelected(false);
	    		rs = db1.retrieveRecordsbasedOnId(idSelect.getId(),1);
	    	}else if(bookSelect.isSelected()) {
	    		articleSelect.setSelected(false);
	    		rs = db1.retrieveRecordsbasedOnId(idSelect.getId(),2);
	    	}
	    	while(rs.next()) {
	    		updateBookName.setText(rs.getString("name"));
	    		updateBookAuthor.setText(rs.getString("isbn"));
	    		updateBookIsbn.setText(rs.getString("author"));
	    		updateBookPublisher.setText(rs.getString("publishedBy"));
	    	}
	    				
	   	}
	    
	    public void updateButtonClicked() throws SQLException, IOException {
	    	
			DaoModel db1 = new DaoModel();
			System.out.println("Update Button Clicked");
			ArrayList<String> bookData = new ArrayList<String>();
			if(updateBookName.getText().length()>100 || updateBookAuthor.getText().length()>45 || updateBookIsbn.getText().length()>20
					|| updateBookPublisher.getText().length()>100) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, One or more fields is too large!");
				alert.showAndWait();
		
			}else if(updateBookName.getText().matches("^[0-9]+$") ||updateBookAuthor.getText().matches("^[0-9]+$") ||
					updateBookPublisher.getText().matches("^[0-9]+$")){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, One or more fields is of numeric!");
				alert.showAndWait();
			}else if (updateBookName.getText().length()==0 ||updateBookAuthor.getText().length()==0 ||
					updateBookPublisher.getText().length()==0 ||referralChoices.getValue()==null ){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, One or more fields is not empty!");
				alert.showAndWait();
			}else if(!(articleSelect.isSelected() ||bookSelect.isSelected())){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Look, an Error Dialog");
				alert.setContentText("Ooops, Please select one of the radio button on the top of the page!");
				alert.showAndWait();
			}else {
			bookData.add(updateBookName.getText());
			bookData.add(updateBookAuthor.getText());
			bookData.add(updateBookIsbn.getText());
			bookData.add(updateBookPublisher.getText());
			bookData.add((String) referralChoices.getValue());
			System.out.println(bookData);
			if(articleSelect.isSelected()) {
				db1.insertUpdatedRecords(bookData,1);
			}else {
				db1.insertUpdatedRecords(bookData,2);
			}
			
			JOptionPane.showMessageDialog(null, "Book has been updated to Library Database");
			updateBookName.clear();
			updateBookAuthor.clear();
			updateBookIsbn.clear();
			updateBookPublisher.clear();
			referralChoices.setValue(null);
			updateBookId.setValue(null);
			articleSelect.setSelected(false);
			bookSelect.setSelected(false);

    		Staff st = new Staff();
    		st.updationOfBook();

			}
	    }
	    
	    @SuppressWarnings("unchecked")
		public void clearButtonClicked() throws IOException {
	    	updateBookName.clear();
			updateBookAuthor.clear();
			updateBookIsbn.clear();
			updateBookPublisher.clear();
			referralChoices.setValue(null);
			updateBookId.setValue(null);
			articleSelect.setSelected(false);
			bookSelect.setSelected(false);

    		Staff st = new Staff();
    		st.updationOfBook();
		
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


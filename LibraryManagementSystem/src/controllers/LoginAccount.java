package controllers;

import java.awt.Button;
import java.io.IOException;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.DaoModel;


public class LoginAccount  {
	public String userId;
	public String password;
	public Boolean accountStatus;
	
	ObservableList<String> choicesList = FXCollections.observableArrayList("@hawk.iit.edu","@iit.edu");
	ObservableList<String> selectionList = FXCollections.observableArrayList("Administrator","Staff", "Student");
	
		@FXML
	    private Button clearpressed;

	    @FXML
	    private Button loginpressed;

	    @FXML
	    private PasswordField passwordField;

	    
	    @FXML
	    private TextField emailField;

	    @FXML
	    private CheckBox remember;

	    @FXML
	    private Hyperlink forgotPassword;

	    @FXML
	    private Button exitpressed;
	    
		
		@SuppressWarnings("rawtypes")
		@FXML
		private ChoiceBox choices;
		@SuppressWarnings("rawtypes")
		@FXML
		private ChoiceBox selection;
			
		@FXML
		protected ResourceBundle resources;
		@FXML
		public javafx.scene.control.Button closeButton;


		@FXML
		public void closeButtonAction(){
		  // get a handle to the stage
		  Stage stage = (Stage) closeButton.getScene().getWindow();
		  // do what you have to do
		  stage.close();
		}
		
	  @SuppressWarnings("unchecked")
	  @FXML
	    public void clearFields() {
		  emailField.clear();
		  passwordField.clear();
		  choices.setValue(null);
		  selection.setValue(null);
		 
	    }
	 
	   
		public void initialize(){
	  		if(choices!=null && selection!=null) {
	  		loadSceneAndSendMessage();}
		 }
		
	  		@SuppressWarnings("unchecked")
		private void loadSceneAndSendMessage() {
	  		choices.setItems(choicesList);
	  			selection.setItems(selectionList);
	  	}
	  		
	  	public  void LoginAcc() throws IOException {
	  		String[] record = null;
	  		System.out.println("emailField");
	  		DaoModel dr = new DaoModel();
	  		String emailOrUsername =emailField.getText()+choices.getValue();
	  		System.out.println(emailOrUsername);
	  		if(selection.getValue()==null){
	  			Alert alert = new Alert(AlertType.ERROR);
	  			alert.setTitle("Error Dialog");
	  			alert.setHeaderText("Look, an Error Dialog");
	  			alert.setContentText("Select Administrator/Staff/Student");	
	  			alert.showAndWait();
	  			
	  		}
	  		else if(selection.getValue().equals("Administrator")) {
	  		    record = dr.retrieveRecords();
	  		 }else if(selection.getValue().equals("Student")) {
	  			 record = dr.retrieveStudentRecords(emailOrUsername);
	  		 }else if(selection.getValue().equals("Staff")) {
	  			 record = dr.retrieveStaffRecords(emailOrUsername);
	  		 }
	  		  
	  		if(!(selection.getValue()==null)) {
	  		  if(selection.getValue().equals("Administrator") && emailOrUsername.equals(record[0]) && passwordField.getText().equals(record[1])) {
	  			  
	  			  Administrator a = new Administrator();
	  			  a.intialize1();
		  	}
	  		  else if(selection.getValue().equals("Staff") && emailOrUsername.equals(record[0]) && passwordField.getText().equals(record[1])) {
	  			Staff stf = new Staff();
	  			stf.intialize1();
		  		}
	  		  else if(selection.getValue().equals("Student") && emailOrUsername.equals(record[0]) && passwordField.getText().equals(record[1])) {
	  			Student st = new Student();
	  			st.showPage(record[0]);
		  		}
	  		  else {
	  			Alert alert = new Alert(AlertType.ERROR);
	  			alert.setTitle("Error Dialog");
	  			alert.setHeaderText("Look, an Error Dialog");
	  			alert.setContentText("Username/Password didn't match");	
	  			alert.showAndWait();
	  		  }
			 }
	  	}
}
	
	
	


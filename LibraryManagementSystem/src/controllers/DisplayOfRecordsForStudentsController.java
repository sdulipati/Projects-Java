package controllers;

import java.io.IOException;
import java.net.URL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import models.DBConnect;
import models.DisplayModel;
import models.DaoModel;

import controllers.Student;

public  class DisplayOfRecordsForStudentsController extends Student implements Initializable{
	DBConnect conn = null;
	Statement stmt = null;
	 	
	@FXML
    private TableView<DisplayModel> tableView;
	
	 @FXML
	 private AnchorPane anchortable;

    @FXML
    private TableColumn<DisplayModel, String> col_id;

    @FXML
    private TableColumn<DisplayModel, String> col_name;

    @FXML
    private TableColumn<DisplayModel, String> col_isbn;

    @FXML
    private TableColumn<DisplayModel, String> col_author;

    @FXML
    private TableColumn<DisplayModel, String> col_published;
    
    @FXML
    private TableColumn<DisplayModel, String> col_edition;
    
    @FXML
    private TableColumn<DisplayModel, String> col_addedDate;
    
    @FXML
    private TableColumn<DisplayModel, String> col_isAvailable;

    @FXML
    private TableColumn<DisplayModel, String> col_isReferral;
 
    @FXML
    private TableView<DisplayModel> selectId;
    
    @FXML
    private TableColumn<DisplayModel, String> col_selectId;
    
    @FXML
    private TableColumn<DisplayModel, String> col_borrowDate;

    @FXML
    private TableColumn<DisplayModel, String> col_returnDate;
    
    @FXML
    private Button logoutButton;

    @FXML
    private Button back;
    
    Parent root = null;
    String idSelected;
    
	ObservableList<DisplayModel> data = 
					FXCollections.observableArrayList();
	ObservableList<DisplayModel> data1 = 
				FXCollections.observableArrayList();

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/DisplayOfRecordsForStudents.fxml"));
	
	public void initialize2() throws IOException  {
		LibraryManagementMain.stage.setScene(new Scene(loader.load()));
	}

	
	public void initialize(URL location,ResourceBundle resources) {
		
		initCol();
			
		try {
				loadData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			 LibraryManagementMain.stage.setTitle("Student Borrow Page");
			 LibraryManagementMain.stage.show();
			 System.out.println("url");
		
	    
		
		
	}


	private void loadData() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		DaoModel db1 = new DaoModel();
		
		if(articleSelected == 1) {
			rs= db1.retrieveIdRecords(articleSelected,query);
			while(rs.next()) {
				data1.add(new DisplayModel(rs.getString("id")));
			}
			selectId.getItems().setAll(data1);
			rs = db1.retrieveStudentTableRecords(articleSelected,query);
		}else if(bookSelected ==2) {
			rs= db1.retrieveIdRecords(bookSelected,query);
			while(rs.next()) {
				data1.add(new DisplayModel(rs.getString("id")));
			}
			selectId.getItems().setAll(data1);
			rs = db1.retrieveStudentTableRecords(bookSelected,query);
		}else if (articleSelection==3) {
			
			rs = db1.retrieveBorrowedRecords(studentEmail,articleSelection);
		}else if (bookSelection==4) {
			
			rs = db1.retrieveBorrowedRecords(studentEmail,bookSelection);
		}
		try {

			if(articleSelected == 1) {
				while(rs.next()) {
					data.add(new DisplayModel(rs.getString("id"),rs.getString("name"),
							rs.getString("isbn"),rs.getString("author"),rs.getString("publishedBy"),
							rs.getString("addedDate"),rs.getString("borrowedByStudentId"),rs.getString("borrowedByName"),
							rs.getString("borrowedDate"),rs.getString("returnDate"), 
							rs.getString("isAvailable"),rs.getString("isRefferal")));
				}
			}
				else if(bookSelected ==2) {
					
					while(rs.next()) {
						data.add(new DisplayModel(rs.getString("id"),rs.getString("name"),
								rs.getString("isbn"),rs.getString("author"), rs.getString("publishedBy"),
								rs.getString("edition"),rs.getString("addedDate")
								,rs.getString("borrowedByStudentId"),rs.getString("borrowedByName"),
								rs.getString("borrowedDate"),rs.getString("returnDate"), 
								rs.getString("isAvailable"),rs.getString("isRefferal")));
						System.out.println(rs.getString("isRefferal"));
						}
					
				}else if(articleSelection==3) {
					
					while(rs.next()) {
						System.out.println(rs.getString("id"));
						data.add(new DisplayModel(rs.getString("id"),rs.getString("name"),
								rs.getString("isbn"),rs.getString("author"),rs.getString("publishedBy"),
								rs.getString("borrowedByStudentId"),rs.getString("borrowedByName"),
								rs.getString("borrowedDate"),rs.getString("returnDate")));
					
					}
					
				}else if(bookSelection==4) {
					
					while(rs.next()) {
						data.add(new DisplayModel(rs.getString("id"),rs.getString("name"),
								rs.getString("isbn"),rs.getString("author"),rs.getString("publishedBy"),
								rs.getString("borrowedByStudentId"),rs.getString("borrowedByName"),
								rs.getString("borrowedDate"),rs.getString("returnDate")));
					}
				}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		tableView.getItems().setAll(data);
	}


	private void initCol() {
		// TODO Auto-generated method stub
		if(articleSelected==1) {
		   col_id.setCellValueFactory(new PropertyValueFactory<>("id"));	
		   col_name.setCellValueFactory(new PropertyValueFactory<>("artName"));
		   col_isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		   col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
		   col_published.setCellValueFactory(new PropertyValueFactory<>("publishedBy"));
		   col_isAvailable.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
		   col_isReferral.setCellValueFactory(new PropertyValueFactory<>("isReferral"));
		   col_selectId.setCellValueFactory(new PropertyValueFactory<>("id"));
		   
		}
		else if(bookSelected==2) {
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));	
			col_name.setCellValueFactory(new PropertyValueFactory<>("artName"));
			col_isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
			col_published.setCellValueFactory(new PropertyValueFactory<>("publishedBy"));
			col_edition.setCellValueFactory(new PropertyValueFactory<>("edition"));
			col_isAvailable.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
			col_isReferral.setCellValueFactory(new PropertyValueFactory<>("isReferral"));
			col_selectId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		}else if(articleSelection==3) {
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));	
			col_name.setCellValueFactory(new PropertyValueFactory<>("artName"));
			col_isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
			col_published.setCellValueFactory(new PropertyValueFactory<>("publishedBy"));
			col_borrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
			col_returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
		}else if(bookSelection==4 ) {
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));	
			col_name.setCellValueFactory(new PropertyValueFactory<>("artName"));
			col_isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
			col_published.setCellValueFactory(new PropertyValueFactory<>("publishedBy"));
			col_borrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
			col_returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
		}
	}
	public void borrowButtonClicked() throws SQLException, IOException {
		ResultSet rs = null;
		DaoModel db1 = new DaoModel();
		System.out.println("Borrow Button Clicked");
		DisplayModel idSelect = selectId.getSelectionModel().getSelectedItem();
   	 	idSelected = idSelect.getId();
   	 	String borrowedStudentId = null;
   	    String borrowedStudentName = null;
		
		rs = db1.retrieveStudentDetails(studentEmail);
		while(rs.next()) {
			borrowedStudentId   = rs.getString("studentId");
			borrowedStudentName = rs.getString("studentName");
		}
		
		if(articleSelected==1) {
		db1.insertBorrowDetails(idSelected,borrowedStudentId,borrowedStudentName,articleSelected);
		}else if(bookSelected==2) {
			db1.insertBorrowDetails(idSelected,borrowedStudentId,borrowedStudentName,bookSelected);
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Book has been borrowed from the library");
		alert.showAndWait();
		/*AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/StudentPage.fxml"));
		Scene scene1 = new Scene(root);
		LibraryManagementMain.stage.setTitle("Hi, IIT student");
		LibraryManagementMain.stage.setScene(scene1);
		LibraryManagementMain.stage.show();
		*/
		
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
		articleSelected = 0;
		bookSelected = 0;
		articleSelection = 0;
		bookSelection = 0;
    	AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/StudentPage.fxml"));
		Scene scene1 = new Scene(root);
		LibraryManagementMain.stage.setTitle("Hi, IIT student");
		LibraryManagementMain.stage.setScene(scene1);
		LibraryManagementMain.stage.show();

 		  
     }

	}
	
	

	

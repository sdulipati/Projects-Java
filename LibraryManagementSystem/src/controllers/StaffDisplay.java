package controllers;

import java.io.IOException;
import java.net.URL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.DBConnect;
import models.DisplayModel;
import models.DaoModel;

import controllers.Administrator;
import controllers.Staff;

public  class StaffDisplay extends Staff implements Initializable{
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
    private TableColumn<DisplayModel, String> col_borrowedBystudentId;
 
    @FXML
    private TableColumn<DisplayModel, String> col_borrowedByStudentName;
 
    @FXML
    private TableColumn<DisplayModel, String> col_borrowedDate;
    
    @FXML
    private TableColumn<DisplayModel, String> col_returnDate;
    
    @FXML
    private TableColumn<DisplayModel, String> col_isAvailable;

    @FXML
    private TableColumn<DisplayModel, String> col_isReferral;
 
    @FXML
    private Button back;
    
 
    
    Parent root = null;
    
		ObservableList<DisplayModel> data = 
					FXCollections.observableArrayList();
	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/StaffDisplay.fxml"));
	public void initialize2() throws IOException  {
		// TODO Auto-generated method stub
		
		
		/*try {
				 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		 	LibraryManagementMain.stage.setScene(new Scene(loader.load()));
			
		 
		 }

	
	public void initialize(URL location,ResourceBundle resources) {
		initCol();
		DBConnect handler = new DBConnect();
			
			try {
				loadData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			 LibraryManagementMain.stage.setTitle("Display Page");
			 LibraryManagementMain.stage.show();
			 System.out.println("url");
		
	    
		
		
	}


	private void loadData() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		DaoModel db1 = new DaoModel();
		if(articleSelected) {
			rs = db1.retrieveStaffBookRecords(1,query);
		}else {
			System.out.print(query);
			rs = db1.retrieveStaffBookRecords(2,query);
		}
		try {
			if(articleSelected) {
				while(rs.next()) {
					data.add(new DisplayModel(rs.getString("id"),rs.getString("name"),
							rs.getString("isbn"),rs.getString("author"),rs.getString("publishedBy"),
							rs.getString("addedDate"),rs.getString("borrowedkByStudentId"),rs.getString("borrowedByName"),
							rs.getString("borrowedDate"),rs.getString("returnDate"), 
							rs.getString("isAvailable"),rs.getString("isRefferal")));
				}}
				else if(bookSelectedStaff) {
					
					while(rs.next()) {
						data.add(new DisplayModel(rs.getString("id"),rs.getString("name"),
								rs.getString("isbn"),rs.getString("author"), rs.getString("publishedBy"),
								rs.getString("edition"),rs.getString("addedDate")
								,rs.getString("borrowedkByStudentId"),rs.getString("borrowedByName"),
								rs.getString("borrowedDate"),rs.getString("returnDate"), 
								rs.getString("isAvailable"),rs.getString("isRefferal")));
						System.out.println(rs.getString("isRefferal"));
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
		if(articleSelected) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));	
		   col_name.setCellValueFactory(new PropertyValueFactory<>("artName"));
		   col_isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		   col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
		   col_published.setCellValueFactory(new PropertyValueFactory<>("publishedBy"));
		   col_borrowedBystudentId.setCellValueFactory(new PropertyValueFactory<>("borrowedByStudentId"));
		   col_borrowedByStudentName.setCellValueFactory(new PropertyValueFactory<>("borrowedByName"));
		   col_borrowedDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
		   col_returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
		   col_addedDate.setCellValueFactory(new PropertyValueFactory<>("addedDate"));
		   col_isAvailable.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
		   col_isReferral.setCellValueFactory(new PropertyValueFactory<>("isReferral"));
		}
		else if(bookSelectedStaff) {
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));	
			col_name.setCellValueFactory(new PropertyValueFactory<>("artName"));
			col_isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("author"));
			col_published.setCellValueFactory(new PropertyValueFactory<>("publishedBy"));
			col_edition.setCellValueFactory(new PropertyValueFactory<>("edition"));
			col_borrowedBystudentId.setCellValueFactory(new PropertyValueFactory<>("borrowedByStudentId"));
			col_borrowedByStudentName.setCellValueFactory(new PropertyValueFactory<>("borrowedByName"));
			col_borrowedDate.setCellValueFactory(new PropertyValueFactory<>("borrowedDate"));
			col_returnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
			col_addedDate.setCellValueFactory(new PropertyValueFactory<>("addedDate"));
			col_isAvailable.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
			col_isReferral.setCellValueFactory(new PropertyValueFactory<>("isReferral"));
		//	System.out.println("col_isReferral.setCellValueFactory(new PropertyValueFactory<>("isRefferal"))");
		}
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
	
	

	

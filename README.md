# Java-Projects
This repository contains Mini Projects on Bank Records and a Project on Library Management System.

## Mini Project 1
This Project will prompt users for options such as creating an initial balance, entering deposits or withdrawals. Also this program will allow for the printing of account information including interest at various interest rates. This program will create two separate Java files within your package, namely AccountHolder and AccountHolderTest.

### Project Details
The AccountHolder file include the following class field members and data methods to allow for transaction processing.

Field Name Field modifier/type annualInterestRate static / double balance double totalDeposit double withdrawAmount double

Method Name Method (Instance or Static) Argument Return Type AccountHolder Constructor double none deposit Instance double void getDeposit Instance void double withdrawal Instance double void getWithdrawal Instance void double totalBalanceAmount Instance void double modifyMonthlyInterest Static double void monthlyInterest Instance void void interestCalculation Instance void void toString Instance void String.


## Mini Project 2
This Project parses and processes bank data from a file.

### Project Details
-An abstract class called Client.java is created to allow for three abstract methods the bank needs to process. Method names are readData(), processData() and printData(). -bank-Detail.csv contains valuable raw data which allows the bank to process loans based on client details from the file. 
-A BankRecords.java file is created which will utilize the Client abstract methods and generate ultimately the client records from the csv file. 
The client file has the following header information 
id {string} 
age {numeric}
sex {FEMALE,MALE region {INNER_CITY,TOWN,RURAL,SUBURBAN}
income {numeric}
married {NO,YES}
children {0,1,2,3}
car {NO,YES}
save_act {NO,YES}
current_act {NO,YES}
mortgage {NO,YES}
pep {YES,NO}



## Mini Project 3
This Project performs data analysis from class objects created in MiniProject 2.

### Project Details

-A new class called Records has been added to existing project files from MiniProject 2. This class extend the BankRecords class to grab hold its instance methods plus the BankRecord object array.

-This project contains comparator classes implementing java.util.Comparator for comparing various fields for the following data analysis requirements.

-This Project performs the following analysis requirements and output detail for the Records class

The following data analytics in a coherent manner are displayed to the console:

1> average income per location 2> max and min income per location 3> number of females with both a mortgage and savings account per location 3> number of males with both a car and 1 child per location

-All displayed data are written into a text file called bankrecords.txt. -This Project implements Serialization and Deserialization of Objects.



## Mini Project 4
This project uses a MVC ‘simulated’ approach that performs a Loan analysis from class objects created in project #2.

### Project Details  	
For this project we will create the following packages & their containments in an MVC style as follows:

Package: models
File DbConnect: will allow an object to connect / close a database connection.
File DaoModel: where Dao stands for Data Access Object, defines CRUD (Create Read Update Delete) like operations.  

Package: controllers
File LoanProcessing: acts as a controller or “driver” file (i.e., includes main function) to run database CRUD methods and fires up some resulting output.

Package: views
File LoanView: shows JTable output.



## Project - Library Management System
Library management software for monitoring and controlling the transactions in a library. The project “Library Management System” is developed in java, which mainly focuses on basic operations in a library like adding new member, new books, and updating new information, searching books and members and facility to borrow books.
The project is about library management system focuses on basic operation in a library like adding a new member, new books and updating a new information ,searching books and members and facility to borrow books. This application can be accessed by three types of users.  
 
•	Administrator 
•	Staff Members
•	Students
 
Administrator has the privilege of adding, updating and deletion of library books, add, update and deletion of staff members of the library. The staff members can add, update and delete books and search books. Students can borrow  nad search books from the library.
 


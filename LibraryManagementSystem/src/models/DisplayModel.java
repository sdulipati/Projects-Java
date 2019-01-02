package models;


public  class DisplayModel {

	private String id, artName,isbn, author,publishedBy,edition,addedDate,borrowedByStudentId,borrowedByName;
	private String borrowedDate,returnDate,isAvailable,isReferral;

	public DisplayModel(String id, String artName, String isbn, String author, String publishedBy, String edition,
			String addedDate, String borrowedByStudentId, String borrowedByName, String borrowedDate, String returnDate,
			String isAvailable, String isReferral) {
		super();
		this.id = id;
		this.artName = artName;
		this.isbn = isbn;
		this.author = author;
		this.publishedBy = publishedBy;
		this.edition = edition;
		this.addedDate = addedDate;
		this.borrowedByStudentId = borrowedByStudentId;
		this.borrowedByName = borrowedByName;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
		this.isAvailable = isAvailable;
		this.isReferral = isReferral;
	}

	public DisplayModel(String id, String artName, String isbn, String author, String publishedBy, String addedDate,
			String borrowedByStudentId, String borrowedByName, String borrowedDate, String returnDate,
			String isAvailable, String isReferral) {
		super();
		this.id = id;
		this.artName = artName;
		this.isbn = isbn;
		this.author = author;
		this.publishedBy = publishedBy;
		this.addedDate = addedDate;
		this.borrowedByStudentId = borrowedByStudentId;
		this.borrowedByName = borrowedByName;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
		this.isAvailable = isAvailable;
		this.isReferral = isReferral;
	}
	public DisplayModel(String id, String artName, String isbn, String author, String publishedBy,
			String borrowedByStudentId, String borrowedByName, String borrowedDate, String returnDate) {
		super();
		this.id = id;
		this.artName = artName;
		this.isbn = isbn;
		this.author = author;
		this.publishedBy = publishedBy;
		this.borrowedByStudentId = borrowedByStudentId;
		this.borrowedByName = borrowedByName;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
	}
	public DisplayModel(String artName, String isbn, String author, String publishedBy,String isReferral) {
		super();
		this.artName = artName;
		this.isbn = isbn;
		this.author = author;
		this.publishedBy = publishedBy;
		this.isReferral = isReferral;
	}
	
	public DisplayModel(String id) {
		super();
		this.id = id;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(String publishedBy) {
		this.publishedBy = publishedBy;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public String getBorrowedByStudentId() {
		return borrowedByStudentId;
	}

	public void setBorrowedByStudentId(String borrowedByStudentId) {
		this.borrowedByStudentId = borrowedByStudentId;
	}

	public String getBorrowedByName() {
		return borrowedByName;
	}

	public void setBorrowedByName(String borrowedByName) {
		this.borrowedByName = borrowedByName;
	}

	public String getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(String borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getIsReferral() {
		return isReferral;
	}

	public void setIsReferral(String isReferral) {
		this.isReferral = isReferral;
	}

	public DisplayModel() {
		// TODO Auto-generated constructor stub
	}

	
	

				
}

package models;

public class StaffModel {

	private String idStaff, nameStaff,emailStaff, passwordStaff,cellStaff,addressStaff;

	public StaffModel(String idStaff, String nameStaff, String emailStaff, String passwordStaff, String cellStaff,
			String addressStaff) {
		super();
		this.idStaff = idStaff;
		this.nameStaff = nameStaff;
		this.emailStaff = emailStaff;
		this.passwordStaff = passwordStaff;
		this.cellStaff = cellStaff;
		this.addressStaff = addressStaff;
	}
	public StaffModel(String idStaff) {
		super();
		this.idStaff = idStaff;
	}
	public String getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}

	public String getNameStaff() {
		return nameStaff;
	}

	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}

	public String getEmailStaff() {
		return emailStaff;
	}

	public void setEmailStaff(String emailStaff) {
		this.emailStaff = emailStaff;
	}

	public String getPasswordStaff() {
		return passwordStaff;
	}

	public void setPasswordStaff(String passwordStaff) {
		this.passwordStaff = passwordStaff;
	}

	public String getCellStaff() {
		return cellStaff;
	}

	public void setCellStaff(String cellStaff) {
		this.cellStaff = cellStaff;
	}

	public String getAddressStaff() {
		return addressStaff;
	}

	public void setAddressStaff(String addressStaff) {
		this.addressStaff = addressStaff;
	}
}

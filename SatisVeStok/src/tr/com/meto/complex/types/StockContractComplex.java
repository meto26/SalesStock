package tr.com.meto.complex.types;

import java.sql.Date;

public class StockContractComplex {
	
	private int id;
	private String productName;
	private String personalName;
	private Date date;
	private int piece;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPiece() {
		return piece;
	}
	public void setPiece(int piece) {
		this.piece = piece;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return personalName +" "+ productName;
	}

}

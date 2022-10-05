package tr.com.meto.types;

import java.util.Date;

public class StockContract {
	private int id;
	private int personalId;
	private int productId;
	private Date date;
	private int piece;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonalId() {
		return personalId;
	}
	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
		return id+" "+personalId+" "+productId+" "+date+" "+piece;
	}
}

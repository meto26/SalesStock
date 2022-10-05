package tr.com.meto.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tr.com.meto.core.ObjectHelper;
import tr.com.meto.interfaces.IDal;
import tr.com.meto.types.ProductsContract;

public class ProductDAL extends ObjectHelper implements IDal<ProductsContract> {

	@Override
	public void Insert(ProductsContract entity) {
		Connection connection = getConnection();
		 try {
			Statement statement  = connection.createStatement();
			statement.executeUpdate("INSERT INTO Urunler(Adi,KategoriId,Tarih,Fiyat)" 
			+"VALUES('"+entity.getName()+"',"			
			+entity.getCategoryId()
			+",'"
			+entity.getDate()
			+"',"
			+entity.getPrice()
			+")");
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	@Override
	public List<ProductsContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductsContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductsContract Delete(ProductsContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(ProductsContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductsContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
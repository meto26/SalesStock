package tr.com.meto.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tr.com.meto.core.ObjectHelper;
import tr.com.meto.interfaces.IDal;
import tr.com.meto.types.CustomerContract;

public class CustomerDAL extends ObjectHelper implements IDal<CustomerContract> {

	@Override
	public void Insert(CustomerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			//Database Added
			statement.executeUpdate("INSERT INTO Musteri(AdiSoyadi,Telefon,Adres,SehirId) VALUES('"
			+entity.getNameSurname() 
			+ "','"
			+entity.getTelNumber()+
			"','"
			+entity.getAdress()
			+"',"
			+entity.getCityId()+")");
			statement.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public List<CustomerContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerContract Delete(CustomerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(CustomerContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

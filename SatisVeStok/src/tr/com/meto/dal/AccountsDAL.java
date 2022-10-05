package tr.com.meto.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tr.com.meto.core.ObjectHelper;
import tr.com.meto.interfaces.IDal;
import tr.com.meto.types.AccountsContract;

public class AccountsDAL extends ObjectHelper implements IDal<AccountsContract> {

	@Override
	public void Insert(AccountsContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			//Database Added
			statement.executeUpdate("INSERT INTO Accounts(PersonelId,YetkiId,Sifre)"
			+ " VALUES("
			+ entity.getPersonalId() 
			+ ","
			+ entity.getAuthorityId()
			+ ",'"
			+ entity.getPassword() 
			+ "')");
			statement.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public List<AccountsContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountsContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountsContract Delete(AccountsContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(AccountsContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AccountsContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

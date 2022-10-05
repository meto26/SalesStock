package tr.com.meto.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.meto.core.ObjectHelper;
import tr.com.meto.interfaces.IDal;
import tr.com.meto.types.AuthorysContract;
import tr.com.meto.types.PersonalContract;

public class AuthoryDAL extends ObjectHelper implements IDal<AuthorysContract>{

	@Override
	public void Insert(AuthorysContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			//Database Added
			statement.executeUpdate("INSERT INTO Yetkiler(Adi) VALUES('" + entity.getName() + "')");
			statement.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public List<AuthorysContract> GetAll() {
		List<AuthorysContract> datacontract = new ArrayList<AuthorysContract>();

		Connection connection = getConnection();
		AuthorysContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Yetkiler");
			while (resultSet.next()) {
				contract = new AuthorysContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setName(resultSet.getString("Adi"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return datacontract;
	}

	@Override
	public List<AuthorysContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthorysContract Delete(AuthorysContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(AuthorysContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AuthorysContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

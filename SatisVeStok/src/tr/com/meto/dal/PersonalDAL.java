package tr.com.meto.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.meto.core.ObjectHelper;
import tr.com.meto.interfaces.IDal;

import tr.com.meto.types.PersonalContract;

public class PersonalDAL extends ObjectHelper implements IDal<PersonalContract>{

	@Override
	public void Insert(PersonalContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			//Database Added
			statement.executeUpdate("INSERT INTO Personel(AdiSoyadi,Email) "
					+ "VALUES('"
					+ entity.getNameSurname() 
					+"','"
					+ entity.getEmail() 
					+ "')");
			statement.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	
	}

	@Override
	public List<PersonalContract> GetAll() {
		List<PersonalContract> datacontract = new ArrayList<PersonalContract>();

		Connection connection = getConnection();
		PersonalContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Personel");
			while (resultSet.next()) {
				contract = new PersonalContract();
				
				contract.setId(resultSet.getInt("Id"));
				contract.setNameSurname(resultSet.getString("AdiSoyadi"));
				contract.setEmail(resultSet.getString("Email"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return datacontract;
	}

	@Override
	public List<PersonalContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonalContract Delete(PersonalContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(PersonalContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonalContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}

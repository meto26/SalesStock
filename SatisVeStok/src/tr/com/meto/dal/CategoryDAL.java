package tr.com.meto.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.meto.core.ObjectHelper;
import tr.com.meto.interfaces.IDal;
import tr.com.meto.types.CategoryContract;

public class CategoryDAL extends ObjectHelper implements IDal<CategoryContract> {

	@Override
	public void Insert(CategoryContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			//Database Added
			statement.executeUpdate("INSERT INTO Kategori(Adi,ParentId) VALUES('" + entity.getName() + "',"
					+ entity.getParentId() + ")");
			statement.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<CategoryContract> GetAll() {
		List<CategoryContract> datacontract = new ArrayList<CategoryContract>();

		Connection connection = getConnection();
		CategoryContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori");
			while (resultSet.next()) {
				contract = new CategoryContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setName(resultSet.getString("Adi"));
				contract.setParentId(resultSet.getInt("ParentId"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return datacontract;
	}

	@Override
	public List<CategoryContract> GetAllParentId() {
		List<CategoryContract> datacontract = new ArrayList<CategoryContract>();

		Connection connection = getConnection();
		CategoryContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori WHERE parentId=0");
			while (resultSet.next()) {
				contract = new CategoryContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setName(resultSet.getString("Adi"));
				contract.setParentId(resultSet.getInt("ParentId"));

				datacontract.add(contract);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return datacontract;
	}

	@Override
	public CategoryContract Delete(CategoryContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(CategoryContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CategoryContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
package onboard.signin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import onboard.common.constants.DBConstants;
import onboard.database.ConnectionFactory;
import onboard.signin.beans.UserCredential;
import onboard.signin.constants.SignInConstants;

public class SignInDAO {

	private static final String COMMA = " , ";
	private static final String SPACE = " ";

	public boolean isUserRegistered(UserCredential credential) {
		String userName = credential.getUserName();
		String password = credential.getPassword();
		Connection conn = ConnectionFactory.getDbConnection();
		try {
			StringBuilder query = new StringBuilder("");
			query.append("Select * From").append(SPACE);
			query.append(DBConstants.USER_DETAILS.getName()).append(SPACE);
			query.append("WHERE").append(SPACE);
			query.append("mobile_number=?");
			PreparedStatement statement = conn.prepareStatement(query.toString());
			statement.setString(1, userName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String dbPassword = resultSet.getString(SignInConstants.PASSWORD);
				if (dbPassword.equals(password))
					return true;
			}

		} catch (SQLException ex) {
			// LOG
			System.out.println("SQL Exception occurred..");
			ex.printStackTrace();
			return false;
		}
		finally
		{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return false;
	}

}

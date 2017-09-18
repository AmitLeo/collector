package onboard.signup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import onboard.common.constants.DBConstants;
import onboard.database.ConnectionFactory;
import onboard.signup.beans.Address;
import onboard.signup.beans.Seller;

public class SignUpDAO  {

	private static final String COMMA = " , ";
	private static final String SPACE = " ";

	// to do : CRUD

	public void addSeller(Seller seller) throws Exception {
		Connection con = ConnectionFactory.getDbConnection();
		try {
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO").append(SPACE);
			query.append(DBConstants.USER_DETAILS.getName()).append(SPACE);
			query.append("VALUES ( ?, ?, ?, ?)");
			PreparedStatement pStatement = con.prepareStatement(query.toString());
			pStatement.setString(1, seller.getPhoneNumber());
			pStatement.setString(2, seller.getEmailId());
			pStatement.setString(3, seller.getName());
			pStatement.setString(4, seller.getPassword());
			pStatement.execute();
			addAddress(seller, seller.getAddress());

		} catch (Exception ex) {
			
			ex.printStackTrace();
			// to do : handle this exception

		} finally {
			try {
			if(con!=null)
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private void addAddress(Seller seller, Address address) {
		Connection con = ConnectionFactory.getDbConnection();
		try {
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO").append(SPACE);
			query.append(DBConstants.ADDRESS.getAddress()).append(SPACE);
			query.append("VALUES(?, ?, ?, ?, ?, ?)");
			PreparedStatement pStatement = con.prepareStatement(query.toString());
			pStatement.setString(1, seller.getPhoneNumber());
			pStatement.setString(2, address.getPlotNumber());
			pStatement.setString(3, address.getArea());
			pStatement.setString(4, address.getCity());
			pStatement.setLong(5, address.getPinCode());
			pStatement.setString(6, address.getState());
			
			pStatement.execute();

		} catch (Exception ex) {
			System.out.println("Handle exception if any");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean isSellerRegistered(Seller seller)
	{
		String name = seller.getPhoneNumber();
		boolean isSellerRegistered = false;
		Connection conn = ConnectionFactory.getDbConnection();
		try {
			StringBuilder query = new StringBuilder("");
			query.append("Select * From").append(SPACE);
			query.append(DBConstants.USER_DETAILS.getName()).append(SPACE);
			query.append("WHERE").append(SPACE);
			query.append("mobile_number=?");
			PreparedStatement statement = conn.prepareStatement(query.toString());
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				isSellerRegistered = true;
			}

		} catch (SQLException ex) {
			// LOG
			System.out.println("SQL Exception occurred..");
			ex.printStackTrace();
			return isSellerRegistered;
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

		return isSellerRegistered;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Customer;

public class CustomerDAO extends DAO {
	public Customer search(String login, String password)
			throws Exception {
		Customer customer = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"select * from customer where login=? and password=?");
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return customer;
	}

	public List<Customer> search(String login)
			throws Exception {
		List<Customer> list = new ArrayList<Customer>();

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"select * from customer where login like ?");
		st.setString(1, "%" + login + "%");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
			list.add(customer);
		}

		st.close();
		con.close();
		return list;
	}

	public int insert(Customer customer) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into customer(login, password) values(?, ?)");
		st.setString(1, customer.getLogin());
		st.setString(2, customer.getPassword());
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}
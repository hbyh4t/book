package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Customer;
import bean.Product;

public class CustomerExDAO extends DAO {

	public List<Customer> search(String keyword) throws Exception {
		List<Customer> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from customer where login = ?");
		st.setString(1, keyword);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Customer c = new Customer();
			c.setId(rs.getInt("id"));
			c.setLogin(rs.getString("login"));
			c.setPassword(rs.getString("password"));
			list.add(c);
		}

		st.close();
		con.close();

		return list;
	}

	@Deprecated
	public int insert(Product product) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into product(name, price) values(?, ?)");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}
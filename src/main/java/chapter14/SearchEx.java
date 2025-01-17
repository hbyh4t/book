package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = { "/chapter14/searchex" })
public class SearchEx extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup(
					"java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			String name = request.getParameter("name");
			String price = request.getParameter("price");

			StringBuffer sql = new StringBuffer("select * from product where ");

			if (name.isBlank() == false)
				sql.append(" name like ? ");

			if (price.isBlank() == false) {
				if (name.isBlank() == false)
					sql.append("and");
				sql.append(" price = ?");
			}

			System.out.println(sql.toString());
			
			if (name.isBlank() && price.isBlank()) {
				out.println("検索キーワードを入力してください。");
			} else {

				PreparedStatement st = con.prepareStatement(sql.toString());

				if (name.isBlank() == false)
					st.setString(1, "%" + name + "%");
				if (price.isBlank() == false) {
					if (name.isBlank() == false)
						st.setInt(2, Integer.parseInt(price));
					else
						st.setInt(1, Integer.parseInt(price));
				}

				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					out.println(rs.getInt("id"));
					out.println("：");
					out.println(rs.getString("name"));
					out.println("：");
					out.println(rs.getInt("price"));
					out.println("<br>");
				}
				st.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}

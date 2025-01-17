package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = { "/chapter14/transaction_isolation" })
public class TransactionIsolation extends HttpServlet {

	public void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup(
					"java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			switch (con.getTransactionIsolation()) {
			case Connection.TRANSACTION_SERIALIZABLE:
				out.println("SERIALIZABLE");
				break;
			case Connection.TRANSACTION_REPEATABLE_READ:
				out.println("REPEATABLE_READ");
				break;
			case Connection.TRANSACTION_READ_COMMITTED:
				out.println("READ_COMMITTED");
				break;
			case Connection.TRANSACTION_READ_UNCOMMITTED:
				out.println("READ_UNCOMMITTED");
				break;
			default:
				out.println("NONE");
				break;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}

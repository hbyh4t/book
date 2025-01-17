package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = { "/chapter6/reserve" })
public class Reserve extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		Page.header(out);

		request.setCharacterEncoding("UTF-8");
		
		String count = request.getParameter("count");
		String seat = request.getParameter("seat");
		
		String[] option = request.getParameterValues("opton");
		
		List<String> names = Collections.list(request.getParameterNames());
		for (String name : names) {
			String[] values = request.getParameterValues(name);
			for (String value : values) {
				out.println("<p>" + name + "=" + value + "</p>");
			}
		}
		Page.footer(out);
	}
}
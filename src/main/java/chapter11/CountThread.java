package chapter11;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = {"/chapter11/count-thread"})
public class CountThread extends HttpServlet {
	int count;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		PrintWriter out = resp.getWriter();
		Page.header(out);

		int i = count;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		count = i + 1;
		out.println(count);

		Page.footer(out);
	}

}

package chapter19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = { "/chapter19/attribute" })
public class Attribute extends HttpServlet {

	public void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);

		ServletContext context = getServletContext();
		String path = context.getRealPath("WEB-INF/setting.txt");
		FileInputStream in = new FileInputStream(path);
		Properties p = new Properties();
		p.load(in);
		in.close();

		for (String name : p.stringPropertyNames()) {
			context.setAttribute(name, p.getProperty(name));
		}
		out.println("アプリケーション属性を設定しました。");

		Page.footer(out);
	}
}
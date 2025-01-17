package chapter11;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/chapter11/life-cycle"})
public class LifeCycle extends HttpServlet {

	public void init() throws ServletException {
		System.out.println("LifeCycle init");
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycle service");
		super.service(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycle doGet");
	}
	
	public void destroy() {
		System.out.println("LifeCycle destroy");
	}
}

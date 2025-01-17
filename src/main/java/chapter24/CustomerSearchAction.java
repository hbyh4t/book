package chapter24;

import java.util.List;

import bean.Customer;
import dao.CustomerDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class CustomerSearchAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String keyword = request.getParameter("keyword");

		CustomerDAO dao = new CustomerDAO();
		List<Customer> list = dao.search(keyword);

		request.setAttribute("list", list);

		return "customer-list.jsp";
	}
}
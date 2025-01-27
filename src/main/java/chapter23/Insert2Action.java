package chapter23;

import java.util.List;

import bean.Product;
import dao.ProductDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class Insert2Action extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String name = request.getParameter("name");
		Integer price = Integer.parseInt(request.getParameter("price"));

		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		ProductDAO dao = new ProductDAO();
		dao.insert(p);

		p = new Product();
		p.setName(name + "づくし");
		p.setPrice(price * 5);
		dao.insert(p);
		
		List<Product> list = dao.search("");
		request.setAttribute("list", list);

		return "list.jsp";
	}
}
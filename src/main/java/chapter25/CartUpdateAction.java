package chapter25;

import java.util.ArrayList;
import java.util.List;

import bean.Item;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class CartUpdateAction extends Action {

	@SuppressWarnings("unchecked")
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<Item>();
			session.setAttribute("cart", cart);
		}

		for (Item i : cart) {
			if (i.getProduct().getId() == id) {
				i.setCount(quantity);
				return "cart.jsp";
			}
		}

		return "cart.jsp";
	}
}
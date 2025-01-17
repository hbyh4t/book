package secure_page;

import java.io.IOException;
import java.util.List;

import bean.Customer;
import dao.CustomerExDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/secure_page/login") // "/login" ページにアクセスする
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 簡易的な認証チェック
		try {
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html; charset=UTF-8");
//			response.setCharacterEncoding("UTF-8");
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			CustomerExDAO dao = new CustomerExDAO();
			List<Customer> list = dao.search(username);

			if (list != null && list.isEmpty() == false) {
				for (Customer c : list) {
					if (c.getPassword().equals(password)) {
						// 認証成功 → セッションにユーザー情報を保存
						request.getSession().setAttribute("authenticatedUser", username);
						response.sendRedirect(request.getContextPath() + "/secure/data");
					} else {
						// 認証失敗 → エラーメッセージを返す
						response.getWriter().println("ログイン失敗: ユーザー名またはパスワードが正しくありません");
					}
				}
			} else {
				// 認証失敗 → エラーメッセージを返す
				response.getWriter().println("ログイン失敗: ユーザー名またはパスワードが正しくありません");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//		if ("user".equals(username) && "password".equals(password)) {
		//			// 認証成功 → セッションにユーザー情報を保存
		//			request.getSession().setAttribute("authenticatedUser", username);
		//			response.sendRedirect(request.getContextPath() + "/secure/data");
		//		} else {
		//			// 認証失敗 → エラーメッセージを返す
		//			response.getWriter().println("ログイン失敗: ユーザー名またはパスワードが正しくありません");
		//		}
	}
}
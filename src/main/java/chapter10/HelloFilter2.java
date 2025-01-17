package chapter10;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class HelloFilter2 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO 自動生成されたメソッド・スタブ
		PrintWriter out = response.getWriter();

		out.println("[HelloFilter2(pre)]");
		chain.doFilter(request, response);
		out.println("[HelloFilter2(post)]");
	}

	public void init(FilterConfig config) {
	}

	public void destroy() {
	}
}

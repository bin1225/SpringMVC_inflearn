package hello.servlet.basic.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseServlet", urlPatterns = "/response-header")
public class ResponseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setStatus(HttpServletResponse.SC_OK);
		Cookie cookie = new Cookie("cookie", "good");
		cookie.setMaxAge(600);
		response.addCookie(cookie);

		response.sendRedirect("basic/hello-form.html");
		response.getWriter().write("ok");
	}
}

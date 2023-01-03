package hello.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet  extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("RequestParamServlet.service");

		request.getParameterNames().asIterator()
			.forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

		System.out.println("이름이 같은 복수 파라미터 조회");
		String[] usernames = request.getParameterValues("username");
		for(String s : usernames){
			System.out.println("username : " + s);
		}
		response.getWriter().write("ok");
	}
}

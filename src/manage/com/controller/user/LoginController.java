package manage.com.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.com.dao.UserDao;
import manage.com.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //指定返回的格式为JSON格式
        response.setContentType("application/json;charset=utf-8");
        //setContentType与setCharacterEncoding的顺序不能调换
        // 否则还是无法解决中文乱码的问题
        response.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDao userDao=new UserDaoImpl();
		try {
			Map<String, Object> login = userDao.userLogin(username, password);
			if (login!=null) {
				request.getSession().setAttribute("user",login);
				 response.getWriter().print(1);
			}else {
				 response.getWriter().print(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

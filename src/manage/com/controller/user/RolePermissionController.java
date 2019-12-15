package manage.com.controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.com.dao.RolePermissionDao;
import manage.com.dao.UserDao;
import manage.com.dao.impl.RolePermissionDaoImpl;
import manage.com.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class RolePermissionController
 */
@WebServlet("/RolePermissionController")
public class RolePermissionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolePermissionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
				RolePermissionDao rolePermissionDao = new RolePermissionDaoImpl();
				try {
					List<Map<String, Object>> userRolePermissionList = rolePermissionDao.getUserRolePermissionList("10001");
					System.out.println("_------角色信息-------");
					userRolePermissionList.forEach(t->{
						System.out.println(t);
					});
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

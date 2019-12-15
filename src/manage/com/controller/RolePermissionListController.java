package manage.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.com.dao.DoLogDao;
import manage.com.dao.RolePermissionDao;
import manage.com.dao.impl.DoLogDaoImpl;
import manage.com.dao.impl.RolePermissionDaoImpl;
import manage.com.utils.Page;

/**
 * Servlet implementation class RolePermissionListController
 */
@WebServlet("/RolePermissionListController")
public class RolePermissionListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolePermissionListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		/**
		 * 模糊查询的列表头和值
		 */
		String columnName = request.getParameter("columnName");
		String columnValue = request.getParameter("columnValue");
		if (columnName != null && columnName != "") {
			request.getSession().setAttribute("columnName", columnName);
		} else {
			request.getSession().removeAttribute("columnName");
			columnName = null;
		}
		if (columnValue != null && columnValue != "") {
			request.getSession().setAttribute("columnValue", columnValue);
		} else {
			request.getSession().removeAttribute("columnValue");
			columnName = null;
			columnValue = null;
		}
		RolePermissionDao rolePermissionDao = new RolePermissionDaoImpl();
		try {
			Page page = rolePermissionDao.getPageByLike(Integer.parseInt(request.getParameter("pageNum")) - 1, 8, columnName,
					columnValue);
			System.out.println("得到的数据是：-----------------------------------");
			System.out.println(page);
			page.getList().forEach(t -> {
				System.out.println(t);
			});
			System.out.println("--------------------");
			request.setAttribute("page", page);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/rolePermission/rolePermissionList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

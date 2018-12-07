package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LopHoc;
import connection.DBConnection;
import utils.DBUtils;

/**
 * Servlet implementation class QuanLyLopHoc
 */
@WebServlet("/QuanLyLopHoc")
public class QuanLyLopHoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyLopHoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String err = null;
		List<LopHoc>list= null;
		try {
			Connection conn = 	DBConnection.getMyConnection();
			list = DBUtils.LayDSLopHoc(conn);
			request.setAttribute("dsLopHoc", list);
		}
		catch (Exception e) {
			err = e.getMessage();
			System.out.println(err);
			// TODO: handle exception
		}
        RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/QuanLyLopHoc.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

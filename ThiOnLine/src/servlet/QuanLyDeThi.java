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

import beans.DeThi;
import connection.DBConnection;
import utils.DBUtils;

/**
 * Servlet implementation class QuanLyDeThi
 */
@WebServlet("/QuanLyDeThi")
public class QuanLyDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request==null) {
			
		}
		else {
			List<DeThi> rsList = null;
			String err = null;
			try {
				Connection conn = DBConnection.getMyConnection();
				rsList = DBUtils.LayDSDeThi(conn);
			}
			catch(Exception e)
			{
				err = e.getMessage();
				System.out.println(err);
			}
			request.setAttribute("DSDeThi", rsList);
			request.setAttribute("error", err);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/QuanLyDeThi.jsp");
			dispatcher.forward(request, response);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

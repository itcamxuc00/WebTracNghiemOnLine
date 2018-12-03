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


import beans.*;
import connection.DBConnection;
import utils.DBUtils;

/**
 * Servlet implementation class NguoiDung
 */
@WebServlet("/NguoiDung")
public class NguoiDung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguoiDung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	List<ThongTinTK> list = null;
        	String err = "Đéo hiểu";
        	Connection conn;
			try {
				conn = DBConnection.getMyConnection();
				list = DBUtils.LayDSNguoiDung(conn);
				err = null;
			}
				catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				err = e.getMessage();
				
			}
			request.setAttribute("error", err);
			request.setAttribute("DShocsinh", list);
			 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/DSNguoiDung.jsp");
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

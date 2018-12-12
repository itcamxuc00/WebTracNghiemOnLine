package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.LayDeThiRs;
import connection.DBConnection;
import utils.DBUtils;
import utils.MyUtils;

/**
 * Servlet implementation class SuaDeThi
 */
@WebServlet("/SuaDeThi")
public class SuaDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maDe = request.getParameter("maDe");
		String monHoc = request.getParameter("monHoc");
		try {
			Connection conn = DBConnection.getMyConnection();
			java.util.List<LayDeThiRs> list = DBUtils.LayDeThi(conn, maDe);
			request.setAttribute("dsCauHoi",list );
			request.setAttribute("monHoc", monHoc);
			HttpSession session = request.getSession();
			MyUtils.setDeThi(session, maDe);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/SuaDeThi.jsp");
			dispatcher.forward(request, response);
		}
		catch( Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String status="";
		 try {
			 String arr =  request.getParameter("arr");	
			 HttpSession session = request.getSession();
			 String maDeThi = MyUtils.getDeThi(session);
			 ArrayList<String> listdata = null;
			 Gson gsonn = new Gson();
			 java.sql.Connection conn = DBConnection.getMyConnection();
			 listdata = gsonn.fromJson(arr, ArrayList.class);
			 DBUtils.XoaNDDeThi(conn, maDeThi);
			 for(int i=0;i<listdata.size();i++)
			 {
				 DBUtils.LuuNDDeThi(conn, maDeThi, listdata.get(i));
			 }
			 status = "ok";
		 }
		 catch(Exception e) {
			 status = e.getMessage();
		 }
		 response.getWriter().write(status);
	}

}

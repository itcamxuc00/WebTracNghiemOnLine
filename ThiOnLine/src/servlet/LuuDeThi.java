package servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import connection.DBConnection;
import utils.DBUtils;
import utils.MyUtils;

/**
 * Servlet implementation class LuuDeThi
 */
@WebServlet("/LuuDeThi")
public class LuuDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LuuDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String arr =  request.getParameter("arr");
		 String status="";
		 HttpSession session = request.getSession();
		 try {
			 ArrayList<String> listdata = null;
			 Gson gsonn = new Gson();
			 java.sql.Connection conn = DBConnection.getMyConnection();
			 listdata = gsonn.fromJson(arr, ArrayList.class);
			 String maDe = MyUtils.getDeThi(session).getMaDeThi();
			 System.out.print(maDe);
			 for(int i=0;i<listdata.size();i++)
			 {
				 DBUtils.LuuNDDeThi(conn, maDe, listdata.get(i));
			 }
			 status = "ok";
		 }
		 catch(Exception e) {
			 status = e.getMessage();
		 }
		 response.getWriter().write(status);
	}

}

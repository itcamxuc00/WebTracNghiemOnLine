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



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class LopHocThamGia
 */
@SuppressWarnings("unused")
@WebServlet("/LopHocThamGia")
public class LopHocThamGia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LopHocThamGia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<LopHoc> list = null;
		String responsejson = null;
		String err = null;
		try
		{
			Connection conn = DBConnection.getMyConnection();
			String tentk = request.getParameter("TenTK");
			list = DBUtils.LayDSLopHoc(conn, tentk);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			responsejson = new Gson().toJson(list);
			response.getWriter().write(responsejson);
		}
		catch(Exception e)
		{
			err = e.getMessage();
			responsejson= err;
			response.getWriter().write(responsejson);
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

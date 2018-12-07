package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.BG_DeThi;
import connection.DBConnection;
import utils.DBUtils;

/**
 * Servlet implementation class GiaoDeThi
 */
@WebServlet("/GiaoDeThi")
public class GiaoDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiaoDeThi() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jsonString = request.getParameter("querry");
		String batDau = request.getParameter("batDau");
		String ketThuc= request.getParameter("ketThuc");
		BG_DeThi bg = new BG_DeThi();
		String status ="";
		try {
			Gson gson = new Gson();
			 bg= gson.fromJson(jsonString, BG_DeThi.class);
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			java.util.Date tmp1 = dateFormat.parse(batDau);
			java.util.Date tmp2 = dateFormat.parse(ketThuc);
			Timestamp bd = new Timestamp(tmp1.getTime());
			Timestamp kt = new Timestamp(tmp2.getTime());
			bg.setTGBatDau(bd);
			bg.setTGKetThuc(kt);
			Connection conn = DBConnection.getMyConnection();
			DBUtils.GiaoDeThi(conn, bg);
			status = "ok";
		}
		catch(Exception e)
		{
			status = e.getMessage();
			System.out.println(status);
		}
		response.getWriter().write(status);
	}

}

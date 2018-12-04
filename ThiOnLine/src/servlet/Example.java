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

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import beans.LayDeThiRs;
import beans.ThongTinTK;
import connection.DBConnection;
import utils.DBUtils;
import utils.MathFunction;

/**
 * Servlet implementation class Example
 */
@WebServlet("/Example")
public class Example extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<LayDeThiRs> list = null;
    	String err = "Đéo hiểu";
    	Connection conn;
		try {
			conn = DBConnection.getMyConnection();
			list = DBUtils.LayDeThi(conn, "DT1");
			err = "da vao day";
		}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			err = e.getMessage();
			
		}
		request.setAttribute("error", err);
		request.setAttribute("DSCauHoi", list);
		 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/User/BaiThi.jsp");
		 dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String err = "Đéo hiểu";
    	Connection conn;
    	float Diem = 0;
		try {
			conn = DBConnection.getMyConnection();
			String baiThi= request.getParameter("baiThi");
			String dapAn= DBUtils.LayDapAn(conn, "DT1");
			Diem = MathFunction.ChamDiem(baiThi, dapAn);
			err = null;
		}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			err = e.getMessage();		
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/User/KetQuaThi.jsp");
			 dispatcher.forward(request, response);
		}
		request.setAttribute("error", err);
		request.setAttribute("Diem", Diem);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/User/KetQuaThi.jsp");
		 dispatcher.forward(request, response);
	}
}

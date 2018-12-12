package servlet;

import java.io.IOException;
import java.sql.Connection;

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
 * Servlet implementation class ThemDeThi
 */
@WebServlet("/ThemDeThi")
public class ThemDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String err=null;
		java.util.List<LayDeThiRs> list = null;
		try {
			String maMonHoc = request.getParameter("monHoc");
			int soCauDe = Integer.parseInt(request.getParameter("soCauDe"));
			int soCauTrungBinh = Integer.parseInt(request.getParameter("soCauTrungBinh"));
			int soCauKho = Integer.parseInt(request.getParameter("soCauKho"));
			Connection conn = DBConnection.getMyConnection();
			list = DBUtils.TaoDeThi(conn, maMonHoc, soCauDe, soCauTrungBinh, soCauKho);
			request.setAttribute("dsCauHoi", list);
		}
		catch(Exception e)
		{
			err = e.getMessage();
			System.out.print(err);
		}
		 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/XemTruoc.jsp");
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

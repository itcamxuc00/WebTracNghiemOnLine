package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import beans.*;
import connection.DBConnection;
import utils.DBUtils;
import utils.MyUtils;

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
		// TODO Auto-generated method stub
		String maDeThi = request.getParameter("maDeThi");
		String err=null;
		if(maDeThi==null||maDeThi=="")
		{
			try {
				Connection conn = DBConnection.getMyConnection();
				request.setAttribute("DSLopHoc", DBUtils.LayMonHoc(conn));
			}
			catch (Exception e) {
				// TODO: handle exception
				err = e.getMessage();
				System.out.println(err);
				request.setAttribute("Error", err);			
			}
			 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/ThemDeThi.jsp");
			 dispatcher.forward(request, response);
		}
		else
		{			
			String maMonHoc = request.getParameter("monHoc");
			java.util.List<LayDeThiRs> list = null;
			int soCauDe = Integer.parseInt(request.getParameter("soCauDe"));
			int soCauTrungBinh = Integer.parseInt(request.getParameter("soCauTrungBinh"));
			int soCauKho = Integer.parseInt(request.getParameter("soCauKho"));
			DeThi dt = new DeThi();
			dt.setMaDeThi(maDeThi);
			dt.setMaMonHoc(maMonHoc);
			dt.setSoCauDe(soCauDe);
			dt.setSoCauTrungBinh(soCauTrungBinh);
			dt.setSoCauKho(soCauKho);
			try {
				Connection conn = DBConnection.getMyConnection();
				list = DBUtils.TaoDeThi(conn, maMonHoc, soCauDe, soCauTrungBinh, soCauKho);
				request.setAttribute("dsCauHoi", list);
				HttpSession session = request.getSession();
				MyUtils.setDeThi(session, dt);
				DBUtils.LuuDeThi(conn, dt);
			}
			catch(Exception e)
			{
				err = e.getMessage();
				System.out.print(err);
			}
			 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/XemTruoc.jsp");
			 dispatcher.forward(request, response);
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

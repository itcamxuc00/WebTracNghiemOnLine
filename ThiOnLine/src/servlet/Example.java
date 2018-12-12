package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LayDeThiRs;
import beans.LuotThi;
import beans.TaiKhoan;
import connection.DBConnection;
import utils.DBUtils;
import utils.MathFunction;
import utils.MyUtils;

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
		HttpSession session = request.getSession();
		TaiKhoan daDangNhap = MyUtils.getTaiKhoanDangNhap(session);
		if(daDangNhap==null)
		{
			response.sendRedirect("Home");
		}
		else
		{
			String tenTK = daDangNhap.getTenTK();
			String maDe = request.getParameter("maDe");
			String maLop = request.getParameter("maLop");
	    	List<LayDeThiRs> list = null;
	    	LuotThi luotThi = null;
	    	String err=null;
			if(maDe==null||maLop==null||maDe==""||maLop=="") response.setStatus(404);
			else
			{
				try {
						Connection conn = DBConnection.getMyConnection();
						luotThi= DBUtils.KiemTraDuocPhepThi(conn, tenTK, maDe, maLop);
						if(luotThi==null) response.setStatus(404);
						else
						{
							MyUtils.setLuotThi(session, luotThi);
							list = DBUtils.LayDeThi(conn, maDe);
							request.setAttribute("luotThi",luotThi);
							request.setAttribute("DSCauHoi", list);
							RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/User/BaiThi.jsp");
							dispatcher.forward(request,response);
						}
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						err = e.getMessage();
						System.out.println(err);
						response.setStatus(404);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String err = "Đéo hiểu";
    	float Diem = 0;
    	long thoiGianLamBai=0;
    	HttpSession session = request.getSession();
    	LuotThi luotThi = MyUtils.getLuotThi(session);
		try {
			Connection conn = DBConnection.getMyConnection();
			Timestamp batDau = luotThi.getBatDau();
			Timestamp bayGio = new Timestamp(System.currentTimeMillis());
			thoiGianLamBai = (bayGio.getTime() - batDau.getTime())/1000;
			//Phát hiên gian lân
			if(thoiGianLamBai>luotThi.getThoiLuong()*60+5) Diem=-1;
			else
			{
				String baiThi= request.getParameter("baiThi");
				String dapAn= DBUtils.LayDapAn(conn, luotThi.getMaDe());
				Diem = MathFunction.ChamDiem(baiThi, dapAn);
				System.out.println(dapAn);
				err = null;
			}
		}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			err = e.getMessage();		
			System.out.println(err);
		}
		request.setAttribute("error", err);
		request.setAttribute("phut", thoiGianLamBai/60);
		request.setAttribute("giay", thoiGianLamBai%60);
		request.setAttribute("Diem", Diem);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/User/KetQuaThi.jsp");
		dispatcher.forward(request, response);
	}
}

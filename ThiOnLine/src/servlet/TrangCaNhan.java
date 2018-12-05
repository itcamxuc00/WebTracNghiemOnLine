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
import javax.servlet.http.HttpSession;

import beans.BG_DeThi;
import beans.TaiKhoan;
import beans.ThongTinTK;
import connection.DBConnection;
import utils.DBUtils;
import utils.MyUtils;

/**
 * Servlet implementation class TrangCaNhan
 */
@WebServlet("/TrangCaNhan")
public class TrangCaNhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangCaNhan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  // Kiểm tra người dùng đã đăng nhập (login) chưa.
		HttpSession session = request.getSession();
        TaiKhoan loginedUser = MyUtils.getLoginedUser(session);
        // Nếu chưa đăng nhập (login).
        if (loginedUser == null) {
            // Redirect (Chuyển hướng) tới trang login.
            response.sendRedirect(request.getContextPath() + "/Home");
            return;
        }
        ThongTinTK thongTinTK = null;
        List<BG_DeThi> dsDeThi = null;
        String err = null;
        try {
        	Connection conn = DBConnection.getMyConnection();
        	thongTinTK = DBUtils.LayThongTin(conn, loginedUser.getTenTK());
        	dsDeThi = DBUtils.LayDSDeThi(conn, loginedUser.getTenTK());
        	request.setAttribute("dsDethi", dsDeThi);
        	request.setAttribute("user", thongTinTK);
        }
        catch(Exception e) {
        	err = e.getMessage();
        }
        request.setAttribute("error", err);
        RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/WEB-INF/views/User/TrangCaNhan.jsp");
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
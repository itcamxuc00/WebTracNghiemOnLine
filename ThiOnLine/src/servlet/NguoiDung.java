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

import com.google.gson.Gson;

import beans.*;
import connection.DBConnection;
import utils.DBUtils;
import utils.MyUtils;

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
		HttpSession session = request.getSession();
        TaiKhoan loginedUser = MyUtils.getTaiKhoanDangNhap(session);
        // Nếu chưa đăng nhập (login).
        if (loginedUser == null) {
            // Redirect (Chuyển hướng) tới trang login.
            response.sendRedirect(request.getContextPath() + "/Home");
            return;
        }
        else if(loginedUser.getQuyen()<=1) response.setStatus(404); 
        else {
            	List<ThongTinTK> list = null;
            	String err = "";
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
    			 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin/DSNguoiDung.jsp");
    			 dispatcher.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String json = request.getParameter("hocSinh");
		String status="";
		try {
			ThongTinTK tk = new ThongTinTK();
			Gson gson = new Gson();
			Connection conn = DBConnection.getMyConnection();
			tk = gson.fromJson(json, ThongTinTK.class);
			DBUtils.ThemHocSinh(conn, tk);
			status="ok";
		}
		catch(Exception e) {
			status = e.getMessage();
		}
		response.getWriter().write(status);
	}

}

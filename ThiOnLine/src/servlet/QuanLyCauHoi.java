package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.dsCauHoi;
import utils.CAUHOI_DAO;

/**
 * Servlet implementation class QuanLyCauHoi
 */
@WebServlet("/QuanLyCauHoi")
public class QuanLyCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyCauHoi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		HttpSession ss= request.getSession();
		String s= (String)ss.getAttribute("usernameaa");
		if(s!=null) {
	        RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/Login.jsp");  
	        rd.forward(request,response); 
		}
		else {
			int page=1;
			String p = request.getParameter("page");
			CAUHOI_DAO ch = null;
			dsCauHoi ds= new dsCauHoi();
			int soTrang = 0;
			try {
				if(p!=null) page = Integer.parseInt(p);
				ch = new CAUHOI_DAO(); 
				ds.setDs(ch.xemDSCauHoi(page));
				soTrang = ch.tinhTongSoTrang();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			request.setAttribute("dsCH",ds );
			request.setAttribute("trang",page );
			request.setAttribute("soTrang",soTrang);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/Admin/QuanLyCauHoi.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class Login
 * @author 篠田
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//エンコ
				request.setCharacterEncoding("UTF-8");
				
				UserBean userBean = new UserBean();
				
				//パラ取得
				userBean.setUserId(request.getParameter("userId"));
				userBean.setPassword(request.getParameter("password"));
					
				try {
					//DAO生成
					UserDAO userDao = new UserDAO();
					
						if (userDao.loginCheck(userBean)) {
							//メニューへ遷移
							RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
							rd.forward(request, response);
							
						} else {
							//エラーメッセージの設定
							String errorMessage = "*入力情報に誤りがあります。";
							request.setAttribute("errorMessage", errorMessage);
							
							//エラーメッセージをログイン画面へ転送
							RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
							rd.forward(request, response);
						}
				}catch (Exception e){
					e.getStackTrace();
				}
	}

}

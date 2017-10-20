package it.dstech.controller.user;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.dstech.models.User;
import it.dstech.services.UserService;
import it.dstech.services.UserServiceImpl;

@WebServlet("/user/login")
public class Login extends HttpServlet{
	private UserService userService= new UserServiceImpl();
	private static final Logger logger = Logger.getLogger(Login.class.getName());
	private User utente;

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("../index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username= req.getParameter("username");
		logger.info("from jsp Username: " + username);
		String password = req.getParameter("password");
		logger.info("from jsp Password: " + password);
		utente = userService.login(username, password);
		logger.info("utente " + utente);
		if(utente!=null) {
		HttpSession session = req.getSession();
		session.setAttribute("sessionUtente", utente);
		resp.sendRedirect("../contact/listacontatti");
	    }else {
	    	resp.sendRedirect("login");
	    }
}
}

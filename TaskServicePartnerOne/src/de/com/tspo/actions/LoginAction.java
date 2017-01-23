package de.com.tspo.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.com.tspo.dao.DaoConnection;
import de.com.tspo.digest.Sha1Digest;

@WebServlet("/tspoLogin")
public class LoginAction extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String nmUser = req.getParameter("nmUser");
		String password = req.getParameter("password");
		try {
			password = new Sha1Digest().SHA1(password);
		} catch (NoSuchAlgorithmException en) {
			password = "";
		}
		
		DaoConnection dao = new DaoConnection();
		Query query = dao.getManager().createQuery(
				"from User as u "
						+ "where UPPER(u.nmUser) = upper(:nmUser) "
						+ "and upper(u.password) = upper(:password)");
		query.setParameter("nmUser", nmUser);
		query.setParameter("password", password);
		
		if	(!query.getResultList().isEmpty()){
			PrintWriter out = resp.getWriter();
			out.print("OK");
		}
		
	}

}

package utilisateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.naming.NamingException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import utilisateur.UtilisateurDBHandler;
import utilisateur.Utilisateur;
import utilisateur.IUtilisateurDB;


public class LogoutServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {



      HttpSession session = req.getSession();
      session.invalidate();

      RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
      rd.forward(req,resp);

}

}

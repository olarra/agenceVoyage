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


public class LoginServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

           String  user = req.getParameter("user");
           String  pass = req.getParameter("pass");
           this.log("user : " + user  +  "pass :"+ pass);
           try{

             Utilisateur utilisateurLogged = UtilisateurDBHandler.getDb().retrieve(user);
             this.log("user object : " + utilisateurLogged);
             // HTML Header
             //req.setAttribute("utilisateurLogged",utilisateurLogged);

             HttpSession session = req.getSession();
             session.setAttribute("UserNameSession", utilisateurLogged);

             RequestDispatcher rd = req.getRequestDispatcher("/addHebergement");
             rd.forward(req,resp);
           }
           catch (NamingException | SQLException ex ) {
             RequestDispatcher rd=req.getRequestDispatcher("/pages/errorPage.jsp");
             this.log(ex.getMessage());
             ex.printStackTrace();
             rd.forward(req,resp);
           }
}
}

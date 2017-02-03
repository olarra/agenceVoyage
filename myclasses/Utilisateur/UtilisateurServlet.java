package utilisateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.naming.NamingException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import utilisateur.UtilisateurDBHandler;
import utilisateur.Utilisateur;
import utilisateur.IUtilisateurDB;


public class UtilisateurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

        log("Une exécution de la servlet...");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=null;
        try {
            out=resp.getWriter();
        } catch (IOException e) {
            out.close();
            throw e;
        }

            try{
              List<Utilisateur> utilisateur = UtilisateurDBHandler.getDb().retrieveAll();
              log("liste d'utilisateur: " + utilisateur);
              // HTML Header
              req.setAttribute("utilisateur",utilisateur);
              RequestDispatcher rd = req.getRequestDispatcher("/pages/allUtilisateurs.jsp");
              rd.forward(req,resp);
            }
            catch (NamingException | SQLException ex ) {
              RequestDispatcher rd=req.getRequestDispatcher("/pages/errorPage.jsp");
                rd.forward(req,resp);
            }
    }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

           String  user = req.getParameter("user");
           String  pass = req.getParameter("pass");
           String  mail = req.getParameter("mail");

          try{
            Utilisateur us = new Utilisateur(0,user,pass,mail);
            IUtilisateurDB db = UtilisateurDBHandler.getDb();
            db.addUtilisateur(us);
            resp.sendRedirect(this.getServletContext().getContextPath() + "/utilisateurs");
          }
          catch (Exception  ex ) {
            this.log(ex.getMessage());
            ex.printStackTrace();
            RequestDispatcher rd=req.getRequestDispatcher("/pages/errorPage.jsp");
            rd.forward(req, resp);
          }
        }


}

package hebergement;

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
import hebergement.HebergementDBHandler;
import hebergement.Hebergement;
import hebergement.IHebergementDB;
import association.AssociationDBHandler;
import utilisateur.Utilisateur;


public class HebergementServlet extends HttpServlet {

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
              List<Hebergement> hebergements = HebergementDBHandler.getDb().retrieveAll();
              log("liste d'hebergement: " + hebergements);
              // HTML Header
              req.setAttribute("hebergements",hebergements);
              RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
              rd.forward(req,resp);
            }
            catch (NamingException | SQLException ex ) {
              RequestDispatcher rd=req.getRequestDispatcher("/pages/errorPage.jsp");
            }
    }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

           String  type = req.getParameter("type");
           String  pays = req.getParameter("pays");
           String  surface = req.getParameter("surface");
           String  npieces = req.getParameter("npieces");
           String  addresse= req.getParameter("addresse");
           String  terrain_exterieur = req.getParameter("terrain_exterieur");
           String  description = req.getParameter("description");
           String  image= req.getParameter("image");


          try{
            Hebergement hb = new Hebergement(0,type,pays,surface,npieces,addresse,terrain_exterieur,description,image);
            IHebergementDB db = HebergementDBHandler.getDb();

            int id = db.addHebergement(hb);
            int idUser =((Utilisateur)req.getSession().getAttribute("UserNameSession")).getIdUtilisateur();
            //Creer une association
            AssociationDBHandler.getDb().createAssociation(idUser,id);

            resp.sendRedirect(this.getServletContext().getContextPath() + "/home");
          }
          catch (Exception  ex ) {
            this.log(ex.getMessage());
            ex.printStackTrace();
            RequestDispatcher rd=req.getRequestDispatcher("/pages/errorPage.jsp");
            rd.forward(req, resp);
          }
        }


}

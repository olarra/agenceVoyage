package association;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.naming.NamingException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import hebergement.HebergementDBHandler;
import hebergement.Hebergement;
import hebergement.IHebergementDB;
import association.AssociationDBHandler;
import utilisateur.Utilisateur;
import java.util.ArrayList;

public class AssociationServlet extends HttpServlet {

    private List<Hebergement> hebergements = new ArrayList<Hebergement>();
    private List<Association> allAssociations = new ArrayList<Association>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {



          if(req.getParameter("hbToDelete") == null)
          {
            this.log("no parameter received");

          }
          else{
             int hbToDelete = Integer.valueOf(req.getParameter("hbToDelete"));
             try{
                HebergementDBHandler.getDb().deleteHebergement(hbToDelete);
                HebergementDBHandler.getDb().deleteAssociation(hbToDelete);
                allAssociations = AssociationDBHandler.getDb().loadAssociations();
                
             }
             catch (NamingException | SQLException ex ){
               RequestDispatcher rd=req.getRequestDispatcher("/pages/errorPage.jsp");
             }
          }
            this.log("**************************************************************************");

              allAssociations  = AssociationDBHandler.getDb().loadAssociations();
              this.log("DB Associations taille :  " + allAssociations.size());
              this.log("DB Associations contenu :  " + allAssociations);

              if(req.getSession().getAttribute("UserNameSession") == null) {

                this.log("NO SESSION");

              } else{
                  this.log("hebergements before clear :" + hebergements);
                hebergements.clear();
                this.log("hebergements after clear :" + hebergements);

                int idUser =((Utilisateur)req.getSession().getAttribute("UserNameSession")).getIdUtilisateur();

                  for (Association item : allAssociations) {
                    if(idUser == item.getIdUtilisateur())
                    {
                      ///-----
                      try{

                        Hebergement hebergement = HebergementDBHandler.getDb().retrieve(item.getIdHebergement());
                        this.log("hebergements before :  " + hebergements.size());
                        hebergements.add(hebergement);
                        this.log("hebergements after :  " + hebergements.size());

                        this.log("Hebergements arrayList contenu: " + hebergements);
                        this.log(item.getIdAssociation() + " " + item.getIdUtilisateur() + " " + item.getIdHebergement());
                      }
                      catch (NamingException | SQLException ex ) {
                        RequestDispatcher rd=req.getRequestDispatcher("/pages/errorPage.jsp");
                      }
                      //-----


                    }

                  }
                      this.log("TALLA DE array hebergements: " + hebergements.size());
                      req.setAttribute("hebergements",hebergements);
              }


              //ajout de session
            //resp.sendRedirect(this.getServletContext().getContextPath() + "pages/showLinks.jsp");
              RequestDispatcher rd = req.getRequestDispatcher("/pages/showLinks.jsp");
              rd.forward(req,resp);

    }




}

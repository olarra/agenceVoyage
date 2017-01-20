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


public class HebergementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        this.log("Une exécution de la servlet...");
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
          this.log("liste d'hebergement: " + hebergements);
          // HTML Header
          req.setAttribute("hebergements",hebergements);
          RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
          rd.forward(req,resp);
        }
        catch (NamingException | SQLException ex ) {
          RequestDispatcher rd=req.getRequestDispatcher("/pages/errorPage.jsp");
        }



    }

}

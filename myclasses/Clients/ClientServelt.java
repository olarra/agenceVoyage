package agence;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<c:set var="db" value="<%= new ClientDBStub() %>" />
<c:forEach var="client" items="${db.getAll()}">

public class ClientServlet extends HttpServlet {

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


        ClientDBStub db = new ClientDBStub();
        List<Client> clients = db.getAll();
        // HTML Header
        req.setAttribute("clients",clients);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("allClients.jsp");
        dispatcher.forward(req,resp);


    }

}

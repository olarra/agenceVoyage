package utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilisateur.Utilisateur;
import utilisateur.IUtilisateurDB;

/**
 * A class for SQL storage of products in a database. The name of the product
 * is taken to be its primary key.
 * @author Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France.
 * @since January, 2013
 */
public class SQLUtilisateurDB implements IUtilisateurDB {

    /** The name for the SQL table where to store products. */
    protected String table;

    /** A prepared statement for creations. */
    private PreparedStatement createUtilisateurStatement;

    /** A prepared statement for retrieval of one product. */
    private PreparedStatement retrieveUtilisateurStatement;

    /** A link to the database. */
    protected Connection link;

    /**
     * Builds a new instance.
     * @param link An active connection to an SQL database
     * @param table The name of the table where to store products
     * @throws SQLException if a database access error occurs
     */
    public SQLUtilisateurDB (Connection link, String table) throws SQLException {
        this.link=link;
        this.table=table;
        String query=null;
        query="INSERT INTO `"+this.table+"` VALUES(?,?,?,?)";
        this.createUtilisateurStatement=this.link.prepareStatement(query);
        query="SELECT * FROM `"+this.table+"` WHERE user=?";
        this.retrieveUtilisateurStatement=this.link.prepareStatement(query);
    }

    @Override
    public void addUtilisateur (Utilisateur utilisateur) throws SQLException {
        this.create(utilisateur);
    }

    @Override
    public List<Utilisateur> getAll () throws SQLException {
        return this.retrieveAll();
    }

    // Methods

    /**
     * Resets the link to the database.
     * This method can be used in case the connection breaks down.
     * @param link An active link to the database
     */
    public void setLink (Connection link) {
        this.link=link;
    }

    /**
     * Creates the necessary table in the database. Nothing occurs if the table already exists.
     * @throws SQLException if a database access error occurs
     */
    public void createTables () throws SQLException {
        String query="CREATE TABLE IF NOT EXISTS `"+ this.table + "` (";
        query+="`idUtilisateur` int NOT NULL AUTO_INCREMENT,";
        query+="`user` varchar(70),";
        query+="`pass` varchar(70),";
        query+="`mail` varchar(70),";
        query+="PRIMARY KEY (`idUtilisateur`) ";
        query+=")";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }

    /**
     * Stores a new product in the database.
     * @param product The product to store
     * @throws SQLException if a database access error occurs
     */
    public void create (Utilisateur utilisateur) throws SQLException {
      this.createUtilisateurStatement.setInt(1,utilisateur.getIdUtilisateur());
      this.createUtilisateurStatement.setString(2,utilisateur.getUser());
      this.createUtilisateurStatement.setString(3,utilisateur.getPass());
      this.createUtilisateurStatement.setString(4,utilisateur.getMail());
      this.createUtilisateurStatement.execute();
    }
    /**
     * Retrieves all the products in the database.
     * @return A list of all products in the database
     * @throws SQLException if a database access error occurs
     */
    public List<Utilisateur> retrieveAll () throws SQLException {
        String query="SELECT * FROM `"+ this.table+"`";
        ResultSet rs=null;
        Statement statement=this.link.createStatement();
        rs=statement.executeQuery(query);
        List<Utilisateur> res=new ArrayList<Utilisateur>();
        while (rs.next()) {
            res.add(new Utilisateur(rs.getInt("idUtilisateur"),rs.getString("user"),rs.getString("pass"),rs.getString("mail")));
        }
        return res;
    }


    /**
     * Retrieves a product in the database.
     * @param name The name of the product
     * @return A product, or null if none with the given name exists in the database
     * @throws SQLException if a database access error occurs
*/
    public Utilisateur retrieve (String name) throws SQLException {
        this.retrieveUtilisateurStatement.setString(1,name);
        ResultSet rs=this.retrieveUtilisateurStatement.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return new Utilisateur(rs.getInt("idUtilisateur"),rs.getString("user"),rs.getString("pass"),rs.getString("mail"));
    }

    /**
     * Drops the table from the database. Nothing occurs if the table does not exist.
     * @throws SQLException if a database access error occurs
     */
    public void deleteTables () throws SQLException {
        String query="DROP TABLE IF EXISTS `"+this.table+"`";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }

    /**
     * Deletes a product. Nothing occurs in case the product does not exist in the database.
     * @param product The product
     * @throws SQLException if a database access error occurs

    public void delete (Product product) throws SQLException {
        String query="DELETE FROM `"+this.table+"` WHERE name=\""+product.getName()+"\"";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }*/

}

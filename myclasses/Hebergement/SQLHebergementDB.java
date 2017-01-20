package hebergement;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import hebergement.Hebergement;
import hebergement.IHebergementDB;

/**
 * A class for SQL storage of products in a database. The name of the product
 * is taken to be its primary key.
 * @author Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France.
 * @since January, 2013
 */
public class SQLHebergementDB implements IHebergementDB {

    /** The name for the SQL table where to store products. */
    protected String table;

    /** A prepared statement for creations. */
    private PreparedStatement createHebergementStatement;

    /** A prepared statement for retrieval of one product. */
    private PreparedStatement retrieveHebergementStatement;

    /** A link to the database. */
    protected Connection link;

    /**
     * Builds a new instance.
     * @param link An active connection to an SQL database
     * @param table The name of the table where to store products
     * @throws SQLException if a database access error occurs
     */
    public SQLHebergementDB (Connection link, String table) throws SQLException {
        this.link=link;
        this.table=table;
        String query=null;
        query="INSERT INTO `"+this.table+"` VALUES(?,?,?,?,?,?,?,?,?)";
        this.createHebergementStatement=this.link.prepareStatement(query);
        query="SELECT * FROM `"+this.table+"` WHERE name=?";
        this.retrieveHebergementStatement=this.link.prepareStatement(query);
    }

    @Override
    public void addHebergement (Hebergement hebergement) throws SQLException {
        this.create(hebergement);
    }

    @Override
    public List<Hebergement> getAll () throws SQLException {
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
        query+="`idHebergement` int NOT NULL AUTO_INCREMENT,";
        query+="`type` varchar(70),";
        query+="`pays` varchar(70),";
        query+="`surface` varchar(70),";
        query+="`npieces` varchar(70),";
        query+="`addresse` varchar(70),";
        query+="`terrain_exterieur` varchar(70),";
        query+="`description` varchar(500),";
        query+="`image` varchar(150),";
        query+="PRIMARY KEY (`idHebergement`) ";
        query+=")";
        Statement statement=this.link.createStatement();
        statement.execute(query);
    }

    /**
     * Stores a new product in the database.
     * @param product The product to store
     * @throws SQLException if a database access error occurs
     */
    public void create (Hebergement hebergement) throws SQLException {
      this.createHebergementStatement.setInt(1,hebergement.getIdHebergement());
      this.createHebergementStatement.setString(2,hebergement.getType());
      this.createHebergementStatement.setString(3,hebergement.getPays());
      this.createHebergementStatement.setString(4,hebergement.getSurface());
      this.createHebergementStatement.setString(5,hebergement.getNpieces());
      this.createHebergementStatement.setString(6,hebergement.getAddresse());
      this.createHebergementStatement.setString(7,hebergement.getTerrain_exterieur());
      this.createHebergementStatement.setString(8,hebergement.getDescription());
      this.createHebergementStatement.setString(9,hebergement.getImage());
      this.createHebergementStatement.execute();
    }
    /**
     * Retrieves all the products in the database.
     * @return A list of all products in the database
     * @throws SQLException if a database access error occurs
     */
    public List<Hebergement> retrieveAll () throws SQLException {
        String query="SELECT * FROM `"+ this.table+"`";
        ResultSet rs=null;
        Statement statement=this.link.createStatement();
        rs=statement.executeQuery(query);
        List<Hebergement> res=new ArrayList<Hebergement>();
        while (rs.next()) {
            res.add(new Hebergement(rs.getInt("idHebergement"),rs.getString("type"),rs.getString("pays"),rs.getString("surface"),rs.getString("npieces"),rs.getString("addresse"),rs.getString("terrain_exterieur"),rs.getString("description"),rs.getString("image")));
        }
        return res;
    }

    /**
     * Retrieves a product in the database.
     * @param name The name of the product
     * @return A product, or null if none with the given name exists in the database
     * @throws SQLException if a database access error occurs

    public Service retrieve (String name) throws SQLException {
        this.retrieveProductStatement.setString(1,name);
        ResultSet rs=this.retrieveProductStatement.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return new Product(rs.getString("name"),rs.getFloat("pricePerKg"),rs.getFloat("weight"));
    }
*/
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

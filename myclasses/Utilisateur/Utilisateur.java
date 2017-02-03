package utilisateur;

/**
 * A class for representing a product. A product consists of a name, a price per kg, and a
 * weight (in kgs, meant to be the available amount of this product).
 * @author Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France.
 * @since January, 2013
 */
public class Utilisateur {
  protected int  idUtilisateur;
  protected String  user;
  protected String  pass;
  protected String  mail;

    public Utilisateur () {
        this(0,"","","");
    }

    public Utilisateur (int idUtilisateur,String user, String pass, String mail) {
        this.idUtilisateur=idUtilisateur;
        this.user=user;
        this.pass=pass;
        this.mail=mail;
    }


    public Utilisateur (Utilisateur us) {
        this(us.getIdUtilisateur(), us.getUser(),us.getPass(),us.getMail());
    }


    public int getIdUtilisateur() {
      return idUtilisateur;
    }


    public void setUser(String user) {
        this.user=user;
    }

    public String getUser () {
        return this.user;
    }

    public void setPass(String pass) {
        this.pass=pass;
    }

    public String getPass () {
        return this.pass;
    }

    public void setMail(String mail) {
        this.mail=mail;
    }

    public String getMail () {
        return this.mail;
    }


    @Override
    public String toString () {
        return ("Votre nom d'utilisateur es : " + this.user + " et ton mot de passe est : " + this.pass);
    }

}

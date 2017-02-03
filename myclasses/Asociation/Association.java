package association;

import java.util.List;
import java.util.ArrayList;

public class Association {

    private Integer idAssociation;
    private Integer idUtilisateur;
    private Integer idHebergement;

    /**
    ** Constructor
    **/

    public Association () {

    }

    public Association (int idUtilisateur, int idHebergement) {

        this.idUtilisateur = idUtilisateur;
        this.idHebergement = idHebergement;
    }

    /**
    ** Setters and getters
    **/

    public Integer getIdAssociation() {
        return this.idAssociation;
    }

    public void setIdAssociation (int idAssociation) {
        this.idAssociation=idAssociation;
    }

    public int getIdUtilisateur() {
        return this.idUtilisateur;
    }

    public void setIdUtilisateur (int idUtilisateur) {
        this.idUtilisateur=idUtilisateur;
    }

    public int getIdHebergement() {
        return this.idHebergement;
    }

    public void setIdHebergement (int idHebergement) {
        this.idHebergement=idHebergement;
    }



}

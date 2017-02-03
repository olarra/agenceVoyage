package utilisateur;

import java.util.List;

public interface IUtilisateurDB {

    public void addUtilisateur(Utilisateur utilisateur) throws Exception;

    public List<Utilisateur> getAll () throws Exception;

}

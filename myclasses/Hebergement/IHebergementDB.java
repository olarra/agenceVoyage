package hebergement;

import java.util.List;

public interface IHebergementDB {

    public void addHebergement(Hebergement hebergement) throws Exception;

    public List<Hebergement> getAll () throws Exception;

}

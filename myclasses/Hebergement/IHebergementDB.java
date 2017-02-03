package hebergement;

import java.util.List;

public interface IHebergementDB {

    public int addHebergement(Hebergement hebergement) throws Exception;

    public List<Hebergement> getAll () throws Exception;

}

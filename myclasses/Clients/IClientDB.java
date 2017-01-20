package agence;

import java.util.List;

public interface IClientDB {

    public void addClient(Client client) throws Exception;

    public List<Client> getAll () throws Exception;

}

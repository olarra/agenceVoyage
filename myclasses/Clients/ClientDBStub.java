package agence;

import java.util.List;
import java.util.ArrayList;

public class ClientDBStub implements IClientDB {

    /** The internal representation of the database. */
    protected static final List<Client> CLIENTS = new ArrayList<Client> ();

    /** The index of a specific, funny product in the list. */
    private static final int INDEX=2;

    static {
        ClientDBStub.CLIENTS.add(new Client("Jesus","1989","jgo@gmail.com"));
        ClientDBStub.CLIENTS.add(new Client("Gabriel","1990","ggo@gmail.com"));
        ClientDBStub.CLIENTS.add(new Client("Viridiana","1988","vgo@gmail.com"));
    }

    @Override
    public void addClient (Client c) throws UnsupportedOperationException {
        ClientDBStub.CLIENTS.add(c);
    }

    @Override
    public List<Client> getAll () {
        return ClientDBStub.CLIENTS;
    }

    public static Client getClientTest () {
        return ClientDBStub.CLIENTS.get(ClientDBStub.INDEX);
    }

    public static Client searchClient () {
        return ClientDBStub.CLIENTS.get(ClientDBStub.INDEX);
    }

}


package benzaiten.Servicios;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aetox
 */
public class Servidor {
    private int port = 5555;
    private RecopiladorServer server = new RecopiladorServer(port);
    public Servidor(){
        server.start();
    }
}


package tcpclient;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TCPClient {
    public static void main(String[] args) {
    	
    	int PORT = 7000;
    	String IP = "10.2.1.179";
    	int LocalPORT = 8000;
        
        BufferedReader EntradaTeclat = new BufferedReader(new InputStreamReader(System.in));
        
        DataOutputStream SortidaAlServidor = null;
        BufferedReader EntradaDesdeServidor = null;
        
        String frase; 
        String benbingudaServer;
        String fraseModificada;
        
        Socket clientSocket;
        try {
            clientSocket = new Socket(IP, PORT, null , LocalPORT);
            //clientSocket = new Socket("10.2.1.179", PORT, InetAddress.getByName("localhost"),7001);
            SortidaAlServidor = new DataOutputStream(clientSocket.getOutputStream());
            EntradaDesdeServidor = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            benbingudaServer = EntradaDesdeServidor.readLine();
            System.out.println(benbingudaServer);

            System.out.println("Donam una frase");
            frase = EntradaTeclat.readLine();

            SortidaAlServidor.writeBytes(frase + "\n");

            fraseModificada = EntradaDesdeServidor.readLine();

            System.out.println("FROM SERVER " + fraseModificada);

            clientSocket.close();
            System.out.println("Connexio tancada");
        
        
        } catch (IOException ex) {
            //Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No es pot establir connexió");
        }
        
        
        
    }
    
}

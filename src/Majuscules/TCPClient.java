package Majuscules;

import java.io.*;
import java.net.*;


public class TCPClient {
    public static void main(String[] args) throws IOException {
        
        BufferedReader EntradaTeclat = new BufferedReader(new InputStreamReader(System.in));
        
        DataOutputStream SortidaAlServidor = null;
        BufferedReader EntradaDesdeServidor = null;
        
        String frase;
        String fraseModificada;
        
        Socket clientSocket;
        clientSocket = new Socket("127.0.0.1", 6789);
        
        SortidaAlServidor = new DataOutputStream(clientSocket.getOutputStream());
        EntradaDesdeServidor = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        
        frase = EntradaTeclat.readLine();
        
        SortidaAlServidor.writeBytes(frase + "\n");
        
        fraseModificada = EntradaDesdeServidor.readLine();
        
        System.out.println("FROM SERVER " + fraseModificada);
        
        clientSocket.close();
        
    }
    
}
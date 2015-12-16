package Majuscules;

import java.io.*;
import java.net.*;


public class Client {
    public static void main(String[] args) throws IOException {
    	
    	int PORT = 7000;
        
        BufferedReader EntradaTeclat = new BufferedReader(new InputStreamReader(System.in));
        
        DataOutputStream SortidaAlServidor = null;
        BufferedReader EntradaDesdeServidor = null;
        
        String frase;
        String fraseModificada;
        
        Socket clientSocket;
        clientSocket = new Socket("127.0.0.1", PORT);
        
        SortidaAlServidor = new DataOutputStream(clientSocket.getOutputStream());
        EntradaDesdeServidor = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        
        frase = EntradaTeclat.readLine();
        
        SortidaAlServidor.writeBytes(frase + "\n");
        
        fraseModificada = EntradaDesdeServidor.readLine();
        
        System.out.println("FROM SERVER " + fraseModificada);
        
        clientSocket.close();
        
    }
    
}
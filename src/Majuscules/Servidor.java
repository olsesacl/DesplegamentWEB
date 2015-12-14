package Majuscules;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		int PORT = 7000;
		
		String FraseClient;
		String FraseMajuscules;
		ServerSocket SocketAcollida = new ServerSocket(PORT);
		
		DataOutputStream SortidaClient = null;
        BufferedReader EntradaDesdeClient = null;
        
        
		
		while(true){
			Socket SocketConnexio = SocketAcollida.accept();
			System.out.println("Conexió acceptada" + SocketConnexio.toString());
			
			SortidaClient = new DataOutputStream(SocketConnexio.getOutputStream());
			EntradaDesdeClient = new BufferedReader(new InputStreamReader(SocketConnexio.getInputStream()));
			
		
			
		}
	}

}

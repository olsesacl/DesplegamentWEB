package Majuscules;

import java.io.*;
import java.net.*;

public class Servidor {
	public static void main(String[] args) throws IOException {
		final int PORT = 7000;
		
		String FraseClient;
		String FraseMajuscules;
		ServerSocket SocketAcollida = new ServerSocket(PORT);
		
		DataOutputStream SortidaClient = null;
        BufferedReader EntradaDesdeClient = null;
        
        Boolean continuar = true;
        
		while(continuar){
			System.out.println("Esperant conexio...");
			Socket SocketConnexio = SocketAcollida.accept();// Servidor esperant conexio
			
			SortidaClient = new DataOutputStream(SocketConnexio.getOutputStream());
			EntradaDesdeClient = new BufferedReader(new InputStreamReader(SocketConnexio.getInputStream()));
			
			System.out.println("Conexio acceptada" + SocketConnexio.toString());
			SortidaClient.writeBytes("Conexio establerta\n");
			
			FraseClient = EntradaDesdeClient.readLine();
			System.out.println("Dades recibides: " + FraseClient);
			
			FraseMajuscules = FraseClient.toUpperCase();
			
			SortidaClient.writeBytes(FraseMajuscules + "\n");
			
			System.out.println("Enviades dades al client: " + FraseMajuscules);
			
			
		}
		SocketAcollida.close();//tanquem la conexio del servidor
	}

}

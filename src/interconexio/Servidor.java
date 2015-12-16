package interconexio;

import java.io.*;
import java.net.*;

public class Servidor implements Runnable {
	
	private int port;
	
	
	Servidor() throws NumberFormatException, IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Creando servidor");
		System.out.println("Inserta port del servidor: ");
		port = Integer.parseInt(entrada.readLine());
		
		String localIP = InetAddress.getLocalHost().getHostAddress();
		System.out.println("La ip del servidor es: " + localIP);
	}
	
	void crear() throws IOException{
		
		String fraseClient;
		//String fraseMajuscules;
		ServerSocket socketAcollida = new ServerSocket(port);
		
		DataOutputStream sortidaClient = null;
        BufferedReader entradaDesdeClient = null;
        
        Boolean continuar = true;
        
		while(continuar){
		
			
			Socket socketConnexio = socketAcollida.accept();// Servidor esperant conexio
			sortidaClient = new DataOutputStream(socketConnexio.getOutputStream());
			entradaDesdeClient = new BufferedReader(new InputStreamReader(socketConnexio.getInputStream()));
			
			
			sortidaClient.writeBytes("Conexio establerta\n");
			
			while(continuar){
								
				fraseClient = entradaDesdeClient.readLine();
				if(fraseClient.equalsIgnoreCase("close")){
					continuar = false;
				} else {
					System.out.println(fraseClient);
				}				
			}			
		}
		socketAcollida.close();//tanquem la conexio del servidor
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			crear();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
}

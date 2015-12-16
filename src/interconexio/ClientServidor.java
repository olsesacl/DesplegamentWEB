package interconexio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ClientServidor{
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		Servidor server = new Servidor();
		Thread proceso_servidor = new Thread(server);
		proceso_servidor.start();
		
		System.out.println("Cuando quiera crear el cliente pulse intro");
		entrada.readLine();
		
		Client client = new Client();
		Thread proceso_cliente = new Thread(client);
		proceso_cliente.start();
		
		
	}
}

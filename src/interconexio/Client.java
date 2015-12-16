
package interconexio;
import java.io.*;
import java.net.*;


public class Client implements Runnable{
	
	private int portServer;
	private String ip;
	private int portLocal;
	private String nom;
	
    Client() throws NumberFormatException, IOException {
    	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.println("Creando cliente");
    	
    	System.out.print("Inserta ip del servidor: ");
    	this.ip = entrada.readLine();
    	
    	System.out.print("Inserta port del servidor: ");
    	this.portServer = Integer.parseInt(entrada.readLine());
    	
    	System.out.print("Inserta port local: ");
    	this.portLocal = Integer.parseInt(entrada.readLine());
    	
    	System.out.print("Inserta nom: ");
    	this.nom = entrada.readLine();
    }
    
    void conectar(){
        
        BufferedReader entradaTeclat = new BufferedReader(new InputStreamReader(System.in));
        
        DataOutputStream sortidaAlServidor = null;
        BufferedReader entradaDesdeServidor = null;
        
        String frase; 
        String benbingudaServer;
       // String fraseModificada;
        
        Socket clientSocket;
        
        boolean continuar = true;
        
        try {
            clientSocket = new Socket(this.ip, this.portServer, null , this.portLocal);
            //clientSocket = new Socket("10.2.1.179", PORT, InetAddress.getByName("localhost"),7001);
            sortidaAlServidor = new DataOutputStream(clientSocket.getOutputStream());
            entradaDesdeServidor = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            benbingudaServer = entradaDesdeServidor.readLine();
            System.out.println(benbingudaServer);
            
            while(continuar){
                frase = entradaTeclat.readLine();
                
                if(frase.equalsIgnoreCase("close")){
                	continuar = false;
                	sortidaAlServidor.writeBytes(frase + "\n");
                } else {
                	 sortidaAlServidor.writeBytes(this.nom + ": " +frase + "\n");
                }
                //fraseModificada = entradaDesdeServidor.readLine();

                //System.out.println("FROM SERVER " + fraseModificada);
            }
            

            clientSocket.close();
            System.out.println("Connexio tancada");
        
        
        } catch (IOException ex) {
            //Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No es pot establir connexió");
        }        
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		conectar();
		
	}
    
}

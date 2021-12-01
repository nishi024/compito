package it.rajapaksa;

import java.io.*;
import java.net.*;

public class ClientStr {
    String nomeServer = "localhost";  //indirizzo server locale 
    int portaServer = 6789;           //porta di servizzio data e ora
    Socket miosocket;                 //socket
    BufferedReader tastiera;          //buffer per l'input da tastiera
    String stringaUtente;             //stringa inserita da utente 
    int stringaRicevutaDalServer;     //stringa ricevuta del server
    DataOutputStream outVersoServer;  //stream di output 
    BufferedReader inDalServer;       //stream di input

    public Socket connetti() throws IOException {
        System.out.println("CLIENT in esecuzione");
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new Socket(nomeServer, portaServer); //nuovo socket
            outVersoServer = new DataOutputStream(miosocket.getOutputStream()); //scrittura
            inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream())); //lettura 
        } catch (UnknownHostException e) {
            System.err.println("host sconosciuto");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione");
            System.exit(1);
        }
        return miosocket;
    }

    public void comunica()
        {
            System.out.println("Inserire stringa");
    
            try
            {
                Object stringUtente = tastiera.read();
                System.out.println("1");
                outVersoServer.writeBytes((String) stringUtente );
                stringaRicevutaDalServer = inDalServer.read();
                System.out.println("risposta dal server" +'\n'+stringaRicevutaDalServer);
                System.out.println("closing");
            }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Error during the connection");
            System.exit(1);
        }
        
}
}

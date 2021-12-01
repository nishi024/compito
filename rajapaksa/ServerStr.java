package it.rajapaksa;

import java.io.*;
import java.net.*;

public class ServerStr {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringModicficata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public Socket attendi()
    {
        try
        {
            System.out.println("In esecuzione");
            server = new ServerSocket(6789);
            client = server.accept();
            inDalClient = new BufferedReader(new InputStreamReader (client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
            
        }

    

        catch (Exception e)
        {
        System.out.println(e.getMessage());
        System.out.println("Error during the connection");
  
        }
        return client;
    
    }

    public void comunica()
    {
        try
        {
            System.out.println("Dammi il numero estartto");
            stringaRicevuta = inDalClient.readLine();
            System.out.println("stringa ricevuta dal client: "+stringaRicevuta);
            stringModicficata =stringaRicevuta.toUpperCase(); //traforma tutta la stringa e la trasforma in maiuscolo
            System.out.println("invio stringa modificata dal client");
            outVersoClient.writeBytes(stringModicficata+'\n');
            
            System.out.println("end sever");
            client.close();
        }
        catch (Exception e)
        {
        System.out.println(e.getMessage());
        System.out.println("Error during the connection");
  
        }
    }
}
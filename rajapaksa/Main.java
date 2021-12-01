package it.rajapaksa;

public class Main
{
    public static void main(String [])
     {
        ServerStr server = new ServerStr();
        server.attendi();
        server.comunica();
     }
    public static void  main(String [])
     {
        ClientStr client= new ClientStr();
        client.connetti();
        client.comunica();      
     }
} 
package it.rajapaksa;

import java.io.IOException;

public class MainClient {
   public static void main(String args[]) throws IOException {
      ClientStr client = new ClientStr();
      client.connetti();
      client.comunica();
   }
}

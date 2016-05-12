/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryfile;

import gotstrategygame.Game;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bisho
 */
public class Network implements Serializable{
    //Socket s;
    //ServerSocket c;
   ObjectOutputStream out;
   ObjectInputStream in = null; 
   ServerSocket c;
   Socket s;
    public void sendUpdate(Game g) throws IOException
    {
         this.c = new ServerSocket(4000);
         System.out.println("Server  is waiting for Connection");
         this. s = c.accept();
         System.out.println("Connection Successfull");
         out = new ObjectOutputStream(s.getOutputStream());
         out.writeObject(g);
         System.out.println("5ood ysta");
         out.close();
         s.close();
         
        
    }
    public Game recieveUpdate() throws IOException, ClassNotFoundException
    {
        this. c = new ServerSocket(4000);
        System.out.println("Server  is waiting for Connection");
        this.s=c.accept();
        System.out.println("Connection Successfull");
       in = new ObjectInputStream(s.getInputStream());
      System.out.println("ksjvoowdjodhjdjh");
        Game g = (Game) in.readObject();
        System.out.println("Wslt ystaaa");
        in.close();
        s.close();
        
        return g;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.arem.Ejercicio4_3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Math;

/**
 *
 * @author 2108419
 */
public class EchoServer2 {
    
    
    public static int fun = 0;
    
    public static void main(String[] args) throws IOException {
    
    ServerSocket serverSocket = null;
    try {
        serverSocket = new ServerSocket(35000);
    } catch (IOException e) {
        System.err.println("Could not listen on port: 35000.");
        System.exit(1);
    }
    Socket clientSocket = null;
    try {
        clientSocket = serverSocket.accept();
    } catch (IOException e) {
        System.err.println("Accept failed.");
        System.exit(1);
    }
    
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
    String inputLine, outputLine;
    while ((inputLine = in.readLine()) != null) {
        System.out.println("Mensaje: " + inputLine);                        
        if(inputLine.indexOf("fun:") == 0){            
            if(inputLine.indexOf("sin") == 4){                
                fun = 1;
            }else if(inputLine.indexOf("tan") == 4){                                                   
                fun = 2;
            }else if(inputLine.indexOf("cos") == 4){
                fun = 0;
            }
            outputLine = "Se realizar el cambio de funcion";
        }else{
            double res = Double.parseDouble(inputLine);       
            double a = operacion(res);      
            outputLine = "Respuesta: " + a; 
        }                                        
        
        out.println(outputLine);
        if (outputLine.equals("Respuestas: Bye."))
            break;
        }
        
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    public static double operacion(double num){
        double op;
        switch (fun) {
            case 0:
                op = Math.cos(num);
                break;
            case 1:
                op = Math.sin(num);
                break;
            default:
                op = Math.tan(num);
                break;
        }
        return op;
    }
    
}

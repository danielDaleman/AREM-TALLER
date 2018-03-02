/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.arem;

import java.io.*;
import java.net.*;


/**
 *
 * @author 2108419
 */
public class TALLERAREM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException{
        
        Ejercicios ej = new Ejercicios();
        ej.ejercicio1();
        ej.ejercicio2();
        
        /**try (BufferedReader reader= new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {   
            System.err.println(x);
        }**/
    }

       
    }                                        


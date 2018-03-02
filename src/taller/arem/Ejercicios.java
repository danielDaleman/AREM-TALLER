/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.arem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.io.OutputStreamWriter;

/**
 *
 * @author 2108419
 */
public class Ejercicios {
    
    public void ejercicio1() throws MalformedURLException{
    
        URL google = new URL("http://www.whatever.com:80/?var=val#anchor");
        
        System.out.println("PROTOCOL : " + google.getProtocol());
        System.out.println("AUTHORITY : " + google.getAuthority());
        System.out.println("HOST : " + google.getHost());
        System.out.println("PORT : " + google.getPort());
        System.out.println("PATH : " + google.getPath());
        System.out.println("QUERY : " + google.getQuery());
        System.out.println("FILE : " + google.getFile());
        System.out.println("REF : " + google.getRef());
        
    }
    
    public void ejercicio2() throws MalformedURLException, FileNotFoundException, IOException{
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();                
        URL u = new URL("http://" + url);
        File f = File.createTempFile("resultado",".html");
        
        FileOutputStream is = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(is);
        
        try (BufferedReader reader= new BufferedReader(new InputStreamReader(u.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null){
                osw.write(inputLine);
                System.out.println(inputLine);
            }
            osw.close();
        }catch (IOException x) {
            System.err.println(x);
        }                       
    }
    
    
    
    
}

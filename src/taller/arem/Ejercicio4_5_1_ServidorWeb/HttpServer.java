/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.arem.Ejercicio4_5_1_ServidorWeb;

import java.net.*;
import java.io.*;

/**
 *
 * @author 2108419
 */
public class HttpServer {
    public static void main(String[] args) throws IOException {
        while(true){
            ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        outputLine = "HTTP/1.1 200 OK \n"
            + "Content-Type: text/html; charset=utf-8\n"
            + "Cache-Control: public, max-age=60, s-maxage=300\n"
            + "Vary: Accept-Encoding\n"
            + "Content-Encoding: raw\n"
            + "Server: DPS/1.3.5\n"
            + "X-SiteId: 2000\n"
            + "Set-Cookie: dps_site_id=2000; path=/\n"
            + "ETag: a1be084ec13bc207c17c49955f875fab\n"
            + "Date: Mon, 26 Feb 2018 21:47:54 GMT\n"
            + "Connection: keep-alive\n"
            + "Transfer-Encoding: chunked\n"                         
            + "<!DOCTYPE html>"
            + "<html>"
            + "<head>"
            + "<meta charset=\"UTF-8\">"
            + "<title>Title of the document</title>\n"
            + "</head>"
            + "<body>"
            + "My Web Site"
            + "</body>"
            + "</html>" + inputLine;
        out.println(outputLine);

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
        }
    }
}

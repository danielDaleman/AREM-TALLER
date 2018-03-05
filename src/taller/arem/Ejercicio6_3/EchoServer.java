/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.arem.Ejercicio6_3;

/**
 *
 * @author danie
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoServer extends Remote {
    public String echo(String cadena) throws RemoteException;
}

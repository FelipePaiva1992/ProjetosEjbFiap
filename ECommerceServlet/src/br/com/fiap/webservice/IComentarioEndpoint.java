/**
 * IComentarioEndpoint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.webservice;

public interface IComentarioEndpoint extends java.rmi.Remote {
    public br.com.fiap.webservice.Comentario[] listaComentarios() throws java.rmi.RemoteException;
    public void inserirComentario(br.com.fiap.webservice.Comentario arg0) throws java.rmi.RemoteException;
}

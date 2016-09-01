package br.com.fiap.webservice;

public class IComentarioEndpointProxy implements br.com.fiap.webservice.IComentarioEndpoint {
  private String _endpoint = null;
  private br.com.fiap.webservice.IComentarioEndpoint iComentarioEndpoint = null;
  
  public IComentarioEndpointProxy() {
    _initIComentarioEndpointProxy();
  }
  
  public IComentarioEndpointProxy(String endpoint) {
    _endpoint = endpoint;
    _initIComentarioEndpointProxy();
  }
  
  private void _initIComentarioEndpointProxy() {
    try {
      iComentarioEndpoint = (new br.com.fiap.webservice.ComentarioEndPointLocator()).getComentarioEndpointPort();
      if (iComentarioEndpoint != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iComentarioEndpoint)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iComentarioEndpoint)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iComentarioEndpoint != null)
      ((javax.xml.rpc.Stub)iComentarioEndpoint)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.fiap.webservice.IComentarioEndpoint getIComentarioEndpoint() {
    if (iComentarioEndpoint == null)
      _initIComentarioEndpointProxy();
    return iComentarioEndpoint;
  }
  
  public br.com.fiap.webservice.Comentario[] listaComentarios() throws java.rmi.RemoteException{
    if (iComentarioEndpoint == null)
      _initIComentarioEndpointProxy();
    return iComentarioEndpoint.listaComentarios();
  }
  
  public void inserirComentario(br.com.fiap.webservice.Comentario arg0) throws java.rmi.RemoteException{
    if (iComentarioEndpoint == null)
      _initIComentarioEndpointProxy();
    iComentarioEndpoint.inserirComentario(arg0);
  }
  
  
}
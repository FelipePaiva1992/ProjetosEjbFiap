/**
 * ComentarioEndPointLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.webservice;

public class ComentarioEndPointLocator extends org.apache.axis.client.Service implements br.com.fiap.webservice.ComentarioEndPoint {

    public ComentarioEndPointLocator() {
    }


    public ComentarioEndPointLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ComentarioEndPointLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ComentarioEndpointPort
    private java.lang.String ComentarioEndpointPort_address = "http://localhost:8080/ECommerceJSF/ComentarioEndPoint/ComentarioEndpoint";

    public java.lang.String getComentarioEndpointPortAddress() {
        return ComentarioEndpointPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ComentarioEndpointPortWSDDServiceName = "ComentarioEndpointPort";

    public java.lang.String getComentarioEndpointPortWSDDServiceName() {
        return ComentarioEndpointPortWSDDServiceName;
    }

    public void setComentarioEndpointPortWSDDServiceName(java.lang.String name) {
        ComentarioEndpointPortWSDDServiceName = name;
    }

    public br.com.fiap.webservice.IComentarioEndpoint getComentarioEndpointPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ComentarioEndpointPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getComentarioEndpointPort(endpoint);
    }

    public br.com.fiap.webservice.IComentarioEndpoint getComentarioEndpointPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.fiap.webservice.ComentarioEndPointSoapBindingStub _stub = new br.com.fiap.webservice.ComentarioEndPointSoapBindingStub(portAddress, this);
            _stub.setPortName(getComentarioEndpointPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setComentarioEndpointPortEndpointAddress(java.lang.String address) {
        ComentarioEndpointPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.fiap.webservice.IComentarioEndpoint.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.fiap.webservice.ComentarioEndPointSoapBindingStub _stub = new br.com.fiap.webservice.ComentarioEndPointSoapBindingStub(new java.net.URL(ComentarioEndpointPort_address), this);
                _stub.setPortName(getComentarioEndpointPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ComentarioEndpointPort".equals(inputPortName)) {
            return getComentarioEndpointPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.fiap.com.br/", "ComentarioEndPoint");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.fiap.com.br/", "ComentarioEndpointPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ComentarioEndpointPort".equals(portName)) {
            setComentarioEndpointPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

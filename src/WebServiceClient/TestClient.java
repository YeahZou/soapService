package WebServiceClient;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import WebServiceSystem.WebServiceInterface;

public class TestClient {

	public static void main(String[] args) {
		String serviceAddr = "http://127.0.0.1:1234/webService/webservicetest?wsdl";
		String namespaceURI = "http://WebServiceSystem/";
		String localPart = "WebServiceImplService";
		try {
			/**
			 * 1、service编程调用方式
			 */
			URL url = new URL(serviceAddr);
			QName qname = new QName(namespaceURI, localPart);
			Service service = Service.create(url, qname);
			
			// Web Service Server
			WebServiceInterface server = service.getPort(WebServiceInterface.class);
			System.out.println("service编程调用方式：" + server.sayHello("King"));
			
		} catch (Exception ex) {
			System.out.println("Exception" + ex.getMessage());
		}
	}
}

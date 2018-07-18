package WebServiceSystem;

import javax.xml.ws.Endpoint;

public class TestSystem {
	
	public static void main(String[] args) {
		String url = "http://127.0.0.1:1234/webService/webservicetest";
		Endpoint.publish(url, new WebServiceImpl());
		//Endpoint.publish(url, new WebServiceImpl2());
		System.out.println("publish successful");
	}
}

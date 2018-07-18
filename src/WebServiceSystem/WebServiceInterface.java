package WebServiceSystem;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface WebServiceInterface {
	@WebMethod
	String sayHello(@WebParam(name = "name", targetNamespace = "")String name);
	
	@WebMethod
	String save(String name, String pwd);
}

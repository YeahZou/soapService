package WebServiceSystem;

import javax.jws.WebService;

@WebService(endpointInterface = "WebServiceSystem.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface {
	@Override
	public String sayHello(String name) {
		return "sayHello " + name;
	}
	
	@Override
	public String save(String name, String pwd) {
		return "save success";
	}

}

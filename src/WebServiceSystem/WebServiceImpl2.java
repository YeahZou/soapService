package WebServiceSystem;

import javax.jws.WebService;

@WebService(endpointInterface = "WebServiceSystem.WebServiceInterface2")
public class WebServiceImpl2 implements WebServiceInterface2 {
	@Override
	public String sayHello(String name) {
		return "sayHello2 " + name;
	}
	
	@Override
	public String save(String name, String pwd) {
		return "save success2";
	}

}


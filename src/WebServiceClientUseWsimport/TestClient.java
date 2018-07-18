package WebServiceClientUseWsimport;


public class TestClient {
	public static void main(String[] argv) {
		// 获取服务
		WebServiceImplService service = new WebServiceImplService();
		// 获取实现类
		WebServiceImpl impl = service.getPort(WebServiceImpl.class);
		// impl = service.getWebServiceImplPort()
		
		// 调用实现类的方法
		impl.sayHello("I come from wsimport tool ");
	}
}

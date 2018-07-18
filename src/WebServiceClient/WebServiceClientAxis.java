package WebServiceClient;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;


public class WebServiceClientAxis {
	public static void main(String[] args) {
		String serviceAddr = "http://127.0.0.1:1234/webService/webservicetest?wsdl";
		String namespaceURI = "http://WebServiceSystem/";
		try {  
			  
            Service service = new Service();  
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(serviceAddr);  
            
            // WSDL里面描述的接口名称(要调用的方法)  
            call.setOperationName(new QName(namespaceURI,"sayHello"));  
            
            // 接口方法的参数名, 参数类型,参数模式  IN(输入), OUT(输出) or INOUT(输入输出)  
            call.addParameter("name", XMLType.XSD_STRING, ParameterMode.IN);  
            
            // 设置被调用方法的返回值类型  
            call.setReturnType(XMLType.XSD_STRING);
            
            //设置方法中参数的值  
            Object[] paramValues = new Object[] {"Yeah"}; 
            
            // 给方法传递参数，并且调用方法  
            String result = (String) call.invoke(paramValues);    
      
            System.out.println("result is " + result);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
}

package DongGuanLib;

import com.dcfs.qed.webservice.service.imp.WebServiceITILReturn;
import com.dcfs.qed.webservice.service.imp.WebServiceITILReturnImplService;

public class Test {
	
	public void testMethod() {
		// 获取服务
		WebServiceITILReturnImplService webServiceITILReturnImplService = new WebServiceITILReturnImplService();
		// 获取实现类
		WebServiceITILReturn webServiceITILReturn = webServiceITILReturnImplService.getWebServiceITILReturnImplPort();
		
		String systemName = "", subSysName = "", versionName = "", result = "", log = "", jobId = "";
		// 调用实现类的方法
		webServiceITILReturn.autoDeployResult(systemName, subSysName, versionName, result, log, jobId);
	}
}

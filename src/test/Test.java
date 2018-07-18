package test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		/*
		// 测试toString
		List<String> list = new ArrayList<>();
		list.add("zou");
		list.add("ye");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add("zou");
		jsonArray.add("ye");
		
		String [] arr = new String[] {"zou", "ye"};
		
		System.out.println(list.toString() + jsonArray.toString() + arr.toString());
		*/
		
		/*
		// 测试正则表达式
		String template = "<dbAlias>=<dbType>/<host>:<port>/<sid>";
		String conf = "informix=informix/192.168.0.24:13668/test1@ol_informix1210";
		List<String> keys = getKeysFromTemplate(template);
		List<String> values = getValuesFromConf(conf, template);
		JSONObject confJson = new JSONObject();
		
		if (!keys.isEmpty() && keys.size() == values.size()) {
			for (int i = 0; i < keys.size(); i++) {
				confJson.put(keys.get(i), values.get(i));
			}
		}
		System.out.println(confJson.toString(2));
		*/
		
		// 测试str.matches, 要完整匹配
		System.out.println("http://123.git".matches("^.+?\\.git$"));
		System.out.println("svn://123.git".matches("^(:?svn|http|https):\\/\\/.+?$"));
		
		// 测试obj.forEach
		JSONObject obj = new JSONObject();
		obj.put("a","1");
		obj.put("b", 2);
		for (Object k: obj.keySet()) {
			System.out.println(k);
		}
		
		JSONArray arr1 = new JSONArray();
		JSONArray arr2 = new JSONArray();
		arr1.add(123);arr2.add(234);
		arr2.add("abcd");
		arr2.add("defghijklmnopqrstuvwxyz");
		arr1.addAll(arr2);
		System.out.println(arr1);
		
		String str = "git.repo=<repo>";
		System.out.println(str.replace("<repo>", "123456789"));
		
		String str2 = "repotype=git\r\n" + 
				"repo=<repo>\r\n" + 
				"git.masterBranch=<repo>\r\n" + 
				"git.user=<repo>\r\n" + 
				"git.password=<repo>\r\n" + 
				"gitbranch=<repo>";
		System.out.print(str2.replace("<repo>", "222222222"));
		
	}
	
	/**
	 * 根据模板规则，解析配置
	 * @param conf 配置
	 * @param template 模板
	 * @return valueList
	 */
	public static List<String> getValuesFromConf(String conf, String template) {
		List<String> values = new ArrayList<>();
		
		if (conf != null && !conf.equals("") && template != null && !template.equals("")) {
			//处理转义字符  '$', '(', ')', '*', '+', '.', '[', ']', '?', '\\', '^', '{', '}', '|'
			String reg = template.replaceAll("(\\$|\\(|\\)|\\*|\\+|\\.|\\[|\\]|\\?|\\\\|\\^|\\{|\\}|\\|)", "\\\\$1");
			reg = "^" + reg.replaceAll("<.+?>", "(.+?)") + "$";
			
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(conf);
			if (m.find()) {
				for (int i = 1; i <= m.groupCount(); i++) {
					values.add(m.group(i));
				}
			}
		}
		
		return values;
	}
	
	/**
	 * 解析模板中的 key
	 * @param template
	 * @return keyList
	 */
	public static List<String> getKeysFromTemplate(String template) {
		List<String> keys = new ArrayList<>();
		
		if (template != null && !template.equals("")) {
			int start = template.indexOf('<');
			int end = template.indexOf('>');
			while(start > -1 && end > -1 && end > start) {
				keys.add(template.substring(start + 1, end));
				template = template.substring(end + 1);
				start = template.indexOf('<');
				end = template.indexOf('>');
			}
		}
		return keys;
	}
}

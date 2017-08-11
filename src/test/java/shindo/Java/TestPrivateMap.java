package shindo.Java;

import java.util.HashMap;
import java.util.Map;

public class TestPrivateMap {
	private Map<String, String> parameters = new HashMap<String,String>();
	
	public void parseRequest(Map<String,String> condition) {
		for(Map.Entry<String, String> entry:condition.entrySet()) {
			this.setParameter(entry.getKey(),entry.getValue());
		}
		
		this.parameters = changeValue(this.parameters);
		for(Map.Entry<String,String> backMap : this.parameters.entrySet()) {
			System.out.println("修改后的map值："+ "key = "+backMap.getKey()+" , value = "+ backMap.getValue());
		}
		
	}
	
	public void setParameter(String parameter,String parameterValue) {
		String v = null;
		if(null != parameterValue) {
			v = parameterValue;
		}
		this.parameters.put(parameter, parameterValue);
	}
	
	public Map<String,String> changeValue(Map<String,String> parameter){
		Map<String,String> result = new HashMap<String,String>();
		result.put("name", "shindo");
		result.put("age", "27");
		result.put("sex", "male");
		
		return result;
	}
	
	public static void main(String[] args) {
		Map<String,String> requestMap = new HashMap<String,String>();
		requestMap.put("name", "rose");
		requestMap.put("age", null);
		requestMap.put("sex", "famail");
		
		for(Map.Entry<String, String> request:requestMap.entrySet()) {
			System.out.println("请求的map值："+ "key = "+request.getKey()+" , value = "+ request.getValue());
		}
		
		System.out.println();
		
		new TestPrivateMap().parseRequest(requestMap);
	}
	
}

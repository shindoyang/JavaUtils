package shindo.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class TestSku {
	public static void main(String[] args) {
		// 构造模拟数据
		String str = "{\"attrId\":\"160\",\"attrName\":\"成分\",\"attrValId\":\"777\",\"id\":\"13315\",\"marketPrice\":\"562\"}";
		String str2 = "{\"attrId\":\"70\",\"attrName\":\"容量\",\"attrValId\":\"684\",\"id\":\"25478\",\"marketPrice\":\"152\"}";
		String str3 = "{\"attrId\":\"98\",\"attrName\":\"规格\",\"attrValId\":\"254\",\"id\":\"13315\",\"marketPrice\":\"562\"}";

		List skuList = new ArrayList();
		skuList.add(str);
		skuList.add(str2);
		skuList.add(str3);

		// 解析数据
		List back = new ArrayList();
		while(skuList.size()>0) {
			for (int i = 0; i < skuList.size(); i++) {
				//拿到第一个对象
				String strDto = (String) skuList.get(i);
				Map maps = (Map) JSON.parse(strDto);
				
				for (Object map : maps.entrySet()) {
					String key = (String) ((Map.Entry) map).getKey();
					//拿到id值
					if("id".equals(key)) {
						String id = (String) ((Map.Entry) map).getValue();
						
						//遍历循环
						for(int j = 0; j < skuList.size(); j++) {
							String strDto2 = (String) skuList.get(j);
							Map maps2 = (Map) JSON.parse(strDto2);
							for(Object map3 : maps2.entrySet()) {
								
								//如果id相同
								if(id.equals((String) ((Map.Entry) map3).getValue())) {
									Map result = new HashMap();
									result.put("id", id);
									for(Object map4 : maps2.entrySet()) {
										if("attrId".equals((String) ((Map.Entry) map4).getKey())) {
											String attrId = (String) ((Map.Entry) map4).getValue();
											result.put("attrId", attrId);
										}
										if("attrName".equals((String) ((Map.Entry) map4).getKey())) {
											String attrName = (String) ((Map.Entry) map4).getValue();
											result.put("attrName", attrName);
										}
										if("attrValId".equals((String) ((Map.Entry) map4).getKey())) {
											String attrValId = (String) ((Map.Entry) map4).getValue();
											result.put("attrValId", attrValId);
										}
									}
									back.add(result);
								}
							}
						}
					}
									}
				skuList.remove(i);
			}
		}
		
		//打印数据
		for(int k =0 ;k<back.size();k++) {
			Map dt = (Map) back.get(k);
			System.out.println(dt.toString());
		}

	}
}

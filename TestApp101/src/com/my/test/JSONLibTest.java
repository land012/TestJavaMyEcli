package com.my.test;
import java.util.ArrayList;
import java.util.List;

import com.my.base.BaseTest;
import com.my.vo.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JSONLibTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// JSONObject
//		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("name", "tom");
//		jsonObj.put("age", "20");
//		info.info(jsonObj);		
//		jsonObj.element("1119", "1119_txt");
//		info.info(jsonObj);
		
		// JSONArray 中添加 JSONObject
//		JSONObject jsonObj1 = new JSONObject();
//		jsonObj1.put("name", "tom");
//		jsonObj1.put("age", "20");
//		
//		JSONObject jsonObj2 = new JSONObject();
//		jsonObj2.put("name", "jim");
//		jsonObj2.put("age", "21");
//		
//		JSONArray jsonArr = new JSONArray();
//		jsonArr.add(jsonObj1);
//		jsonArr.add(jsonObj2);
//		info.info(jsonArr); // [{"name":"tom","age":"20"},{"name":"jim","age":"21"}]
//		info.info(jsonObj1.getString("name")); // tom
		
		// fromObject 输出一个对象
//		User u = new User();
//		u.setName("tom");
//		u.setAge("20");
//		u.setGender("male");
//		u.setAddress("BeiJing");
//		JSONArray jsonArr1 = JSONArray.fromObject(u);
//		JSONObject jsonObj1 = JSONObject.fromObject(u);
//		info.info(jsonArr1); // [{"address":"BeiJing","age":"20","gender":"male","name":"tom"}]
//		info.info(jsonObj1); // {"address":"BeiJing","age":"20","gender":"male","name":"tom"}
		
		/**
		 * fromObject 输出一个 List<Obj>
		 */
		User u1 = new User();
		u1.setName("tom");
		u1.setAge("20");
		u1.setGender("male");
		u1.setAddress("BeiJing");
		User u2 = new User();
		u2.setName("lucy");
		u2.setAge("21");
		u2.setGender("female");
		u2.setAddress("San Francisco");
		List<User> ulist = new ArrayList<User>();
		ulist.add(u1);
		ulist.add(u2);
		JSONArray jArr1 = JSONArray.fromObject(ulist);
		/*
		 * 打印结果
		 * [{"address":"BeiJing","age":"20","gender":"male","name":"tom"},
		 *  {"address":"San Francisco","age":"21","gender":"female","name":"lucy"}]
		 */
//		info.info(jArr1);
//		info.info(jArr1.get(0)); // {"address":"BeiJing","age":"20","gender":"male","name":"tom"}
//		info.info(jArr1.getJSONObject(0).getString("name")); // tom
		/**
		 * 异常： net.sf.json.JSONException: 'object' is an array. Use JSONArray instead
		 * list 不能转成 JSONObject，须转成 JSONArray
		 */
		//JSONObject jObj1 = JSONObject.fromObject(ulist);
		
		// 异常：net.sf.json.JSONException: JSONArray[0] is not a JSONArray.
		//info.info(jArr1.getJSONArray(0));
		// 异常：java.lang.ClassCastException: net.sf.json.JSONObject
		//User u = (User)jArr1.get(0);
		
		JSONArray jArr2 = JSONArray.fromObject(u1);
//		info.info(jArr2.getString(0)); // {"address":"BeiJing","age":"20","gender":"male","name":"tom"}
		
//		JSONObject ju3 = jArr2.getJSONObject(0);
//		info.info(ju3); // {"address":"BeiJing","age":"20","gender":"male","name":"tom"}
		
//		jArr2.clear();
//		jArr2.add("v1");
//		jArr2.add("v2");
//		jArr2.add("v3");
//		info.info(jArr2.getString(0)); // v1
		
		/**
		 * 解析 JSON字符串
		 */
//		String str = "[{\"name\":\"tom\",\"age\":\"20\"}, {\"name\":\"jim\",\"age\":\"21\"}]";
//		JSONArray jArr3 = JSONArray.fromObject(str);
//		info.info(jArr3); // [{"name":"tom","age":"20"},{"name":"jim","age":"21"}]
//		info.info(jArr3.getString(0)); // {"name":"tom","age":"20"}
//		JSONObject jObj1 = jArr3.getJSONObject(0);
//		info.info(jObj1.get("name")); // tom
		
//		String str = "{\"name\":\"tom\", \"age\":\"17\"}";
//		JSONObject obj = JSONObject.fromObject(str);
//		info.info(obj);
//		info.info(obj.get("name"));
		
		JSONObject obj1 = JSONObject.fromObject(u1);
		info.info(obj1);
		User u3 = (User)JSONObject.toBean(obj1, User.class);
		info.info(u3.getName());
		
	}

}

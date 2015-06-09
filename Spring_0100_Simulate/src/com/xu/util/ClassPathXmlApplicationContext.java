package com.xu.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
/**
 * 模拟 Spring
 * @author asdf
 *
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
	
	private static Map<String, Object> beans = new HashMap<String, Object>();
	
	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sax = new SAXBuilder();
		Document doc = sax.build(ClassPathXmlApplicationContext.class.getClassLoader().getResourceAsStream("beans.xml"));
		Element root = doc.getRootElement();
		List<Element> listBean = root.getChildren("bean");
		for(Element e : listBean) {
			String name = e.getAttributeValue("name");
			String className = e.getAttributeValue("class");
			Object o = Class.forName(className).newInstance();
			System.out.println("初始化对象：" + name);
			beans.put(name, o);
			
			// 使用这种方式时，要被引用的 bean 在 xml 配置文件中要写到前面
//			List<Element> propertyList = e.getChildren("property");
//			for(Element p : propertyList) {
//				String pname = p.getAttributeValue("name");
//				String ref = p.getAttributeValue("ref");
//				BeanUtils.setProperty(o, pname, beans.get(ref));
//			}
		}
		// 使用这种方式，不必考虑配置文件中 bean 写的先后顺序
		for(Element e : listBean) {
			List<Element> propertyList = e.getChildren("property");
			Object bean = beans.get(e.getAttributeValue("name"));
			for(Element p : propertyList) {
				String name = p.getAttributeValue("name");
				String ref = p.getAttributeValue("ref");
				BeanUtils.setProperty(bean, name, beans.get(ref));
			}
		}
	}

	@Override
	public Object getBean(String key) {
		return beans.get(key);
	}

}

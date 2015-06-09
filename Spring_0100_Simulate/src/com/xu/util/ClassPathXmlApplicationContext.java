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
 * ģ�� Spring
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
			System.out.println("��ʼ������" + name);
			beans.put(name, o);
			
			// ʹ�����ַ�ʽʱ��Ҫ�����õ� bean �� xml �����ļ���Ҫд��ǰ��
//			List<Element> propertyList = e.getChildren("property");
//			for(Element p : propertyList) {
//				String pname = p.getAttributeValue("name");
//				String ref = p.getAttributeValue("ref");
//				BeanUtils.setProperty(o, pname, beans.get(ref));
//			}
		}
		// ʹ�����ַ�ʽ�����ؿ��������ļ��� bean д���Ⱥ�˳��
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

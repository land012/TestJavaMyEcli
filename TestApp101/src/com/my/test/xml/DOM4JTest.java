package com.my.test.xml;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JTest {

	/**
	 * @param args
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws DocumentException {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
				"<class>                                " +
				"	<classname>1_1</classname>                   " +
				"	<teachers>                              " +
				"		<teacher1>                          " +
				"			<id>1</id>       " +
				"			<name>%E6%9D%8E</name>       " +
				"		</teacher1>                         " +
				"		<teacher2>                        " +
				"			<id>2</id>       " +
				"			<name>zhang</name>       " +
				"		</teacher2>                       " +
				"	</teachers>                             " +
				"	<students>                              " +
				"		<student1>                          " +
				"			<id>1</id>       " +
				"			<name>li</name>       " +
				"		</student1>                         " +
				"		<student2>                        " +
				"			<id>2</id>       " +
				"			<name>zhang</name>       " +
				"		</student2>                       " +
				"	</students>                             " +
				"</class>                               ";
		Map<String, String> xmlMap = null;
		try {
			xmlMap = getXmlMap(xml);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		for(String key : xmlMap.keySet()) {
			System.out.println(key + "=" + xmlMap.get(key));
		}
	}
	
	private static Map<String, String> getXmlMap(String xml) throws DocumentException, UnsupportedEncodingException {
		SAXReader sax = new SAXReader();
		Document doc = sax.read(new ByteArrayInputStream(xml.getBytes()));
		Element root = doc.getRootElement();
		Map<String, String> xmlMap = new TreeMap<String, String>();
		getXmlMapByRoot(root, xmlMap, "");
		return xmlMap;
	}
	
	private static void getXmlMapByRoot(Element root, Map<String, String> map, String pre) throws UnsupportedEncodingException {
		for(Iterator<Element> i = root.elementIterator(); i.hasNext(); ) {
			Element child = i.next();
			String value = child.getTextTrim();
			if(StringUtils.isNotEmpty(value)) {
				map.put(pre + child.getName(), URLDecoder.decode(value, "utf-8"));
			}
			getXmlMapByRoot(child, map, pre + child.getName() + ".");
		}
	}

}




















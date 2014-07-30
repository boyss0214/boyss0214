package com.money.financing.util;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.money.financing.vo.SelectItemVo;

public class ParseXmlUtils {
	/**
	 * @param selectName
	 * @return
	 */
	public  List<SelectItemVo> parseApplicationConfigXML(String selectName){  

		SAXReader sax = new SAXReader();  
		Document xmlDoc;
		List<SelectItemVo> ItemList = new ArrayList<SelectItemVo>();
		try {
			InputStream in=	getClass().getResourceAsStream("/selectItem.xml");
			xmlDoc = sax.read(in);
			Element root = xmlDoc.getRootElement();//根节点  
			Element select = root.element(selectName);
			@SuppressWarnings("unchecked")
			Iterator<Element> it = select.elementIterator();
			SelectItemVo vo = null;
			
			while(it.hasNext()){
				Element item = it.next();
				String value = item.attributeValue("value");
				String label = item.getTextTrim();
				vo = new SelectItemVo();
				vo.setLabel(label);
				vo.setValue(value);
				ItemList.add(vo);
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}  
		return ItemList;
	}
	
	
}

package org.spring.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanFactory {
    Map<String,Object> objectMap = new HashMap<>();
    /**
     *
     */
    public BeanFactory(String xml) {
        File file = new File(this.getClass().getResource("/").getPath() + "//" + xml);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element elementRoot = document.getRootElement();
            // iterate through child elements of root
            for (Iterator<Element> it = elementRoot.elementIterator("bean"); it.hasNext();) {
                Element element = it.next();
                String beanId = element.attribute("id").getValue();
                String beanClass = element.attribute("class").getValue();
                Class clazz = Class.forName(beanClass);
                Object beanObject = clazz.newInstance();
                /**
                 * 维护依赖关系
                 */
                objectMap.put(beanId, beanObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getResource("/").getPath() + "//" + xml);
        System.out.println(objectMap);
    }
}

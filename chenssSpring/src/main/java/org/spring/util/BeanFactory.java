package org.spring.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanFactory {
    Map<String, Object> objectMap = new HashMap<>();

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
            for (Iterator<Element> it = elementRoot.elementIterator("bean"); it.hasNext(); ) {
                Element elementFirst = it.next();
                String beanId = elementFirst.attribute("id").getValue();
                String beanClass = elementFirst.attribute("class").getValue();
                Class clazz = Class.forName(beanClass);
                Object beanObject = null;
                /**
                 * 维护依赖关系
                 * 如果有构造函数参数
                 */
                for (Iterator<Element> itFirst = elementFirst.elementIterator("constructor-arg"); itFirst.hasNext(); ) {
                    Element elementContructor = itFirst.next();
                    String beanSecondName = elementContructor.attribute("name").getValue();
                    String beanSecondRef = elementContructor.attribute("ref") == null ? "" : elementContructor.attribute("ref").getValue();
                    String beanSecondValue = elementContructor.attribute("value") == null ? "" : elementContructor.attribute("value").getValue();

                    if (beanSecondRef != null && beanSecondRef != "") {
                        Object injectObject = objectMap.get(beanSecondName);
                        Constructor constructor = clazz.getConstructor(injectObject.getClass().getInterfaces()[0]);
                        beanObject = constructor.newInstance(injectObject);
                    } else {
                        Constructor constructor = clazz.getConstructor(java.lang.String.class);
                        beanObject = constructor.newInstance(beanSecondValue);
                    }
                }
                for (Iterator<Element> itFirst = elementFirst.elementIterator("property"); itFirst.hasNext(); ) {
                    if (beanObject == null) {
                        beanObject = clazz.newInstance();
                    }
                    Element elementProperty = itFirst.next();
                    String beanSecondName = elementProperty.attribute("name").getValue();
                    String beanSecondRef = elementProperty.attribute("ref").getValue();

                    Field fieldName = clazz.getDeclaredField(beanSecondName);
                    Object injectObject = objectMap.get(beanSecondRef);
                    fieldName.setAccessible(true);
                    fieldName.set(beanObject, injectObject);
                }


                if (beanObject == null) {
                    beanObject = clazz.newInstance();
                }
                objectMap.put(beanId, beanObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getResource("/").getPath() + "//" + xml);
        System.out.println(objectMap);
    }

    public Object getBean(String beanName) {
        return objectMap.get(beanName);
    }
}

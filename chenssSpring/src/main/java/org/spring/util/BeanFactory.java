package org.spring.util;

import com.chenss.anno.AutoWiredChenss;
import com.chenss.exception.ChenssException;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.annotation.Annotation;
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

            Attribute attrDefaultAuto = elementRoot.attribute("default-autowire");
            boolean flag = false;
            if (attrDefaultAuto != null) {
                flag = true;
            }
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

                if (flag) {
                    if (attrDefaultAuto.getValue().equals("byType")) {
                        // 判断是否有依赖
                        Field[] fields = clazz.getDeclaredFields();
                        boolean autoAutowired = false;
                        for (Field field : fields) {
                            // 判断依赖的对象是否添加了指定注解，才可以解析注入
                            Annotation[] annotations = field.getDeclaredAnnotations();
                            for (int i = 0; i < annotations.length; i++) {
                                if (annotations[i].annotationType().getSimpleName().equals(AutoWiredChenss.class.getSimpleName())) {
                                    autoAutowired = true;
                                }
                            }
                            if (!autoAutowired) {
                                continue;
                            }
                            /**
                             * 由于是使用byType，需要遍历Map中的所有对象，
                             * 判断对象的类型是否同自动注入的类型相同，如果相同，才可以注入
                             */
                            Class fieldClazz = field.getType();
                            int count = 0;
                            Object objectAuto = null;
                            for (String key : objectMap.keySet()) {
                                if (objectMap.get(key).getClass().getInterfaces()[0].getName().equals(fieldClazz.getName())) {
                                    count++;
                                    objectAuto=objectMap.get(key);
                                }
                            }
                            if (count>1) {
                                throw new ChenssException("符合条件的对象超过一个");
                            } else if (count==0) {
                                throw new ChenssException("没找到符合条件注入的对象");
                            }

                            field.setAccessible(true);
                            field.set(beanObject,objectAuto);
                        }
                    }
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

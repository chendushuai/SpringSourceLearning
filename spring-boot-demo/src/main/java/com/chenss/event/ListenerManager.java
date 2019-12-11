package com.chenss.event;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * 事件管理器
 */
public class ListenerManager {
    static List<ApplicationListener<?>> listenerList = new ArrayList<>();

    /**
     * 优雅一点的方式可以通过项目扫描添加
     * @param applicationListener
     */
    public static void addListener(ApplicationListener applicationListener) {
        listenerList.add(applicationListener);
    }

    public static void publishEvent(ApplicationEvent event) {
        for (ApplicationListener applicationListener : listenerList) {
            Class tClass = (Class)((ParameterizedType)applicationListener.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
            if (event.getClass().isAssignableFrom(tClass)) {
                applicationListener.onEvent(event);
            }
        }
    }
}

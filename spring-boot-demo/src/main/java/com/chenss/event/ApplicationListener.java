package com.chenss.event;

public interface ApplicationListener<E extends ApplicationEvent> {
    void onEvent(E e);
}

package com.bosonit.ServiceLocatorFactoryBean.registry;

public interface AdapterService<T> {
    public void process(T request);
}

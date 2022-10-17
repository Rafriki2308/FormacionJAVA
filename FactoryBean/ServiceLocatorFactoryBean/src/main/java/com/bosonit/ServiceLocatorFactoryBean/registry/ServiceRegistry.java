package com.bosonit.ServiceLocatorFactoryBean.registry;

public interface ServiceRegistry {
    public <T> AdapterService<T> getService(String serviceName);
}

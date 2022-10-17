package com.bosonit.MotoService;

public interface ServiceRegistry {
    public <T> AdapterService<T> getService(String serviceName);
}

package com.bosonit.ServiceLocatorFactoryBean.config;

import com.bosonit.ServiceLocatorFactoryBean.registry.ServiceRegistry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class VehicleConfig {

    @Bean
    public FactoryBean<?> factoryBean(){
        final ServiceLocatorFactoryBean factory = new ServiceLocatorFactoryBean();
        factory.setServiceLocatorInterface(ServiceRegistry.class);
        return factory;
    }
}

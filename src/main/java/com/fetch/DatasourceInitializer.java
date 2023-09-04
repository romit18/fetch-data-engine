package com.fetch;

import io.micronaut.configuration.jdbc.hikari.DatasourceConfiguration;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import jakarta.inject.Singleton;

@Singleton
public class DatasourceInitializer implements BeanCreatedEventListener<DatasourceConfiguration> {
    @Override
    public DatasourceConfiguration onCreated(BeanCreatedEvent<DatasourceConfiguration> event) {
        //TODO password encryption decryption better tech
        final DatasourceConfiguration datasource = event.getBean();
        return datasource;
    }
}


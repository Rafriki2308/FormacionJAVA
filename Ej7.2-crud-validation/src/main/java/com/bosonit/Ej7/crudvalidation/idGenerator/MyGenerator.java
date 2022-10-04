package com.bosonit.Ej7.crudvalidation.idGenerator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class MyGenerator implements IdentifierGenerator {


    @Override
    public Serializable generate(
            SharedSessionContractImplementor session, Object obj)
            throws HibernateException {

        String query = String.format("select %s from %s",
                session.getEntityPersister(obj.getClass().getName(), obj)
                        .getIdentifierPropertyName(),
                obj.getClass().getSimpleName());

        Stream<String> ids = session.createQuery(query).stream();

        Long max = ids.map(o -> o.replace(obj.getClass().getSimpleName().toLowerCase() + "-", ""))
                .mapToLong(Long::parseLong)
                .max()
                .orElse(0L);

        return obj.getClass().getSimpleName().toLowerCase() + "-" + (max + 1);
    }
}
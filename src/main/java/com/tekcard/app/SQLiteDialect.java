package com.tekcard.app;

import org.hibernate.boot.model.TypeContributions;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
import org.hibernate.query.spi.QueryEngine;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.comm

public class SQLiteDialect extends Dialect {

    public SQLiteDialect(DialectResolutionInfo info) {
//        info.getDriverName()
    }
    @Override
    protected void registerColumnTypes(TypeContributions typeContributions, ServiceRegistry serviceRegistry) {
//        typeContributions.contributeJavaType(JavaType.class.);
//        serviceRegistry.
    }
    @Override
    public void initializeFunctionRegistry(QueryEngine queryEngine) {}

}

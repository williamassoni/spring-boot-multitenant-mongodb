package com.example.demo.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.mongodb.DB;
import com.mongodb.MongoClientURI;

public class MultiTenantMongoDbFactory extends SimpleMongoDbFactory {

	@Value("${multitenant.tenantKey}")
    private String tenantKey;

    public MultiTenantMongoDbFactory(MongoClientURI uri) throws UnknownHostException {
        super(uri);
    }

    @Override
    public DB getDb() throws DataAccessException {
        Object tenant = RequestContextHolder.getRequestAttributes().getAttribute(tenantKey, RequestAttributes.SCOPE_REQUEST);
        return getDb(String.valueOf(tenant));
    }
}
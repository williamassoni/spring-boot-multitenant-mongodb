package com.example.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

@WebFilter
public class MultitenantFilter implements javax.servlet.Filter{
	
	@Value("${multitenant.tenantKey}")
    private String tenantKey;

    @Value("${multitenant.defaultTenant}")
    private String defaultTenant;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        String tenant = req.getHeader(tenantKey);

        if (tenant != null) {
            req.setAttribute(tenantKey, tenant);
        } else {
            req.setAttribute(tenantKey, defaultTenant);
        }
        chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}

package com.example.week42.filter;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import javax.imageio.spi.ServiceRegistry;
import javax.servlet.*;
import java.io.IOException;

@Component
public class SimpleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

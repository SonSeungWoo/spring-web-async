package me.seungwoo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-02-12
 * Time: 16:37
 */
@Slf4j
@Configuration
@Order(1)
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        log.info("[filter Order1-1]Starting a transaction for req : {}", req.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("[filter Order1-2]Committing a transaction for req : {}", req.getRequestURI());
    }

}

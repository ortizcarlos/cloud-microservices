/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.api.gateway;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Carlos
 */
public class JWTRequestFilter extends ZuulFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(JWTRequestFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        LOGGER.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String name = headers.nextElement();
            LOGGER.info(String.format("%s value %s ", name, request.getHeader(name)));
        }

        //ctx.addOriginResponseHeader("Authorization", request.getHeader("authorization"));
        ctx.addZuulRequestHeader("Authorization", request.getHeader("authorization"));

        return null;
    }

}

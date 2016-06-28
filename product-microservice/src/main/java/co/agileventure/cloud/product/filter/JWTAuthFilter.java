/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.agileventure.cloud.product.filter;

import io.jsonwebtoken.Claims;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Carlos
 */
public class JWTAuthFilter implements Filter {
    
    
    private String appSecretKey;

    public JWTAuthFilter(String appSecretKey) {
        this.appSecretKey = appSecretKey;
    }
    

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        //String authHeader = httpRequest.getHeader("Authorization");
        //System.out.println("==>authHeader: " + authHeader);
        /*
         Enumeration<String> headers = httpRequest.getHeaderNames();  
         while (headers.hasMoreElements()) {
         String name = headers.nextElement();
         System.out.println(String.format("%s value %s ", name, httpRequest.getHeader(name)));
         }

         if (StringUtils.isBlank(authHeader) || authHeader.split(" ").length != 2) {
         httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
         } else {
         Jwts.
         parser().
         parse(authHeader)
         ;
         filterChain.doFilter(request, response);
         }*/
        final String authHeader = httpRequest.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Missing or invalid Authorization header.");
        } else {

            final String token = authHeader.substring(7); // The part after "Bearer "

            try {
                final Claims claims = Jwts.parser().setSigningKey(appSecretKey)
                        .parseClaimsJws(token).getBody();
                request.setAttribute("claims", claims);
                request.setAttribute("subject", claims.getSubject());
                System.out.println("Claims " + claims);
                System.out.println("Subject " + claims.getSubject());
            } catch (final SignatureException e) {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
                return;
            }
            filterChain.doFilter(httpRequest, httpResponse);
            
        }
    }

    @Override
    public void destroy() {

    }

}

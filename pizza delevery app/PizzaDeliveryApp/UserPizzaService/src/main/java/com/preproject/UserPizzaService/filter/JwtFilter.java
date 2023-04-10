package com.preproject.UserPizzaService.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String authHeader = httpServletRequest.getHeader("authorization");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();

        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            servletOutputStream.print("Invalid or Token Missing");
            servletOutputStream.close();

        } else {
            String token = authHeader.substring(7);
            System.out.println(token);
            Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
            httpServletRequest.setAttribute("claims",claims);
            System.out.println("Claim from token" + claims);

            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
}
}

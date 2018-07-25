package co.borucki.EasyKanbanPortalBackend.security;

import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class CORSFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        if (httpServletRequest.getHeader("Access-Control-Request_Method") != null && "OPTIONS".equals(httpServletRequest.getMethod())) {
            httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH");
            httpServletResponse.addHeader("Access-Control-Allow-Headers", "Content-Type, Content-Disposition, Authorization");
            httpServletResponse.addHeader("Access-Control-Max-Age", "1");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

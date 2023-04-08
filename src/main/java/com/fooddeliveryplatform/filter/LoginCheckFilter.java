package com.fooddeliveryplatform.filter;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.fooddeliveryplatform.result.Result;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;

/**
 * this class uses to check user has already login, if login, then it allow use to
 * get access into index.html and do rest of the operation
 * if user did not have login, just type the url from the browser, then it will let user
 * return back to the login page
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    // 路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    public static final String[] URI = new String[]{
            "/employee/login",
            "/employee/logout",
            "/backend/**",
            "/front/**"
    };
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        log.info("GET THE REQUEST: {}", httpServletRequest.getRequestURI());

        String requestURI = httpServletRequest.getRequestURI();
        if (checkURI(requestURI)){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        if (httpServletRequest.getSession().getAttribute("employee") != null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        log.info("USER DID NOT LOGIN YET ...");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));





//        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


    /**
     * this helper method use to check if the current request should be release or need to check that request
     *
     * @param requestURI a static list of urls, if the request in these url, then release
     * @return boolean, true if match false if not
     */
    private static boolean checkURI(String requestURI){
        for (String url : LoginCheckFilter.URI) {
            if (PATH_MATCHER.match(url, requestURI)) return true;
        }
        return false;
    }

}

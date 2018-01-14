package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hrequest = (HttpServletRequest) req;// 涉及到HTTP请求处理，转型处理
        HttpServletResponse hresponse = (HttpServletResponse) resp;// 涉及到HTTP请求处理，转型处理

        String loginUser = (String) hrequest.getSession().getAttribute("loginUser");// 判断用户是否完成了登录操作，session中是否存储用户名

        if (loginUser == null) {
            hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp?flag=3");// 未登录，系统强制重定向至登录页面
        } else {
            chain.doFilter(hrequest, hresponse);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

}

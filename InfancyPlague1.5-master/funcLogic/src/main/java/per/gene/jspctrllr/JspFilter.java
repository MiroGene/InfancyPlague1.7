package per.gene.jspctrllr;

/**
 * Created by Scarlet on 2017/1/18.
 */
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JspFilter implements Filter {

    public void destroy() {

    }
    /**
     * JSP路径过滤器
     *
     */
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getContextPath();
        String daddyPath = request.getContextPath()+"/"+"daddy";
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

        request.setAttribute("path",path);
        request.setAttribute("daddyPath",daddyPath);
        request.setAttribute("basePath",basePath);

        filterChain.doFilter(request, response);

    }


    public void init(FilterConfig arg0) throws ServletException {

    }

}

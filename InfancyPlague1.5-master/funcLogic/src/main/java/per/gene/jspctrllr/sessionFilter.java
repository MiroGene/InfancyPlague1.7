package per.gene.jspctrllr;

/**
 * Created by Administrator on 2017/1/18.
 */
import per.gene.base.session.userSession;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * JSP过滤器，用于过滤jsp页面，临时使用
 * @author
 *
 */
public class sessionFilter implements Filter {

    public void destroy() {

    }

    /**
     * JSP session过滤器，用于过滤没有登录的页面
     */
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (null == session.getAttribute(userSession.SESSION_USR_INFO)) {
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
            response.sendRedirect(basePath + "parent.jsp");
        }

        filterChain.doFilter(request, response);

    }


    public void init(FilterConfig arg0) throws ServletException {

    }
}

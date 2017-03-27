package per.gene.jspctrllr;

/**
 * Created by Scarlet on 2017/1/18.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 拦截器页面加载拦截器
 *
 * @author YU
 */
public class JspInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = Logger.getLogger(JspInterceptor.class);

    /**
     * 页面请求拦截器
     */
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        loadPath(request);
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 加载路径
     *
     * @param request
     */
    public void loadPath(HttpServletRequest request) {

        String path = request.getContextPath();
        String restPath = request.getContextPath() + "/" + "rest";
        String basePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + request.getContextPath()
                + "/";


        request.setAttribute("path", path);
        request.setAttribute("restPath", restPath);
        request.setAttribute("basePath", basePath);
        request.setAttribute("confPath",basePath+"/jsp/webconf");
    }

}

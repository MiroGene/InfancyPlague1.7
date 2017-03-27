package per.gene.base;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import per.gene.base.exception.ConfException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Scarlet on 2017/1/18.
 */


public class BaseCtrllr {

    private Logger log = Logger.getLogger(this.getClass());

    private String env;

    /**
     * 统一处理业务异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ ConfException.class })
    public String watcherException(HttpServletRequest request, Exception e) {

        request.setAttribute("errorMsg", e.getMessage());

        log.error(e.getMessage(), e);

        loadPath(request);

        return "jsp/webconf/error";
    }

    /**
     * 统一处理系统异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ Exception.class })
    public String exception(HttpServletRequest request, Exception e) {

        request.setAttribute("errorMsg", "系统异常");

        log.error("系统异常：" + e.getMessage(), e);

        loadPath(request);

        return "jsp/webconf/error";
    }

    /**
     * 加载路径
     *
     * @param request
     */
    public void loadPath(HttpServletRequest request) {

        String path = request.getContextPath();
        System.out.println(path);
        String restPath = request.getContextPath() + "/" + "daddy";
        String basePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + request.getContextPath()
                + "/";


        request.setAttribute("path", path);
        request.setAttribute("restPath", restPath);
        request.setAttribute("basePath", basePath);
        request.setAttribute("confPath",basePath+"/jsp/webconf");

    }

}
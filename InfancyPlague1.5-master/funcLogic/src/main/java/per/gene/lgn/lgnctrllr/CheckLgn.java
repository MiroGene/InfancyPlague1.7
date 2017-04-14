package per.gene.lgn.lgnctrllr;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import per.gene.base.BaseCtrllr;
import per.gene.base.BaseDao;
import per.gene.base.exception.ConfException;
import per.gene.base.session.userSession;
import per.gene.lgn.lgnsrvc.LoginService;
import per.gene.lgn.vo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Scarlet on 2017/1/18.
 */
@Controller
@RequestMapping("/Lgn")
public class CheckLgn extends BaseCtrllr{
    private Logger log = Logger.getLogger(CheckLgn.class);//@会输出在哪里，控制台？
    @Autowired
    private LoginService loginService;

    private BaseDao b=new BaseDao();
    public CheckLgn(){}

    //private service
    @RequestMapping("/checkUsr")
    public String checkUsr(HttpServletRequest request){
        String usrNme = request.getParameter("usrNme");
        String usrPwd = request.getParameter("usrPwd");
        Map<String,String> map = new HashMap<String, String>();
        map.put("userName",usrNme);
        map.put("userPassword",usrPwd);
       // b.getConn("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/test_module","Gene","a");
/*
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("aaaaaaaaaaaaaaaaaa");
        }*/
        UserInfo usr = loginService.checkLogin(map);
        if (usr==null){
            throw new ConfException("未查到此用户");

            //return "";
        }
        else if(usr!=null){

            request.getSession().setAttribute(userSession.SESSION_USR_INFO,usr);
            //response.sendRedirect(contextPath+"/jsp/webconf/index.jsp");
            //function
            request.setAttribute("name",usr.getUserName());
            request.setAttribute("password",usr.getUserPassword());
            request.setAttribute("userId",usr.getUserId());


            //跳转到个人页面
            return "/jsp/index";
        }

        return "a";
        /*request.setAttribute("name",usr.getUsrNme());
        request.setAttribute("password",usr.getUsrPwd());

        String contextPath = request.getContextPath();*/
        //UserInfo user = userService.login(userName, password);

    }
    /**
     * 登出

     */
    @RequestMapping(value="/lgnOut")
    public void logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //登录后存入此类中。
        // request.getSession().removeAttribute(Plague.SESSION_USR_INFO);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/jsp/webconf/index.jsp");
    }



}


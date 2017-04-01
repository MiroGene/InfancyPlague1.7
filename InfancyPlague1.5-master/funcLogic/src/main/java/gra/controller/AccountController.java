package gra.controller;

import gra.service.AccountService;
import gra.vo.AccountVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import per.gene.base.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Gene on 2017/3/27.
 */
@Controller
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    private Logger log = Logger.getLogger(AccountController.class);


    public String beforeQueryAccountPage(){

        return "";
    }
    /**
     * 分页查询账单列表
     * @return
     */
    @RequestMapping("/selectAccountPage")
    public String accountListPage(HttpServletRequest request){
        List<AccountVo> accountVoList = new ArrayList<AccountVo>();
        //查询方式 1、日期 2、名字 3、标题
        String date = request.getParameter("date");
        String userName = request.getParameter("userName");
        String title = request.getParameter("title");
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isEmpty(date)){
            map.put("date",date);
        }
        if (StringUtils.isEmpty(userName)){
            map.put("userName",userName);
        }
        if (StringUtils.isEmpty(title)){
            map.put("title",title);
        }
        //取得查询结果
        accountVoList = accountService.queryAccountList(map);
        //返回页面
        request.setAttribute("accountVoList",accountVoList);

        return "";
    }
    /**
     * 创建新账单
     */
    @RequestMapping("/addAccount")
    public String addAccount(HttpServletRequest request){
        /* TODO */
        AccountVo account = new AccountVo();
        String userId = UUID.randomUUID().toString();
        //设置ID
        account.setId(userId);
        //设置用户名
        if(StringUtils.isEmpty(request.getParameter("userName"))){
            account.setUserName(request.getParameter("userName"));
        }
        //设置主题
        if(StringUtils.isEmpty(request.getParameter("title"))){
            account.setTitle(request.getParameter("title"));
        }
        //设置金额
        if(StringUtils.isEmpty(request.getParameter("money"))){
            account.setMoney(request.getParameter("money"));
        }
        //设置日期
        if(StringUtils.isEmpty(request.getParameter("date"))){
            account.setDate(request.getParameter("date"));
        }
        //设置详细内容
        if(StringUtils.isEmpty(request.getParameter("detail"))){
            account.setDetail(request.getParameter("detail"));
        }
        //设置收据公司
        if(StringUtils.isEmpty(request.getParameter("company"))){
            account.setCompany(request.getParameter("company"));
        }
        //设置状态
        if(StringUtils.isEmpty(request.getParameter("states"))){
            account.setStates(request.getParameter("states"));
        }
        //TODO
        //accountService

        return "main.jsp";
    }
}

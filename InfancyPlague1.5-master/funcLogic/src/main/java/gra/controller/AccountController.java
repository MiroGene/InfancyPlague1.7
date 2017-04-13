package gra.controller;

import gra.service.AccountService;
import gra.vo.AccountSelectVar;
import gra.vo.AccountVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import per.gene.base.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
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
        String pageIndexStr = request.getParameter("pageIndex");
        if (pageIndexStr==null){
            pageIndexStr="0";
        }
        Integer pageIndex = Integer.parseInt(pageIndexStr);
        int start = pageIndex*10;
        List<AccountVo> accountVoList = new ArrayList<AccountVo>();
        //查询方式 1、日期 2、名字 3、标题
        String date = request.getParameter("searchDate");
        String userName = request.getParameter("searchUserName");
        String title = request.getParameter("searchTitle");
        String operator = request.getParameter("searchOperator");
        AccountSelectVar accounntSelectVar = new AccountSelectVar();
        if (!StringUtils.isEmpty(date)){
            accounntSelectVar.setDate(date);
        }
        if (!StringUtils.isEmpty(userName)){
            accounntSelectVar.setUserName(userName);
        }
        if (!StringUtils.isEmpty(title)){
            accounntSelectVar.setTitle(title);
        }
        if (!StringUtils.isEmpty(operator)){
            accounntSelectVar.setOperator(operator);
        }
        //map.put("",start);
        //取得查询结果
        accountVoList = accountService.queryAccountList(accounntSelectVar);
        for (AccountVo accountVo:
                accountVoList) {
            accountVo.changeStates();
        }
        //返回页面
        request.setAttribute("accountVoList",accountVoList);

        return "/jsp/account_list";
    }
    /**
     * 创建新账单
     */
    @RequestMapping("/insertAccount")
    public String addAccount(HttpServletRequest request){

        AccountVo account = new AccountVo();
        String userId = UUID.randomUUID().toString();
        //设置ID
        account.setAccountId(userId);
        //TODO 设置用户名 从session中获取用户名
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String strDate = sdf.format(new Date());
        account.setAccountDate(request.getParameter("date"));

        //设置详细内容
        if(StringUtils.isEmpty(request.getParameter("detail"))){
            account.setDetail(request.getParameter("detail"));
        }
        //设置收据公司
        if(StringUtils.isEmpty(request.getParameter("company"))){
            account.setCompany(request.getParameter("company"));
        }
        //设置状态
        account.setStates("0");

        accountService.insertAccount(account);

        return "main.jsp";
    }

    public String delectAccount(HttpServletRequest request){
        //TODO 如何传输list？

        //返回主页面
        return null;
    }
}

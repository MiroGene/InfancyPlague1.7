package com.controller;

import com.service.AccountService;
import com.vo.AccountSelectVar;
import com.vo.AccountVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import per.gene.base.session.OperatorSession;
import per.gene.base.session.userSession;
import per.gene.base.utils.StringUtils;
import per.gene.lgn.vo.UserInfo;

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
        //审核改成搜索userId
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute(userSession.SESSION_USR_INFO);
        String userId = userInfo.getUserId();
        String title = request.getParameter("searchTitle");
        String operator = request.getParameter("searchOperator");
        AccountSelectVar accounntSelectVar = new AccountSelectVar();
        if (!StringUtils.isEmpty(date)){
            accounntSelectVar.setDate(date);
        }
        if (!StringUtils.isEmpty(userId)){
            accounntSelectVar.setUserId(userId);
        }
        if (!StringUtils.isEmpty(title)){
            accounntSelectVar.setTitle(title);
        }
        if (!StringUtils.isEmpty(operator)){
            accounntSelectVar.setOperatorName(operator);
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
        request.setAttribute("user",userInfo);
        request.setAttribute("userId",userInfo.getUserId());

        AccountVo a = new AccountVo();
        List<AccountVo> list = new ArrayList<AccountVo>();
        list.add(a);
       // accountService.delectAccountList(list);


        return "/jsp/account_list";
    }
    /**
     * 创建新账单
     */
    @RequestMapping("/insertAccount")
    public String addAccount(HttpServletRequest request){

        AccountVo account = new AccountVo();
        String accountId = UUID.randomUUID().toString();
        //设置ID
        account.setAccountId(accountId);
        //TODO 设置用户名 从session中获取用户名
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(userSession.SESSION_USR_INFO);
        String userId1=request.getParameter("userId");
        String userId2 = request.getParameter("accountUser");
        if(!StringUtils.isEmpty(request.getParameter("userName"))){
            account.setUserName(request.getParameter("userName"));
        }
        if(!StringUtils.isEmpty(request.getParameter("userId"))){
            account.setAccountUser(request.getParameter("userId"));
        }
        if(!StringUtils.isEmpty(request.getParameter("accountUser"))){
            account.setAccountUser(request.getParameter("accountUser"));
        }
        if(!StringUtils.isEmpty(request.getParameter("states"))){
            account.setStates(request.getParameter("states"));
        }
        //设置主题
        if(!StringUtils.isEmpty(request.getParameter("accountTitle"))){
            account.setTitle(request.getParameter("accountTitle"));
        }
        //设置金额
        if(!StringUtils.isEmpty(request.getParameter("money"))){
            account.setMoney(request.getParameter("money"));
        }
       // account.setAccountUser(userInfo.getUserId());
        //设置日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String strDate = sdf.format(new Date());
        account.setAccountDate(strDate);

        //设置详细内容
        if(!StringUtils.isEmpty(request.getParameter("detail"))){
            account.setDetail(request.getParameter("detail"));
        }
        //设置收据公司
        if(StringUtils.isEmpty(request.getParameter("company"))){
            account.setCompany(request.getParameter("company"));
        }
        //设置状态
        //account.setStates("1");

        accountService.insertAccount(account);

        return accountListPage(request);
    }
    @RequestMapping("/updateAccount")
    public String updateAccount(HttpServletRequest request){
        AccountVo accountVo = new AccountVo();
        accountVo.setAccountId(request.getParameter("accountId"));
        //
        if (!StringUtils.isEmpty(request.getParameter("title"))){
            accountVo.setTitle(request.getParameter("accountId"));
        }
        if (!StringUtils.isEmpty(request.getParameter("operatorName"))){
            accountVo.setOperatorName(request.getParameter("operatorName"));
        }
        if (!StringUtils.isEmpty(request.getParameter("userName"))){
            accountVo.setUserName(request.getParameter("userName"));
        }
        if (!StringUtils.isEmpty(request.getParameter("accountDate"))){
            accountVo.setAccountDate(request.getParameter("accountDate"));
        }
        if (!StringUtils.isEmpty(request.getParameter("accountOperator"))){
            accountVo.setAccountOperator(request.getParameter("accountOperator"));
        }
        if (!StringUtils.isEmpty(request.getParameter("accountUser"))){
            accountVo.setAccountUser(request.getParameter("accountUser"));
        }
        if (!StringUtils.isEmpty(request.getParameter("company"))){
            accountVo.setCompany(request.getParameter("company"));
        }
        if (!StringUtils.isEmpty(request.getParameter("detail"))){
            accountVo.setDetail(request.getParameter("detail"));
        }
        if (!StringUtils.isEmpty(request.getParameter("money"))){
            accountVo.setMoney(request.getParameter("money"));
        }
        if (!StringUtils.isEmpty(request.getParameter("states"))){
            accountVo.setStates(request.getParameter("states"));
        }
        AccountVo accountVo1 = new AccountVo();
        accountVo1.setAccountId("aaa");
        accountVo1.setTitle("bbb");
        accountService.updateAccount(accountVo1);

        return accountListPage(request);
    }

    @RequestMapping("/deleteAccount")
    public String delectAccount(HttpServletRequest request){
        //TODO 如何传输list？
        String[] delAccountId = (String[])request.getParameterValues("delAccountId");
        String[] delCheckBox = (String[])request.getParameterValues("delCheckBox");
        //System.out.println(delAccountId[1]);
//        System.out.println(delCheckBox[1]);
        //返回主页面
        return null;
    }

    /**
     * 查看详细信息
     * @param request
     * @return
     */
    @RequestMapping("/detailAccount")
    public String detailAccount(HttpServletRequest request){
        String accountId = request.getParameter("accountId");
        AccountVo accountVo = accountService.detailAccount(accountId);
        request.setAttribute("account",accountVo);
        if (request.getSession().getAttribute(userSession.SESSION_USR_INFO)!=null){
            return "/jsp/account_info";
        }else if (request.getSession().getAttribute(OperatorSession.OPERATOR_INFO_SESSION)!=null){
            return "/jsp/account_check";
        }


        return "/jsp/account_";
    }

    @RequestMapping("/beforeInsert")
    public String beforeInsert(HttpServletRequest request){
        String userId = request.getParameter("userId");
        request.setAttribute("userId",userId);
        return "/jsp/account_insert";
    }
}

package com.vo;

/**
 * Created by Gene on 2017/3/27.
 * 账单的实体类
 */
public class AccountVo {
    private String accountId;
    private String title;
    private String accountUser;
    private String money;
    private String accountDate;
    private String detail;
    private String company;
    private String states;
    private String accountOperator;
    private String operatorName;
    private String userName;

    /**
     * 失败原因
     */
    private String result;

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    public String getAccountOperator() {
        return accountOperator;
    }

    public void setAccountOperator(String accountOperator) {
        this.accountOperator = accountOperator;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public void changeStates(){
        if(states==null){
            return;
        }
        if(states.equals("1")){
            setStates("审核中……");
        }else if (states.equals("2")){
            setStates("审核成功");
        }else if (states.equals("3")){
            setStates("审核失败");
        }
    }
    public void changeStatesToFlag(){
        if(states==null){
            return;
        }
        if(states.equals("审核中……")){
            setStates("1");
        }else if (states.equals("审核成功")){
            setStates("2");
        }else if (states.equals("审核失败")){
            setStates("3");
        }
    }
}

package gra.vo;

/**
 * Created by Administrator on 2017/4/12.
 */
public class AccountSelectVar {
    private int page;
    private int start;
    private int end;
    private String userId;//用户ID
    private String date;
    private String operatorName;//操作员姓名
    private String money;
    private String title;
    private String accountId;

    public String getAccountId() {
        return accountId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getEnd() {
        end = start+10;
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {
        start = page*10;
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

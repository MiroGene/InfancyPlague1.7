package per.gene.lgn.vo;

/**
 * Created by Scarlet on 2017/1/18.
 */
public class UserInfo {
    /**
     * id
     */
    private String userId;
    /**
     *注册码
     */
    private String regCode;
    /**
     *本次昵称
     */
    //private String tempName;
    /**
     *用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     *项目
     */
    private String Projects;
    /**
     *等级
     */
    private String Rank;
    /**
     *是否为管理者
     */
    private String Manager;
    /**
     *是否为顾问
     */
    private String Advisor;
    /**
     *目标
     */
    private String Wish;
    /**
     *好友
     */
    private String Partners;
    /**
     *职业
     */
    private String Career;

    /**
     * 金币
     */
    //private Integer gold;
    /**
     * Money
     */
    //private Integer RMB;

    /**
     * 未读消息数量(未读消息，待审核)
     */
    private Integer msgCount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getProjects() {
        return Projects;
    }

    public void setProjects(String projects) {
        Projects = projects;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public String getAdvisor() {
        return Advisor;
    }

    public void setAdvisor(String advisor) {
        Advisor = advisor;
    }

    public String getWish() {
        return Wish;
    }

    public void setWish(String wish) {
        Wish = wish;
    }

    public String getPartners() {
        return Partners;
    }

    public void setPartners(String partners) {
        Partners = partners;
    }

    public String getCareer() {
        return Career;
    }

    public void setCareer(String career) {
        Career = career;
    }


    public Integer getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
    }
}

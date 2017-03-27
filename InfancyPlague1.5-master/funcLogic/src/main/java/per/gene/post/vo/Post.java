package per.gene.post.vo;

/**
 * Created by Scarlet on 2017/2/6.
 * Post实体类
 */
public class Post {

    /**
     * Creator
     */
    private String userName;

    /**
     * replies
     */
    private String replies;

    /**
     * title
     */
    private String title;

    /**
     * title好友
     */
    private String content;

    /**
     * rank
     */
    private String rank;

    /**
     * 允许查看用户列表 存放userId
     */
    private String[] allowBrowserUser;

    /**
     * 允许回复用户列表 存放userId
     */
    private String[] allowReplyUser;

    public String[] getAllowBrowserUser() {
        return allowBrowserUser;
    }

    public void setAllowBrowserUser(String[] allowBrowserUser) {
        this.allowBrowserUser = allowBrowserUser;
    }

    public String[] getAllowReplyUser() {
        return allowReplyUser;
    }

    public void setAllowReplyUser(String[] allowReplyUser) {
        this.allowReplyUser = allowReplyUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReplies() {
        return replies;
    }

    public void setReplies(String replies) {
        this.replies = replies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}

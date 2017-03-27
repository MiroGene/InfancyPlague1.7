package per.gene.lgn.vo;

/**
 * Created by Administrator on 2017/2/7.
 */
public class Message {
    /**
     * 回复提醒
     */
    private static String PLAGUE_MESSAGE_REPLY = "PLAGUE_MESSAGE_REPLY";

    /**
     * 好友信息
     */
    private static String PLAGUE_MESSAGE_PARTNER = "PLAGUE_MESSAGE_PARTNER";

    /**
     * 其他用户申请
     */
    private static String PLAGUE_MESSAGE_APPLICATION = "PLAGUE_MESSAGE_APPLICATION";

    /**
     * 关注新闻
     */
    private static String PLAGUE_MESSAGE_NEWS = "PLAGUE_MESSAGE_NEWS";

    /**
     * 信息种类
     */
    private String[] kind = {
            PLAGUE_MESSAGE_NEWS,
            PLAGUE_MESSAGE_REPLY,
            PLAGUE_MESSAGE_PARTNER,
            PLAGUE_MESSAGE_APPLICATION
    };
}

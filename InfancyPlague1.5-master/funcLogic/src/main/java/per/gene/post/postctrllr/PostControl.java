package per.gene.post.postctrllr;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import per.gene.base.BaseCtrllr;
import per.gene.base.exception.ConfException;
import per.gene.base.utils.StringUtils;
import per.gene.lgn.lgnctrllr.CheckLgn;
import per.gene.post.vo.Post;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/2/7.
 */
@Controller
@RequestMapping("/Post")
public class PostControl extends BaseCtrllr{
    private Logger log = Logger.getLogger(CheckLgn.class);
    //@Autowired


    public String insertPost(HttpServletRequest request){
        Post post = new Post();
        String title = request.getParameter("title");
        String userName = request.getParameter("userName");
        String replies = request.getParameter("replies");
        String content = request.getParameter("content");
        String rank = request.getParameter("rank");

        if (StringUtils.isEmpty(title)) {
            throw new ConfException("title is empty");
        }
        post.setTitle(title);
        if (StringUtils.isEmpty(userName)) {
            throw new ConfException("userName is empty");
        }
        post.setUserName(userName);
        if (StringUtils.isEmpty(replies)) {
            throw new ConfException("replies is empty");
        }
        post.setReplies(replies);
        if (StringUtils.isEmpty(content)) {
            throw new ConfException("content is empty");
        }
        post.setContent(content);
        if (StringUtils.isEmpty(rank)) {
            throw new ConfException("rank is empty");
        }
        post.setRank(rank);
        //insert
        return "";
    }
}

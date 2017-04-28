import org.junit.Test;
import per.gene.lgn.vo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/26.
 */
public class TestLogin extends TestController{
    @Test
    public void checkLogin(){
        UserInfo userInfo = new UserInfo();
        Map<String ,String> map = new HashMap<String,String>();
        map.put("name","aaa");
        map.put("password","aaa");
        HttpServletRequest request = null;
        request.setAttribute("name","aaa");
        request.setAttribute("password","aaa");

        controller.checkUsr(request);
    }
}

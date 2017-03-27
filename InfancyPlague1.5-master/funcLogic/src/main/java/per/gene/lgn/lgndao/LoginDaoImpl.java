package per.gene.lgn.lgndao;

import org.springframework.stereotype.Service;
import per.gene.base.BaseDaoForIbatis;
import per.gene.lgn.vo.UserInfo;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/19.
 */
@Service
public class LoginDaoImpl extends BaseDaoForIbatis implements LoginDao {
    public boolean checkLogin(Map<String, String> map) {
        UserInfo usr = (UserInfo) this.queryForObject("User.login", map);
        if (usr == null) {
            return false;
        }
        return true;
    }
}

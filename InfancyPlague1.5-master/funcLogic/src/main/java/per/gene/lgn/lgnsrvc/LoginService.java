package per.gene.lgn.lgnsrvc;

import per.gene.lgn.vo.UserInfo;

import java.util.Map;

/**
 * Created by Scarlet on 2017/1/19.
 */
public interface LoginService {

    public UserInfo checkLogin(Map<String,String> map);
}

package gra.service.serviceimpl;

import gra.dao.AccountDao;
import gra.service.AccountService;
import gra.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Gene on 2017/3/27.
 */
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;


    public List<AccountVo> queryAccountList(Map map) {
        return null;
    }

    public int getAccountCount(Map map) {
        return 0;
    }

    public boolean insertAccount() {
        return false;
    }

    public boolean updateAccount() {
        return false;
    }

    public boolean delectAccount() {
        return false;
    }
}

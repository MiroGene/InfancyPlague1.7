package com.service.serviceimpl;

import com.dao.AccountDao;
import com.service.AccountService;
import com.vo.AccountSelectVar;
import com.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Gene on 2017/3/27.
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;


    public List<AccountVo> queryAccountList(AccountSelectVar accounntSelectVar) {
        return accountDao.pageAccount(accounntSelectVar);
    }

    public int getAccountCount(Map map) {
        return 0;
    }

    public AccountVo insertAccount(AccountVo accountVo) {
        return accountDao.insert(accountVo);
    }

    public int updateAccount(AccountVo accountVo) {
        return accountDao.update(accountVo);
    }

    public int delectAccount(Map<String,String> map) {
        return accountDao.delectAccount(map);
    }
}

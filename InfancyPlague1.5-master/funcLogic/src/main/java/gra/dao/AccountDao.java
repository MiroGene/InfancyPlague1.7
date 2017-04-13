package gra.dao;

import gra.vo.AccountSelectVar;
import gra.vo.AccountVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/27.
 */
public interface AccountDao {
    /**
     * 分页查询，条件分页查询
     * @param accounntSelectVar
     * @return
     */
    public List<AccountVo> pageAccount(AccountSelectVar accounntSelectVar);

    public AccountVo insert(AccountVo accountVo);

    public int update(AccountVo accountVo);

    public int delectAccount(Map<String,String> map);
    /**
     * 账单总数
     * @return
     */
    public int getAccountCount(Map<String,String> map);
}

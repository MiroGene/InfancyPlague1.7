package gra.service;

import gra.vo.AccountVo;
import org.apache.shiro.authc.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/27.
 */
public interface AccountService {
    /**
     * 分页查询
     * map中为查询条件
     * @return
     */
    public List<AccountVo> queryAccountList(Map map);
    /**
     * 账单总数
     * @return
     */
    public int getAccountCount(Map map);
    /**
     * 新建账单
     * @return
     */
    public boolean insertAccount();
    /**
     * 修改账单
     * @return
     */
    public boolean updateAccount();
    /**
     * 删除账单
     * @return
     */
    public boolean delectAccount();
}

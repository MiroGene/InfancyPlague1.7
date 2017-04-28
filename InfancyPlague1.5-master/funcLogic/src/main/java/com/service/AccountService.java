package com.service;

import com.vo.AccountSelectVar;
import com.vo.AccountVo;

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
    public List<AccountVo> queryAccountList(AccountSelectVar accounntSelectVar);
    /**
     * 账单总数
     * @return
     */
    public int getAccountCount(Map<String,String> map);
    /**
     * 新建账单
     * @return
     */
    public AccountVo insertAccount(AccountVo accountVo);
    /**
     * 修改账单
     * @return
     */
    public int updateAccount(AccountVo accountVo);
    /**
     * 删除账单
     * @return
     */
    public int delectAccount(Map<String,String> map);

    public int delectAccountList(List<AccountVo> list);

    /**
     * 查找详细信息
     */
    public AccountVo detailAccount(String accountId);
}

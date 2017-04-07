package gra.dao.daoimpl;

import gra.dao.AccountDao;
import gra.vo.AccountVo;
import per.gene.base.BaseDao;
import per.gene.base.BaseDaoForIbatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/27.
 */
public class AccountDaoImpl extends BaseDaoForIbatis implements AccountDao {

    /**
     * 查询分页结果
     * @param map
     * @return
     */
    public List<AccountVo> pageAccount(Map<String,String> map) {  //页码，日期搜索，用户名搜索，
        if (map.isEmpty()){
            throw new RuntimeException("");
        }
        List<AccountVo> accounts = new ArrayList<AccountVo>();
        accounts = (List<AccountVo>)this.queryForObject("pageAccount",map);
        return accounts;
    }

    /**
     * c插入
     * @param accountVo
     * @return
     */
    public AccountVo insert(AccountVo accountVo) {
        this.insert("insertAccount",accountVo);
        return accountVo;
    }

    /**
     * 改
     * @param accountVo
     * @return
     */
    public int update(AccountVo accountVo) {
        int i = this.update("updateAccount",accountVo);
        return i;
    }

    /**
     * 删除
     * @param map
     * @return
     */
    public int delectAccount(Map<String,String> map) {
        int i = this.delete("delectAccount",map);
        return i;
    }

    /**
     * 总数
     * @param map
     * @return
     */
    public int getAccountCount(Map<String, String> map) {
        int i = (Integer) this.queryForObject("countAccount",map);
        return 0;
    }
}

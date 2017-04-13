package gra.dao.daoimpl;

import gra.dao.AccountDao;
import gra.vo.AccountSelectVar;
import gra.vo.AccountVo;
import org.springframework.stereotype.Service;
import per.gene.base.BaseDao;
import per.gene.base.BaseDaoForIbatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/27.
 */
@Service
public class AccountDaoImpl extends BaseDaoForIbatis implements AccountDao {

    /**
     * 查询分页结果
     * @param accounntSelectVar
     * @return
     */
    public List<AccountVo> pageAccount(AccountSelectVar accounntSelectVar) {  //页码，日期搜索，用户名搜索，
        if (accounntSelectVar==null){
            //throw new RuntimeException("");
        }
        accounntSelectVar.getStart();
        accounntSelectVar.getEnd();


        List<AccountVo> accounts = new ArrayList<AccountVo>();
        accounts = this.queryForList("Account.pageAccount",accounntSelectVar);
        return accounts;
    }

    /**
     * c插入
     * @param accountVo
     * @return
     */
    public AccountVo insert(AccountVo accountVo) {
        this.insert("Account.insertAccount",accountVo);
        return accountVo;
    }

    /**
     * 改
     * @param accountVo
     * @return
     */
    public int update(AccountVo accountVo) {
        int i = this.update("Account.updateAccount",accountVo);
        return i;
    }

    /**
     * 删除
     * @param map
     * @return
     */
    public int delectAccount(Map<String,String> map) {
        int i = this.delete("Account.delectAccount",map);
        return i;
    }

    /**
     * 总数
     * @param map
     * @return
     */
    public int getAccountCount(Map<String, String> map) {
        int i = (Integer) this.queryForObject("Account.countAccount",map);
        return 0;
    }
}

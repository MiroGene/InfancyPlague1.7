package per.gene.base;

/**
 * Created by Scarlet on 2017/1/18.
 */
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.event.RowHandler;
import per.gene.base.exception.BaseDaoException;

/**
 * itatis框架dao的基类，主要用于处理所有业务都需要的操作
 * （增删改查），如果有的业务需要扩展dao操作，那么请在自己业务的dao方法
 * 里进行增加，不要更改此类，如果此方法是所有业务都需要的请增加到
 * 此类中进行共用
 *
 * @author Administrator
 */
public class BaseDaoForIbatis<T> {

    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private SqlMapClient sqlMap;

    /**
     * 分页查询
     * @param statementName
     * @param parameterMap
     * @param page
     * @throws Exception
     * @throws Exception
     */
//	public PageUtil<T> queryForPage(String statementName, Map parameterMap, int pageIndex){
//		try {
//			PageUtil<T> page=new PageUtil<T>();
//			page.setPageIndex(pageIndex);
//			if (parameterMap != null) {
//				if (page.getCount() == 0) {
//					int totalRows = ((Integer) this.sqlMap.queryForObject(
//							statementName + "Count", parameterMap)).intValue();
//					page.setCount(totalRows);
//				}
//				parameterMap.put("beginRow", page.getStartNum());
//				parameterMap.put("endRow", page.getEndNum());
//				List data = this.sqlMap.queryForList(statementName,parameterMap);
//				page.setData(data);
//			}
//			return page;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//
//			throw new BaseDaoException(e);
//		}
//	}

    /**
     * 分页查询 可设置pageSize
     * @param statementName
     * @param parameterMap
     * @param pageIndex
     * @param pageSize
     * @return
     */
    /**
     * @param arg0
     * @return
     */
//	public PageUtil<T> queryForPage(String statementName, Map parameterMap, int pageIndex,int pageSize){
//		try {
//			PageUtil<T> page=new PageUtil<T>(pageSize);
//			page.setPageIndex(pageIndex);
//			if (parameterMap != null) {
//				if (page.getCount() == 0) {
//					int totalRows = ((Integer) this.sqlMap.queryForObject(
//							statementName + "Count", parameterMap)).intValue();
//					page.setCount(totalRows);
//				}
//				parameterMap.put("beginRow", page.getStartNum());
//				parameterMap.put("endRow", page.getEndNum());
//				List data = this.sqlMap.queryForList(statementName,parameterMap);
//				page.setData(data);
//			}
//			return page;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//
//			throw new BaseDaoException(e);
//		}
//	}
    public int delete(String arg0) {
        try {
            return sqlMap.delete(arg0);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public int delete(String arg0, Object arg1) {
        try {
            return sqlMap.delete(arg0, arg1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public int executeBatch() {
        try {
            return sqlMap.executeBatch();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }

    }

    public List executeBatchDetailed() {
        try {
            return sqlMap.executeBatchDetailed();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public Object insert(String arg0) {
        Object obj = null;
        try {
            obj = sqlMap.insert(arg0);
        } catch (Exception err) {
            log.error(err.getMessage(), err);
            throw new BaseDaoException(err);
        }
        return obj;
    }

    public Object insert(String arg0, Object arg1) {
        Object obj = null;
        try {
            obj = sqlMap.insert(arg0, arg1);
        } catch (Exception err) {
            log.error(err.getMessage(), err);
            throw new BaseDaoException(err);
        }
        return obj;
    }

    public List queryForList(String arg0) {
        try {
            return sqlMap.queryForList(arg0);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }

    }

    public List<T> queryForList(String arg0, Object arg1) {
        try {
            return sqlMap.queryForList(arg0, arg1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public List queryForList(String arg0, int arg1, int arg2) {
        try {
            return sqlMap.queryForList(arg0, arg1, arg2);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public List queryForList(String arg0, Object arg1, int arg2, int arg3) {
        try {
            return sqlMap.queryForList(arg0, arg1, arg2, arg3);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public Map queryForMap(String arg0, Object arg1, String arg2) {
        try {
            return sqlMap.queryForMap(arg0, arg1, arg2);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public Map queryForMap(String arg0, Object arg1, String arg2, String arg3) {
        try {
            return sqlMap.queryForMap(arg0, arg1, arg2, arg3);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public Object queryForObject(String arg0) {
        try {
            return sqlMap.queryForObject(arg0);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public Object queryForObject(String arg0, Object arg1) {
        try {
            return sqlMap.queryForObject(arg0, arg1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public Object queryForObject(String arg0, Object arg1, Object arg2) {
        try {
            return sqlMap.queryForObject(arg0, arg1, arg2);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }


    public void queryWithRowHandler(String arg0, RowHandler arg1) {
        try {
            sqlMap.queryWithRowHandler(arg0, arg1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public void queryWithRowHandler(String arg0, Object arg1, RowHandler arg2) {
        try {

            sqlMap.queryWithRowHandler(arg0, arg1, arg2);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public void startBatch() {
        try {
            sqlMap.startBatch();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public int update(String arg0) {
        try {
            return sqlMap.update(arg0);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }

    public int update(String arg0, Object arg1) {
        try {
            return sqlMap.update(arg0, arg1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BaseDaoException(e);
        }
    }
}

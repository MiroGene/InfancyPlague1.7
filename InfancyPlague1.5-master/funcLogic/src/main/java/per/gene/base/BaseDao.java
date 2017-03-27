package per.gene.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import per.gene.base.exception.ConfException;

public class BaseDao {
	private static Logger log = Logger.getLogger(BaseDao.class);

	protected Connection conn = null;

	protected PreparedStatement ps = null;

	protected ResultSet rs = null;


//	public BaseDao(String env) {
//
//		Properties prop = Env.getEnv(env);
//
//		if (prop == null) {
//			throw new ConfigsException("#获取环境变量为空", log);
//		}
//		String driver = prop.getProperty("jdbc.driver");
//		if (StringUtil.isEmpty(driver)) {
//			throw new ConfigsException("#获取环境变量{jdbc.driver}为空", log);
//		}
//		String url = prop.getProperty("jdbc.url");
//		if (StringUtil.isEmpty(url)) {
//			throw new ConfigsException("#获取环境变量{jdbc.url}为空", log);
//		}
//		String user = prop.getProperty("jdbc.user");
//		if (StringUtil.isEmpty(user)) {
//			throw new ConfigsException("#获取环境变量{jdbc.user}为空", log);
//		}
//
//		String password = prop.getProperty("jdbc.password");
//		if (StringUtil.isEmpty(password)) {
//			throw new ConfigsException("#获取环境变量{jdbc.password}为空", log);
//		}
//
//		this.getConn(driver, url, user, password);
//	}

	/**
	 * 链接数据库
	 * 
	 * @param driver
	 * @param url
	 * @param user
	 * @param pass
	 */
	public void getConn(String driver, String url, String user, String pass) {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			log.info("driver:" + driver + ",url:" + url);
			throw new ConfException("数据库连接异常",e);
		} catch (SQLException e) {
			log.info("driver:" + driver + ",url:" + url);
			throw new ConfException("数据库连接异常",e);
		}

	}

	/**
	 * 关闭数据库连接
	 */
	protected void closeAll() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.error("关闭结果集异常");
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				log.error("关闭预处理对象异常");
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("关闭数据库连接异常");
			}
		}

	}
}

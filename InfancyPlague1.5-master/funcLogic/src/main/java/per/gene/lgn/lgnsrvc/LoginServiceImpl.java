package per.gene.lgn.lgnsrvc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.gene.base.BaseDaoForIbatis;
import per.gene.base.exception.ConfException;
import per.gene.lgn.lgndao.LoginDao;
import per.gene.lgn.vo.UserInfo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Scarlet on 2017/1/19.
 */
@Service
public class LoginServiceImpl extends BaseDaoForIbatis implements LoginService{
    @Autowired
    private LoginDao loginDao;
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public UserInfo checkLogin(Map<String, String> map) {

/*        try
        {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/mydatabase1";
            String dbUser = "mengdd";
            String dbPwd = "881103";
            // 打开数据库连接
            con = DriverManager.getConnection(dbUrl, dbUser, dbPwd);

        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error: unable to load driver class!");
            System.out
                    .println("please check if you hava the mysql-connector jar file in your lib dir!");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }*/



    UserInfo usr = (UserInfo)this.queryForObject("User.login",map);
        if (usr==null){
            throw new ConfException("not Found User!!");
        }
        return usr;
    }
}

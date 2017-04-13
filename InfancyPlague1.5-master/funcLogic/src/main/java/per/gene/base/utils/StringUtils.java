package per.gene.base.utils;

import per.gene.base.exception.ConfException;

/**
 * Created by Administrator on 2017/2/7.
 */
public class StringUtils {

    public static boolean isEmpty(String str){
        if(str==null){
            return true;
        }else if (str.equals("")){
            return true;
        }
        else return false;
    }
}

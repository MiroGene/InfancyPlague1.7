package per.gene;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/18.
 */
public class A {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        //String str="11111111111";
        //String str="2222222222222222";
        String str="333333333333";
        if(str.length()==11){
            map.put("十一",str);
        }else if(str.length()==16){
            map.put("十六",str);
        }
        System.out.println(str.length());
        if (!map.isEmpty()){
            System.out.println("111111111111111111111111111");
        }
    }

}






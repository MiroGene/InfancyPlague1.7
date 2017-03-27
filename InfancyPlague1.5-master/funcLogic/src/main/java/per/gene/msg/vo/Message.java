package per.gene.msg.vo;

/**
 * Created by Scarlet on 2017/2/8.
 * 未读信息
 */
public abstract class Message {
    protected int count=0;

    /**
     * 计算消息条数
     * @param str
     */
    public void calcCount(String[] str){
        for (String a:str
             ) {
            count++;
        }
        
    }
    
    public int getCount(){
        return count;
    }

    //public

}

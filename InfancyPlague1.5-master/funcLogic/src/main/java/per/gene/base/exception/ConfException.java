package per.gene.base.exception;

/**
 * Created by Scarlet on 2017/1/18.
 */
public class ConfException extends RuntimeException {

    public ConfException(String msg) {
        super(msg);
    }
    public ConfException(String msg,Exception e) {
        super(msg,e);
    }


}

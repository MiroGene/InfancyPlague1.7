import com.test.distantsun.message.MessageContrllor;
import com.test.distantsun.test.JedisTemp;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2017/4/25.
 */
public class TestMeta extends ControllerTest{
        @Test
        public void testJedisController(){
            controller.getMessage();
            Assert.assertTrue(true);
        }
/*    @Test
    public void testJedis(){
        testInvokeLog();
        Assert.assertTrue(true);
    }*/
}

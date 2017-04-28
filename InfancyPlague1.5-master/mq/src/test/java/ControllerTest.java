import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.test.distantsun.message.MessageContrllor;

import javax.annotation.Resource;

/**
 * Created by Gene on 2017/4/25.
 */
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath*:/spring/applicationContext*.xml", "classpath*:/spring/springMVC-servlet.xml"})
    //@ContextConfiguration(locations = {"classpath:applicationContext*.xml", "classpath:spring/springMVC-servlet.xml"})
    public class ControllerTest {
        @Resource(name = "testController")
        protected MessageContrllor controller;
        @Test
        public void a(){}
    }
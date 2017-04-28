import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import per.gene.lgn.lgnctrllr.CheckLgn;

import javax.annotation.Resource;

/**
 * Created by Gene on 2017/4/26.
 */
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath*:applicationContext*.xml"})
    //@ContextConfiguration(locations = {"classpath:applicationContext*.xml", "classpath:spring/springMVC-servlet.xml"})
    public class TestController {
        @Resource(name = "testController")
        protected CheckLgn controller;
        @Test
        public void aVoid(){
            System.out.println("aaaaaaaaa");
            boolean flag =true;
            Assert.assertTrue(flag);
        }
    }


package com.test.distantsun.message;

import com.test.base.annotation.InvokeLog;
import com.test.distantsun.test.JedisTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gene on 2017/4/25.
 */
@Controller("testController")
@RequestMapping(value = "/TestClass")
public class MessageContrllor {
    @Autowired
    private JedisTemp jedisTemp;
    @InvokeLog(value = "aaa")
    @RequestMapping(value = "/testMethod")
    public void getMessage(){
        System.out.println("Thus do nothing.");
        jedisTemp.testInvokeLog();
    }
}

package com.test.distantsun.test;

import com.test.base.annotation.InvokeLog;
import org.junit.Test;
import org.springframework.stereotype.Service;


/**
 * Created by Gene on 2017/4/24.
 */
@Service
public class JedisTemp{

    @InvokeLog(value = "-----in testInvokeLog")
    public void testInvokeLog(){

        System.out.println("-------------------------------invokeLog");

    }
}

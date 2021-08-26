package com.cqxxty.security.admin.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步测试
 * 使用说明：
 * 1、springboot启动类增加@EnableAsync
 * 2、交由容器生成实例    @Autowired AsyncUtils asyncUtils;
 * 3、测试
 *     @GetMapping("/test")
 *     public void test2() throws InterruptedException {
 *         long currenttimestamp=System.currentTimeMillis();
 *         asyncUtils.task1();
 *         asyncUtils.task2();
 *         asyncUtils.task3();
 *         long endtimestamp=System.currentTimeMillis();
 *         System.out.println("test2耗时："+(endtimestamp-currenttimestamp));
 *     }
 * @ClassName AsyncUtils
 * @Author lei
 * @Date 2021/8/25 15:43
 * @Version 1.0
 */
@Component
public class AsyncUtils {
    @Async
    public void task1() throws InterruptedException {
        long currentTimestamp=System.currentTimeMillis();
        Thread.sleep(1000);
        long endtimestamp=System.currentTimeMillis();
        System.out.println("task1耗时："+(endtimestamp-currentTimestamp));
    }
    @Async
    public void task2() throws InterruptedException {
        long currentTimestamp=System.currentTimeMillis();
        Thread.sleep(2000);
        long endtimestamp=System.currentTimeMillis();
        System.out.println("task2耗时："+(endtimestamp-currentTimestamp));
    }
    @Async
    public void task3() throws InterruptedException {
        long currentTimestamp=System.currentTimeMillis();
        Thread.sleep(3000);
        long endtimestamp=System.currentTimeMillis();
        System.out.println("task3耗时："+(endtimestamp-currentTimestamp));
    }
}

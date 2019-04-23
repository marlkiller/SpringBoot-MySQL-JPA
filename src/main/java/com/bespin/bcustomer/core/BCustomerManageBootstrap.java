package com.bespin.bcustomer.core;

import com.bespin.bcustomer.service.BcustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * 开启任务线程
 *
 * @author Jason
 */
@Component
public class BCustomerManageBootstrap implements ApplicationRunner {

    @Value("${etl.odb.bcustomer.path}")
    private String path;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BcustomerService bcustomerService;

    private static Logger logger = LoggerFactory.getLogger(BCustomerManageBootstrap.class);

    @Override
    public void run(ApplicationArguments args) {

        logger.info("任务开始执行");
        long start = System.currentTimeMillis();
        // testReadFIle();
        logger.info("任务执行时间 : {}", Duration.ofMillis(System.currentTimeMillis() - start).getSeconds());
    }


    private void testReadFIle() throws IOException {
        File file = new File("/Users/voidm/Downloads/writetest.txt");
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
        // 用5M的缓冲读取文本文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8), 5 * 1024 * 1024);

        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            if (i++ % 10000 == 0) {
                logger.info("当前记录数 : {} ", i);
            }
            String[] fields = line.split("\\|\\+\\|-\\|", -1);

        }
    }
}
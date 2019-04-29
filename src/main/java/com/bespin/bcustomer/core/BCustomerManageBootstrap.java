package com.bespin.bcustomer.core;

import com.bespin.bcustomer.dao.BcustomerRepository;
import com.bespin.bcustomer.entity.BcustomerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;

/**
 * 开启任务线程-4.26
 *
 * @author Jason
 */
@SuppressWarnings("Duplicates")
// @Component
public class BCustomerManageBootstrap implements ApplicationRunner {

    @Value("${etl.odb.bcustomer.path}")
    private String path;

    @Value("${etl.odb.bcustomer.size}")
    private int batchSize;

    @Autowired
    private BcustomerRepository bcustomerRepository;

    private static Logger logger = LoggerFactory.getLogger(BCustomerManageBootstrap.class);

    /**
     * 日期格式化
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER_S = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.UK);
    private static final DateTimeFormatter DATE_TIME_FORMATTER_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS", Locale.UK);
    private static final DateTimeFormatter DATE_TIME_FORMATTER_SSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.UK);


    /**
     * 多线程处理
     */
    public static ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    public static BlockingQueue queue = new ArrayBlockingQueue(10);
    public static long threadTime = 0;
    // 40346


    @Override
    public void run(ApplicationArguments args) throws IOException, InterruptedException, ClassNotFoundException {
        logger.info("任务开始执行");
        long start = System.currentTimeMillis();
        // testReadFIle();

        // new Thread(() -> {
        //     while (true) {
        //         try {
        //             Object objTake = queue.take();
        //             executorService.execute(() -> {
        //                 long threadStart = System.currentTimeMillis();
        //                 bcustomerRepository.saveAll((List<BcustomerEntity>) objTake);
        //                 addTime(System.currentTimeMillis() - threadStart);
        //             });
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        // }).start();
        // testReadFIleWithThread();
        logger.info("任务执行时间 : {}", System.currentTimeMillis() - start);

    }


    private void testReadFIleWithThread() throws IOException, InterruptedException, ClassNotFoundException {
        try {
            // File file = new File("/Users/voidm/Downloads/writetest.txt");
            File file = new File(path);
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
            // 用5M的缓冲读取文本文件
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8), 5 * 1024 * 1024);

            String line;
            int index = 0;
            // int successNum = 0;
            // int errorNum = 0;

            // 开始时间
            long startTime = System.currentTimeMillis();

            List<BcustomerEntity> batchBuffer = new ArrayList<>(batchSize);
            while ((line = reader.readLine()) != null) {

                // 过滤第一条,表头
                if (index == 0) {
                    index++;
                    continue;
                }

                // 处理 1w 条,输出记录一条日志
                if (index % 10000 == 0) {
                    logger.info("当前记录数 : {}  , 耗时 : {}", index, Duration.ofMillis(System.currentTimeMillis() - startTime).getSeconds() + " 分");
                }

                String[] fields = line.split("\\|\\+\\|-\\|", -1);
                if (fields.length == 64) {
                    batchBuffer.add(toBcustomerEntity(fields));
                } else {
                    logger.error("数据字段不匹配 length: {} , index : {} , Content : {}", fields.length, index, Arrays.toString(fields));
                }
                if (batchBuffer.size() >= batchSize) {
                    // 缓冲区满,批次处理
                    queue.put(deepCopy(batchBuffer));
                    batchBuffer.clear();
                }
                index++;
            }

            if (batchBuffer.size() > 0) {
                // 缓冲剩余,批次处理
                queue.put(deepCopy(batchBuffer));
                batchBuffer.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    /**
     * 同步增加时间
     *
     * @param threadTime
     */
    private static synchronized void addTime(long threadTime) {
        threadTime += threadTime;
        logger.info("线程执行总时间 : {}", threadTime);
    }


    private void testReadFIle() throws IOException {
        try {
            // File file = new File("/Users/voidm/Downloads/writetest.txt");
            File file = new File(path);
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
            // 用5M的缓冲读取文本文件
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8), 5 * 1024 * 1024);

            String line;
            int index = 0;
            // int successNum = 0;
            // int errorNum = 0;
            List<BcustomerEntity> batchBuffer = new ArrayList<>(batchSize);

            // 开始时间
            long startTime = System.currentTimeMillis();
            while ((line = reader.readLine()) != null) {

                // 过滤第一条,表头
                if (index == 0) {
                    index++;
                    continue;
                }

                // 处理 1w 条,输出记录一条日志
                if (index % 10000 == 0) {
                    logger.info("当前记录数 : {}  , 耗时 : {}", index, Duration.ofMillis(System.currentTimeMillis() - startTime).getSeconds() + " 分");
                }

                String[] fields = line.split("\\|\\+\\|-\\|", -1);
                if (fields.length == 64) {
                    // if (index >= 26300000) {
                    batchBuffer.add(toBcustomerEntity(fields));
                    // }
                } else {
                    logger.error("数据字段不匹配 length: {} , index : {} , Content : {}", fields.length, index, Arrays.toString(fields));
                }
                if (batchBuffer.size() >= batchSize) {
                    // 缓冲区满,批次处理
                    try {
                        bcustomerRepository.saveAll(batchBuffer);
                    } catch (Exception e) {
                        logger.error("入库异常 index : {}", index);
                    }
                    batchBuffer.clear();
                }
                index++;
            }

            if (batchBuffer.size() > 0) {
                // 剩余缓冲区处理
                try {
                    bcustomerRepository.saveAll(batchBuffer);
                } catch (Exception e) {
                    logger.error("入库异常 index : {}", index);
                }
                batchBuffer.clear();
            }
            logger.info("入库完毕 index : {} ", index);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private BcustomerEntity toBcustomerEntity(String[] fields) {
        BcustomerEntity bcustomerEntity = new BcustomerEntity();
        try {
            bcustomerEntity.setCstId(parse2Integer(fields[0]));
            bcustomerEntity.setCstBdgId(parse2Integer(fields[1]));
            bcustomerEntity.setCstCszId(parse2Integer(fields[2]));
            bcustomerEntity.setCstCmtId(parse2Integer(fields[3]));
            bcustomerEntity.setCstCacId(parse2Integer(fields[4]));

            bcustomerEntity.setCstCttId(parse2Integer(fields[5]));
            bcustomerEntity.setCstCode(fields[6]);
            bcustomerEntity.setCstName(removeFourChar(fields[7]));
            bcustomerEntity.setCstFirstname(fields[8]);
            bcustomerEntity.setCstCompany(fields[9]);

            bcustomerEntity.setCstDrivinglicenseNum(fields[10]);
            bcustomerEntity.setCstBirthyear(parse2Integer(fields[11]));
            bcustomerEntity.setCstBirthmonth(parse2Integer(fields[12]));
            bcustomerEntity.setCstBirthday(parse2Integer(fields[13]));
            bcustomerEntity.setCstLnsId(parse2Integer(fields[14]));

            bcustomerEntity.setCstLnwId(parse2Integer(fields[15]));
            bcustomerEntity.setCstGndId(parse2Integer(fields[16]));
            bcustomerEntity.setCstSltId(parse2Integer(fields[17]));
            bcustomerEntity.setCstMembershipnum(fields[18]);
            bcustomerEntity.setCstRegistrationDt(parse2Timestamp(fields[19]));

            bcustomerEntity.setCstIdcardnum(fields[20]);
            bcustomerEntity.setCstCreationAdvId(parse2Integer(fields[21]));
            bcustomerEntity.setCstCreationCntId(parse2Integer(fields[22]));
            bcustomerEntity.setCstMngtAdvId(parse2Integer(fields[23]));
            bcustomerEntity.setCstMngtCntId(parse2Integer(fields[24]));

            bcustomerEntity.setCstAddress(removeFourChar(fields[25]));
            bcustomerEntity.setCstAddress2(fields[26]);
            bcustomerEntity.setCstAddress3(fields[27]);
            bcustomerEntity.setCstAddress4(fields[28]);
            bcustomerEntity.setCstZip(fields[29]);

            bcustomerEntity.setCstCtyId(parse2Integer(fields[30]));
            bcustomerEntity.setCstCity(fields[31]);
            bcustomerEntity.setCstValidaddressFlag(Boolean.parseBoolean(fields[32]));
            bcustomerEntity.setCstAreacode(fields[33]);
            bcustomerEntity.setCstTel(fields[34]);

            bcustomerEntity.setCstValidtelFlag(Boolean.parseBoolean(fields[35]));
            bcustomerEntity.setCstMobile(fields[36]);
            bcustomerEntity.setCstValidmobileFlag(Boolean.parseBoolean(fields[37]));
            bcustomerEntity.setCstWorkphone(fields[38]);
            bcustomerEntity.setCstWorkareacode(fields[39]);

            bcustomerEntity.setCstValidworkphoneFlag(Boolean.parseBoolean(fields[40]));
            bcustomerEntity.setCstFaxareacode(fields[41]);
            bcustomerEntity.setCstFax(fields[42]);
            bcustomerEntity.setCstValidfaxFlag(Boolean.parseBoolean(fields[43]));
            bcustomerEntity.setCstEmail(fields[44]);

            bcustomerEntity.setCstValidemailFlag(Boolean.parseBoolean(fields[45]));
            bcustomerEntity.setCstAltemail(fields[46]);
            bcustomerEntity.setCstValidaltemailFlag(Boolean.parseBoolean(fields[47]));
            bcustomerEntity.setCstOccId(parse2Integer(fields[48]));
            bcustomerEntity.setCstOccupation(fields[49]);

            bcustomerEntity.setCstCtmId(parse2Integer(fields[50]));
            bcustomerEntity.setCstCtiId(parse2Integer(fields[51]));
            bcustomerEntity.setCstIncId(parse2Integer(fields[52]));
            bcustomerEntity.setCstUnsubscriptionFlag(Boolean.parseBoolean(fields[53]));
            bcustomerEntity.setCstFirstpurchaseDt(parse2Timestamp(fields[54]));

            bcustomerEntity.setCstDtsId(parse2Integer(fields[55]));
            bcustomerEntity.setCstVipFlag(Boolean.parseBoolean(fields[56]));
            bcustomerEntity.setCstDedupCstId(parse2Integer(fields[57]));
            bcustomerEntity.setCstDwhupdateFlag(Boolean.parseBoolean(fields[58]));
            bcustomerEntity.setCstDedupCstId(parse2Integer(fields[59]));

            bcustomerEntity.setCstCreationDt(parse2Timestamp(fields[60]));
            bcustomerEntity.setCstUpdateDt(parse2Timestamp(fields[61]));
            bcustomerEntity.setCstCreationuid(fields[62]);
            bcustomerEntity.setCstUpdateuid(fields[63]);
        } catch (Exception e) {
            logger.error("数据转换异常 : Msg : {},Content : {}", e.getMessage(), Arrays.toString(fields));
            // e.printStackTrace();
        }
        return bcustomerEntity;
    }

    /**
     * 日期类转换
     *
     * @param value
     * @return
     */
    private Timestamp parse2Timestamp(String value) {

        // 2009-04-15 16:31:33.86
        if (value == null || "null".equals(value) || "".equals(value)) {
            return null;
        }
        DateTimeFormatter formatter = null;
        if (value.length() == 21) {
            formatter = DATE_TIME_FORMATTER_S;
        }
        if (value.length() == 22) {
            formatter = DATE_TIME_FORMATTER_SS;
        }
        if (value.length() == 23) {
            formatter = DATE_TIME_FORMATTER_SSS;
        }
        return Timestamp.valueOf(LocalDateTime.parse(value, formatter));
    }

    /**
     * 整数转换
     *
     * @param value
     * @return
     */
    private Integer parse2Integer(String value) {
        if ("null".equals(value) || value == null || "".equals(value)) {
            return null;
        }
        return Integer.parseInt(value);
    }


    /**
     * 处理特殊字符
     * \xF0\x9F\x98\x82\xF0\x9F…
     * \xF0\x9F\x90\xBB\xE5\xA4
     *
     * @param content
     * @return
     */
    private static String removeFourChar(String content) {
        byte[] conbyte = content.getBytes();
        for (int i = 0; i < conbyte.length; i++) {
            if ((conbyte[i] & 0xF8) == 0xF0) {
                for (int j = 0; j < 4; j++) {
                    conbyte[i + j] = 0x30;
                }
                i += 3;
            }
        }
        content = new String(conbyte);
        return content.replaceAll("0000", "");
    }
}
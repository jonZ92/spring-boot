package com.order.orderprovider.kafka;


import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @ClassName SenderConttoller
 * @Description TD
 * @Author jon
 * @Date 2021/3/20 下午10:31
 * @Version 1.0
 * @Return:
 **/

@RestController
public class SenderConttoller {
    private Logger logger = LoggerFactory.getLogger(SenderConttoller.class);
    @Autowired
    private KafkaTemplate<String, String> template;
    /**
     * 同步发送
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @RequestMapping("syncSendMessage")
    public String syncSendMessage() {
//        int num=0;
//        for (int i = 0; i < 100000; i++) {
//            try {
//                if (num<8){
//                    template.send("testtopic", num, "0", "foo" + i).get();
//                    num+=1;
//                  }else {
//                    num=0;
//                }
//            } catch (InterruptedException e) {
//                logger.error("sync send message fail [{}]", e.getMessage());
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                logger.error("sync send message fail [{}]", e.getMessage());
//                e.printStackTrace();
//            }
//        }
        sendMsg(template);
        return "success";
    }


    /**
     * 异步发送
     *
     * @return
     */
    @RequestMapping("asyncSendMessage")
    public String sendMessageAsync() {
        for (int i = 0; i < 100; i++) {
            /**
             * <p>
             * SendResult:如果消息成功写入kafka就会返回一个RecordMetaData对象;result.
             * getRecordMetadata() 他包含主题信息和分区信息，以及集成在分区里的偏移量。
             * 查看RecordMetaData属性字段就知道了
             * </p>
             *
             */
            ListenableFuture<SendResult<String, String>> send = template.send("testtopic", "0", "foo" + i);
            send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

                @Override
                public void onSuccess(SendResult<String, String> result) {
                    logger.info("async send message success partition [{}]", result.getRecordMetadata().partition());
                    logger.info("async send message success offest[{}]", result.getRecordMetadata().offset());
                }

                @Override
                public void onFailure(Throwable ex) {
                    logger.error("async send message fail [{}]", ex.getMessage());

                }
            });
        }
        return "success";
    }


    private void sendMsg(KafkaTemplate<String, String> template){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4,6,1000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (long i=0;i<100000;i++) {
            final  long  j=  i;
            poolExecutor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    template.send("testtopic", 0, "0", "foo" +  j).get();
                }
            });
        }
        poolExecutor.shutdownNow();
    }









}

package com.order.orderprovider.mongodb;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Mong0s {
    @Id
    private String id;
    /** 文件名 */
    private String name;
    /** 上传时间 */
    private LocalDateTime createdTime;
    /** 文件内容 */
    private Binary content;
    /** 文件类型 */
    private String contentType;
    /** 文件大小 */
    private long size;


}

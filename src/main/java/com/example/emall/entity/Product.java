package com.example.emall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Product extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标题:2-80个字符
     */
    private String title;

    /**
     * 摘要：2-140个字符
     */
    private String pabstract;

    /**
     * 内容:2-1000个字符
     */
    private String content;

    /**
     * 价格
     */
    private Integer price;

    /**
     * seller用户ID
     */
    private Long sellerId;

    /**
     * buyer用户ID
     */
    private Long buyerId;

    /**
     * 售出数量
     */
    private Integer salesCount;

    /**
     * 创建日期
     */
    private Date created;

    /**
     * 最后更新日期
     */
    private Date modified;

    /**
     * 配图
     */
    private String pic;


}

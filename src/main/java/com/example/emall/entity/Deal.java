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
public class Deal extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 商品名称
     */
    private String title;

    /**
     * 当时购买价格
     */
    private Integer price;

    /**
     * 购买商品数量
     */
    private Integer postNum;

    /**
     * 总价
     */
    private Integer sum;

    private Date created;

    /**
     * 商品图
     */
    private String postPic;


}

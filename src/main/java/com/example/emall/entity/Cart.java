package com.example.emall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Cart extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
    private String title;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 车内商品数量
     */
    private Integer postNum;

    /**
     * 车内商品数量
     */
    private Long productId;



}

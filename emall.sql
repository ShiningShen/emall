

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for post（内容商品）
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题:2-80个字符',
  `pabstract` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '摘要：2-140个字符',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容:2-1000个字符',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '价格',
  `edit_mode` tinyint(2) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '0为编辑模式，1为不可编辑',
  `seller_id` bigint(32) DEFAULT NULL COMMENT 'seller用户ID',
  `buyer_id` bigint(32) DEFAULT NULL COMMENT 'buyer用户ID',
  `sales_count` int(11) NOT NULL DEFAULT '0' COMMENT '售出数量',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `modified` datetime DEFAULT NULL COMMENT '最后更新日期',
  `pic` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '配图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;


-- ----------------------------
-- Table structure for user 用户表
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
  `password` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `seller` tinyint(2) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '0为seller，1为buyer',
  `post_count` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '内容商品数量，buyer为0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for cart 购物车
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品标题',
  `product_id` bigint(32) DEFAULT NULL COMMENT '商品ID',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '价格',
  `post_num` int(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '车内商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for order 订单
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品标题',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '价格',
  `post_num` int(11) NOT NULL DEFAULT '0' COMMENT '购买商品数量',
  `sum` int(11) NOT NULL DEFAULT '0' COMMENT '总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;





package com.example.common.constant;

/**
 * @apiNote 常量配置
 */
public interface Config {

    /**
     * 上传文件的默认url前缀，根据部署设置自行修改
     */
    String FILE_UPLOAD_DIC = "D:\\upload\\";

    /**
     * 默认的时间序列化格式
     */
    String DATE_TIME_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 首页轮播图数量(可根据自身需求修改)
     */
    int INDEX_CAROUSEL_NUMBER = 5;

    /**
     * 首页一级分类的最大数量
     */
    int INDEX_CATEGORY_NUMBER = 10;

    /**
     * 搜索页一级分类的最大数量
     */
    int SEARCH_CATEGORY_NUMBER = 8;

    /**
     * 首页热卖商品数量
     */
    int INDEX_GOODS_HOT_NUMBER = 4;

    /**
     * 首页新品数量
     */
    int INDEX_GOODS_NEW_NUMBER = 5;

    /**
     * 首页推荐商品数量
     */
    int INDEX_GOODS_RECOMMOND_NUMBER = 10;

    /**
     * 购物车中商品的最大数量(可根据自身需求修改)
     */
    int SHOPPING_CART_ITEM_TOTAL_NUMBER = 13;

    /**
     * 购物车中单个商品的最大购买数量(可根据自身需求修改)
     */
    int SHOPPING_CART_ITEM_LIMIT_NUMBER = 5;

    /**
     * 搜索分页的默认条数(每页10条)
     */
    int GOODS_SEARCH_PAGE_LIMIT = 10;

    /**
     * 我的订单列表分页的默认条数(每页3条)
     */
    int ORDER_SEARCH_PAGE_LIMIT = 3;

    /**
     * 商品上架状态
     */
    int SELL_STATUS_UP = 0;

    /**
     * 商品下架状态
     */
    int SELL_STATUS_DOWN = 1;

}

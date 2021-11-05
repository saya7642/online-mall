package com.example.common.constant;

public interface ApiTip {

    String DATA_NOT_EXIST = "未查询到记录！";

    String PARAM_ERROR = "参数错误！";

    String SAME_CATEGORY_EXIST = "已存在同级同名的分类！";

    String SAME_LOGIN_NAME_EXIST = "用户名已存在！";

    String LOGIN_NAME_NULL = "请输入登录名！";

    String LOGIN_NAME_IS_NOT_PHONE = "请输入正确的手机号！";

    String LOGIN_PASSWORD_NULL = "请输入密码！";

    String LOGIN_VERIFY_CODE_NULL = "请输入验证码！";

    String LOGIN_VERIFY_CODE_ERROR = "验证码错误！";

    String SAME_INDEX_CONFIG_EXIST = "已存在相同的首页配置项！";

    String GOODS_CATEGORY_ERROR = "分类数据异常！";

    String SAME_GOODS_EXIST = "已存在相同的商品信息！";

    String GOODS_NOT_EXIST = "商品不存在！";

    String GOODS_PUT_DOWN = "商品已下架！";

    String SHOPPING_CART_ITEM_LIMIT_NUMBER_ERROR = "超出单个商品的最大购买数量！";

    String SHOPPING_CART_ITEM_NUMBER_ERROR = "商品数量不能小于 1 ！";

    String SHOPPING_CART_ITEM_TOTAL_NUMBER_ERROR = "超出购物车最大容量！";

    String SHOPPING_CART_ITEM_EXIST_ERROR = "已存在！无需重复添加！";

    String LOGIN_ERROR = "登录失败！";

    String NOT_LOGIN_ERROR = "未登录！";

    String ADMIN_NOT_LOGIN_ERROR = "管理员未登录！";

    String TOKEN_EXPIRE_ERROR = "无效认证！请重新登录！";

    String ADMIN_TOKEN_EXPIRE_ERROR = "管理员登录过期！请重新登录！";

    String USER_NULL_ERROR = "无效用户！请重新登录！";

    String LOGIN_USER_LOCKED_ERROR = "用户已被禁止登录！";

    String ORDER_NOT_EXIST_ERROR = "订单不存在！";

    String ADDRESS_NULL_ERROR = "地址不能为空！";

    String ORDER_PRICE_ERROR = "订单价格异常！";

    String ORDER_ITEM_NULL_ERROR = "订单项异常！";

    String ORDER_GENERATE_ERROR = "生成订单异常！";

    String SHOPPING_ITEM_ERROR = "购物车数据异常！";

    String SHOPPING_ITEM_COUNT_ERROR = "库存不足！";

    String ORDER_STATUS_ERROR = "订单状态异常！";

    String OPERATE_ERROR = "操作失败！";

    String REQUEST_FORBIDEN_ERROR = "禁止该操作！";

    String NO_PERMISSION_ERROR = "无权限！";

    String DB_ERROR = "数据库异常";
}

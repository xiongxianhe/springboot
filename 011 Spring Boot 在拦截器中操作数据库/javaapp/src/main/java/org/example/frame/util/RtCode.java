/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/15 14:14
 * Desc:
 */
package org.example.frame.util;

public enum RtCode {
    SUCCESS                           (   200,    "成功"),
    OPTIONS                           (   201,    "http options请求"),
    ERR_PARAMS                        (   100,   "参数错误"),
    ERR_ACCESS                        (   101,  "访问失败"),
    ERR_NOT_PRIVILEGE                 (   102,  " 没有权限"),

    ERR_NEED_TOKEN            ( 300,      "需要token"),
    ERR_NEED_UID              ( 301,      "需要uid"),
    ERR_DECODE_TOKEN          ( 302,      "解析token出错"),
    ERR_TOKEN_FORMAT          ( 303,      "token格式错误"),
    ERR_JWT_PUBLIC_MISS       ( 304,      "jwt公共声明中缺少必要字段"),
    ERR_VERFY_TOKEN           ( 305,      "token验证失败"),
    ERR_NEED_RE_LOGIN         ( 306,      "重新登录和注册  v2版本支持"),
    ERR_NOT_USE				  ( 307,		"暂不提供使用"),
    ERR_TOKEN_EXP			( 308,		"token失效"),

    ERR_INNER                 ( 400,      "内部错误"),
    ERR_ADMIN_USER            ( 401,      "用户名或密码错误"),
    ERR_ADMIN_TOKEN_EMPTY     ( 402,      "非法访问"),
    ERR_ADMIN_LOGIN_AGAIN     ( 403,      "请重新登录"),
    ERR_ADMIN_NOT_EXIST       ( 404,      "请重新登录"),
    ERR_OLD_PASSWORD          ( 405,      "旧密码错误"),
    ERR_CHECK_PASSWORD        ( 406,      "确认密码错误"),
    ERR_USER_EXIST            ( 407,      "登录账号已存在"),

    // 微信接口相关
    ERR_CODE2SESSION			(   1001,     "code获取session错误"),
    ERR_CRYPT					(   1002,     "解密encryptedData错误"),
    ERR_WX_API					(   1003,  "调用微信API错误"),
    ERR_PAY_FAIL				(   1004,  "支付失败"),

    // 资源相关
    ERR_UPIMAGE               ( 2000,     "图片上传错误"),
    ERR_FILE_NOT_EXIST        ( 2001,     "路径不存在"),
    ERR_DOMAIN_NOT            ( 2002,     "域不允许"),
    ERR_SENSITIVE_WORD        ( 2003,     "敏感词"),
    ERROR_CREATE_DIR          ( 2004,     "创建目录失败"),
    ERROR_DIR_NOT_WRITEABLE   ( 2005,     "目录不能写"),

    ERR_NOT_PHONE                     (   2100,   "不是手机号"),
    ERR_VERIFY_CODE                   (   2101,   "手机验证码错误"),
    ERR_USER_NOT_EXIST                (   2102,   "用户不存在"),
    ERR_RECHARGE_USER_NOT_EXIST       (   2103,   "充值用户不存在"),
    ERR_NOT_NEED_TO_PAY               (   2104,   "不需要调起微信支付 支付成功"),
    ERR_SEND_CODE_SMS				(	2105,	"短信验证码发送失败"),
    ERR_EMAIL_FORMAT				(	2106,	"邮箱格式错误"),

    // 其他业务定义错误码从  10000 开始
    ERR_PARAM_USER					(	10001,	"请填写必要的用户信息"),
    ERR_PARAM_CLIENT				(	10002,	"请填写必要的客户信息"),
    ERR_CLIENT_NOT_EXIST			(	10003,	"该信息不存在"),
    ERR_INTEGRAL_NOT_ENOUGH		(	10004,	"积分不够"),
    ERR_ACCOST_SELF					(	10005,	"不能自己勾搭自己"),
    ERR_ACCOSTED					(	10006,	"曾经勾搭过"),
    ERR_ACCOST_NOT_EXIST			(	10007,	"勾搭信息不存在"),
    ERR_COMMENTED					(	10008,	"已评论"),
    ERR_INTEGRAL_PRODUCT_NOT_EXIST(	10009,	"该积分产品不存在"),
    ERR_CLIENT_NOT_DEL				(	10010,	"无法删除，请至少保持有6个客户信息"),
    ERR_INVITE_CODE_NEED			(	10011,	"请联系管理员获取邀请码"),
    ERR_INVITE_CODE_NOT_EXIST		(	10012,	"邀请码无效"),
    ERR_CLIENT_EXIST				(	10013,	"改客户信息已存在"),
    ERR_SUCCESS_NOT_INTEGRAL		(	10014,	"客户添加成功，不增加积分");

    private final int code;
    private final String desc;

    RtCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

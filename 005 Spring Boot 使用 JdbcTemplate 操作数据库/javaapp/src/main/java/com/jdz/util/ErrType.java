package com.jdz.util;

import java.util.HashMap;
import java.util.Map;

public class ErrType {
    public static final Integer SUCCESS                 =       200;    // 成功
    public static final Integer ERR_PARAMS              =       100;    // 参数错误
    public static final Integer ERR_ACCESS              =       101;    // 访问失败
    public static final Integer ERR_NOT_PRIVILEGE       =       102;    // 没有权限

    public static final Integer ERR_INNER               =       400;    // 内部错误

    private static final Map<Integer, String> descMap = new HashMap<Integer, String>(){
        {
            put(SUCCESS,                        "成功");
            put(ERR_PARAMS,                     "参数错误");
            put(ERR_ACCESS,                     "访问失败");
            put(ERR_NOT_PRIVILEGE,              "没有权限");
            put(ERR_INNER,                      "内部错误");
        }
    };

    public static String getDesc(Integer code) {
        String res = descMap.get(code);
        return res == null ? "未定义" : res;
    }
}

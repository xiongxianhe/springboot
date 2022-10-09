package com.jdz.beans;

import java.util.HashMap;
import java.util.Map;

public final class RESCODE {

    public static final Integer SUCCESS         =   200;
    public static final Integer ERR_INNER       =   400;    // 内部错误
    public static final Integer ERR_PARAM       =   300;    // 参数错误
    public static final Integer ERR_TOKEN       =   401;    // token 错误

    public static Map<Integer, String> rescode = new HashMap<Integer, String>(){{
        put(SUCCESS,                    "success");
        put(ERR_INNER,                  "内部错误");
        put(ERR_PARAM,                  "参数错误");
        put(ERR_TOKEN,                  "token 错误");
    }};

    public static String getCodeDesc(Integer code) {
        String res = rescode.get(code);
        if(res == null) return "";
        return res;
    }
}

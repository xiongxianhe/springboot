/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/15 20:24
 * Desc:
 */
package org.example.frame.exception;

import org.example.frame.util.RtCode;

public class JDZException extends Exception{

    private final RtCode rtCode;

    public JDZException(RtCode rtCode) {
        super(rtCode.getDesc());
        this.rtCode = rtCode;
    }

    public RtCode getRtCode() {
        return rtCode;
    }
}

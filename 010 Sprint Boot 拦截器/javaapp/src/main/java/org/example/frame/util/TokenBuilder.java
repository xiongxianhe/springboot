/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/15 17:30
 * Desc:
 */
package org.example.frame.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class TokenBuilder {
    private String secret = "RG2Sc-tqLs-Z64aouZgVzxxxhSV21Io_#12fbdrOvyfb7lA0";

    private String uid; // uid
    private String loginType; // 登录类型
    private Long ct;
    private Map<String, Object> otherInfo;

    static class LoginType {
        final static String WEB = "web";
        final static String WX = "weixin";
    }

    public TokenBuilder() {
        this.ct = System.currentTimeMillis();
    }
    public TokenBuilder(String uid) {
        this.uid = uid;
        this.loginType = LoginType.WX;
        this.ct = System.currentTimeMillis();
    }
    public TokenBuilder(String uid, String loginType) {
        this.uid = uid;
        this.loginType = loginType;
        this.ct = System.currentTimeMillis();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public Long getCt() {
        return ct;
    }

    public void setCt(Long ct) {
        this.ct = ct;
    }

    public Map<String, Object> getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(Map<String, Object> otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String generate() {
        if(this.uid == null || this.uid.equals("") || this.loginType == null || this.loginType.equals("")) {
            return null;
        }
        Map<String, Object> headerMap = new HashMap<>();
        String alg = "HS256";
        headerMap.put("alg", alg);
        String typ = "JWT";
        headerMap.put("type", typ);

        Map<String, Object> playout = new HashMap<>();
        playout.put("ud", this.uid);
        playout.put("lg", this.loginType);
        playout.put("ct", this.ct);
        if(this.otherInfo != null) {
            playout.put("ot", this.otherInfo);
        }

        String token =  JWT.create()
                .withHeader(headerMap)
                .withPayload(playout)
                .sign(Algorithm.HMAC256(this.secret));

        return Base64.getUrlEncoder().withoutPadding().encodeToString(token.getBytes(StandardCharsets.UTF_8));
    }

    public RtCode parse(String vtoken) {
        try {
            String token = new  String(Base64.getUrlDecoder().decode(vtoken), StandardCharsets.UTF_8);
            Map<String, Claim> claimMap = JWT.require(Algorithm.HMAC256(this.secret))
                    .build()
                    .verify(token)
                    .getClaims();
            this.uid = String.valueOf(claimMap.get("ud"));
            this.loginType = String.valueOf(claimMap.get("lg"));
            this.ct = claimMap.get("ct").asLong();
            if(this.uid == null || loginType == null || ct == null) {
                return RtCode.ERR_JWT_PUBLIC_MISS;
            }
            return RtCode.SUCCESS;
        } catch (TokenExpiredException e) {
            return RtCode.ERR_TOKEN_EXP;
        } catch (SignatureVerificationException e) {
            return RtCode.ERR_VERFY_TOKEN;
        } catch (Exception e) {
            return RtCode.ERR_DECODE_TOKEN;
        }
    }
}

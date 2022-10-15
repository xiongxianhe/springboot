/**
 * Created by JDZ.
 * Company: Jindaozi Information Tec. Nanchang Com.
 * Copyright: jindaozi
 * Home: https://blog.uwenya.cc/category/java
 * Author: echo
 * Email: 360765409@qq.com
 * Date: 2022/10/14 17:30
 * Desc:
 */
package org.example.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTUtils {
    private String alg;
    private String typ;
    private String secret;

    private String header;

    private Integer expireTime;

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public String generate(Map<String, Object> playout) {
        System.out.println(header);

        Algorithm algorithm = Algorithm.HMAC256(this.secret);

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", this.alg);
        headerMap.put("type", this.typ);

        return JWT.create()
                .withHeader(headerMap)
                .withPayload(playout)
                .withClaim("xxxx", "1234")
                .sign(algorithm);
    }

    public Map<String, Object> parse(String token) {
        try {

            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            Map<String, Claim> claimMap =  JWT.require(algorithm).build().verify(token).getClaims();
            System.out.println(claimMap.get("xxxx"));
            System.out.println(claimMap.get("abc"));
            System.out.println(claimMap.get("abc23"));
            DecodedJWT j =  JWT.decode(token);
            String p = JWT.require(Algorithm.HMAC256(this.secret))
                    .build()
                    .verify(token)
                    .getPayload();
            System.out.println(p);
        } catch (TokenExpiredException e) {
            System.out.println("token 过期");
        } catch (SignatureVerificationException e) {
            System.out.println("token 验证失败");
        }

        return null;
    }

    @Override
    public String toString() {
        return "JWTUtils{" +
                "secret='" + secret + '\'' +
                ", header='" + header + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}

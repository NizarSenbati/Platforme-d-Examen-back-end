package com.application.exam.security;


//import com.application.exam.JWT;
//import com.application.exam.JWTVerifier;
//import com.application.exam.algorithms.Algorithm;
//import com.application.exam.exceptions.JWTCreationException;
//import com.application.exam.exceptions.JWTVerificationException;
//import com.application.exam.interfaces.DecodedJWT;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
public class JWTUtil {

//    @Value("${jwt_secret}")
//    private String secret;
//
//    public String generateToken(String email) throws IllegalArgumentException, JWTCreationException {
//        return JWT.create()
//                .withSubject("User Details")
//                .withClaim("email", email)
//                .withIssuedAt(new Date())
//                .withIssuer("YOUR APPLICATION/PROJECT/COMPANY NAME")
//                .sign(Algorithm.HMAC256(secret));
//    }
//
//    public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
//                .withSubject("User Details")
//                .withIssuer("YOUR APPLICATION/PROJECT/COMPANY NAME")
//                .build();
//        DecodedJWT jwt = verifier.verify(token);
//        return jwt.getClaim("email").asString();
//    }

}

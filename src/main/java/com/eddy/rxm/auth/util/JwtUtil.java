package com.eddy.rxm.auth.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.stat.descriptive.moment.Mean;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class JwtUtil {

    public static void main(String[] args) {
        double [][] arrMatrix = {{1,2,3},{4,5,6},{7,8,9}};
//        RealMatrix m1 = new Array2DRowRealMatrix(arrMatrix);
        RealMatrix m1 = MatrixUtils.createRealMatrix(arrMatrix);

        System.out.println(m1);

        int delCol = 0;

        int colAmount = m1.getColumnDimension();

        int rowAmount = m1.getRowDimension();


        int[] rowArr = new int[rowAmount];

        for(int i=0; i< rowAmount;i++){
            rowArr[i] = i;
        }

        List<Integer> colList = new ArrayList<>();
        for(int i=0; i< colAmount;i++){
            if(i == delCol){
                continue;
            }
            colList.add(i);
        }

//        Integer[] IntegerArr = colList.toArray(new Integer[]);
        int[] colArr = colList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(m1.getSubMatrix(rowArr, colArr));
        System.out.println(delColumn(m1, 1));

    }
    public static RealMatrix delColumn(RealMatrix matrix, int col){
        int colAmount = matrix.getColumnDimension();
        int rowAmount = matrix.getRowDimension();
        if(col >= colAmount){
            throw new RuntimeException("数组下标越界了");
        }
        int[] rowArr = new int[rowAmount];
        for(int i=0; i< rowAmount;i++){
            rowArr[i] = i;
        }
        List<Integer> colList = new ArrayList<>();
        for(int i=0; i< colAmount;i++){
            if(i == col){
                continue;
            }
            colList.add(i);
        }

        int[] colArr = colList.stream().mapToInt(Integer::intValue).toArray();
        return matrix.getSubMatrix(rowArr, colArr);

    }

    public static final long JWT_TTL = 60 * 60 * 1000L;
    // 设置秘钥
    public static final String JWT_KEY="sigeng";

    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    public static String createJWT(String subject){
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());
        return builder.compact();
    }

    public static String createJWT(String subject, Long ttlmillis){
        JwtBuilder builder = getJwtBuilder(subject, ttlmillis, getUUID());  // 设置过期时间
        return builder.compact();
    }

    public static String createJWT(String subject, Long ttlmillis, String id){
        JwtBuilder builder = getJwtBuilder(subject, ttlmillis, id);
        return builder.compact();
    }


    public static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis == null){
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)
                .setSubject(subject)
                .setIssuer("sg")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expDate);
    }


    /**
     * 生成加密后的秘钥
     * @return
     */
    public static SecretKey generalKey(){
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static Claims parseJWT(String jwt){
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

}

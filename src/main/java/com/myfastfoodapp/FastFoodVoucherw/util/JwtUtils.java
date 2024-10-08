package com.myfastfoodapp.FastFoodVoucherw.util;

   import io.jsonwebtoken.Claims;
   import io.jsonwebtoken.Jwts;
   import io.jsonwebtoken.SignatureAlgorithm;
   import org.springframework.stereotype.Component;

   import java.util.Date;

   @Component
   public class JwtUtils {

   	private final String jwtSecret = "your_secret_key";  // Replace with a more secure key

   	private final int jwtExpirationMs = 86400000;  // 1 day

   	public String generateJwtToken(String username) {
       	return Jwts.builder()
               	.setSubject(username)
               	.setIssuedAt(new Date())
               	.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
               	.signWith(SignatureAlgorithm.HS512, jwtSecret)
               	.compact();
   	}

   	public String getUserNameFromJwtToken(String token) {
       	Claims claims = Jwts.parser()
               	.setSigningKey(jwtSecret)
               	.parseClaimsJws(token)
               	.getBody();
       	return claims.getSubject();
   	}

   	public boolean validateJwtToken(String token) {
       	try {
           	Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
           	return true;
       	} catch (Exception e) {
           	// Token is invalid
       	}
       	return false;
   	}
   }

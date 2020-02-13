package phitx.example.warehourse.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import phitx.example.warehourse.model.request.UserLoginRequestModel;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authentiacationManager;

    public AuthenticationFilter( AuthenticationManager  authentiacationManager) {
        this.authentiacationManager = authentiacationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                               HttpServletResponse res ) throws AuthenticationException{
        try{
            UserLoginRequestModel login = new ObjectMapper().readValue(req.getInputStream(), UserLoginRequestModel.class);
            return authentiacationManager.authenticate( new UsernamePasswordAuthenticationToken( login.getEmail(), login.getPassword(), new ArrayList<>()));
        }
        catch (IOException e) {

            throw new RuntimeException(e);
      }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain,Authentication authen) throws IOException, ServletException{

        String userName = ((User) authen.getPrincipal()).getUsername();

        String jsonToken = Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SecurityConstants.TOKEN_SECRET)
                .compact();
        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + jsonToken);
    }

}

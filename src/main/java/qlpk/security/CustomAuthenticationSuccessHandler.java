package qlpk.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String redirectURL = request.getContextPath();

        if (userDetails.hasRole("ADMIN")) {
            redirectURL = "qlns/bacsi/ds-bacsi";
        } else if (userDetails.hasRole("BACSY")) {
            redirectURL = "bacsi/list-benhan";
        } else if (userDetails.hasRole("YTA")) {
            redirectURL = "yta/list-benhan";
        }

        response.sendRedirect(redirectURL);

    }
}

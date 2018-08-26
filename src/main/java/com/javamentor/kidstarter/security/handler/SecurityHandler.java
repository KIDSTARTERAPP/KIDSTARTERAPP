package com.javamentor.kidstarter.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SecurityHandler implements AuthenticationSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ADMIN")) {
            response.sendRedirect("/admin");
            return;
        }
        if (roles.contains("MENTOR")) {
            response.sendRedirect("/mentor/profile");
            return;
        }
        if ( roles.contains("USER")) {
            response.sendRedirect("/main");
            return;
        }
        if ( roles.contains("KID")) {
            response.sendRedirect("/main");
            return;
        }
        if ( roles.contains("OWNER")) {
            response.sendRedirect("/organization");
        }

    }
}
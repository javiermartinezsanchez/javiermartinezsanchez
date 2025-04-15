package es.uned.aw.ped2025.config;

import java.io.IOException;
import java.util.Set;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import es.uned.aw.ped2024.model.entities.Usuario;
import es.uned.aw.ped2024.model.service.UserAuditService;
/**
 * Handler cuando el login sea correcto.
 * 
 * 
 * */
@Component("myAuthenticationSuccessHandler")
public class MyCustomLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    ActiveUserStore activeUserStore;
    @Autowired
    UserAuditService userAuditService;
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        //addWelcomeCookie(gerUserName(authentication), response);
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            redirectStrategy.sendRedirect(request, response, "/admin/adminHome");
                   	
        } else if (roles.contains("ROLE_GESTOR")) {
            redirectStrategy.sendRedirect(request, response, "/home");
        	
        } else {
            //redirectStrategy.sendRedirect(request, response, "/" );
            redirectStrategy.sendRedirect(request, response, "/home");

        }
        
        
        final HttpSession session = request.getSession(false);
        if (session != null) {
            session.setMaxInactiveInterval(30 * 60);
            String username;
            if (authentication.getPrincipal() instanceof Usuario) {
            	username = ((Usuario)authentication.getPrincipal()).getEmail();
            }
            else {
            	username = authentication.getName();
            }
       
            LoggedUser user = new LoggedUser(username, activeUserStore);
            session.setAttribute("user", user);
            userAuditService.save(username, "Login");   
        }
        clearAuthenticationAttributes(request);
    }

    //private String gerUserName(final Authentication authentication) {
    //    return (authentication.getPrincipal()).getNombre();
    //}

    protected void clearAuthenticationAttributes(final HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
package es.uned.aw.ped2025.config;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;
@Component("myLogoutSuccessHandler")
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
        final String refererUrl = request.getHeader("Referer");
        System.out.println("onLogoutSuccess: " + refererUrl);
       logger.info("onLogoutSuccess: " + refererUrl + " usuario: " + authentication.getName() +" "+ LocalDate.now().toString());
        super.onLogoutSuccess(request, response, authentication);
    }

}

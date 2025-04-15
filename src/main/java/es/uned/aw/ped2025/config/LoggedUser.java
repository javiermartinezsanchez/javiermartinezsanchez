package es.uned.aw.ped2025.config;

import java.io.Serializable;
import java.util.List;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

import es.uned.aw.ped2025.controller.dto.UserConectedDTO;
/**
 * Servicio de mantenimiento de usuarios activos (logueados).
 * 
 **/
@Component
public class LoggedUser implements HttpSessionBindingListener, Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private ActiveUserStore activeUserStore;

    public LoggedUser(String username, ActiveUserStore activeUserStore) {
        this.username = username;
        this.activeUserStore = activeUserStore;
    }

    public LoggedUser() {
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        List<UserConectedDTO> users = activeUserStore.getUsers();
        LoggedUser user = (LoggedUser) event.getValue();
        if (!users.contains(user.getUsername())) {
            users.add(new UserConectedDTO(user.getUsername()));
        }
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        List<UserConectedDTO> users = activeUserStore.getUsers();
        LoggedUser user = (LoggedUser) event.getValue();
        users.remove(user.getUsername());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

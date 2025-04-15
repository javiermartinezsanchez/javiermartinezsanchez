package es.uned.aw.ped2025.config;

import java.util.ArrayList;
import java.util.List;

import es.uned.aw.ped2025.controller.dto.UserConectedDTO;
/**
 * Lista de usuarios activos en el sistema
 */
public class ActiveUserStore {

    public List<UserConectedDTO> users;

    public ActiveUserStore() {
        users = new ArrayList<>();
    }

    public List<UserConectedDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserConectedDTO> users) {
        this.users = users;
    }
}

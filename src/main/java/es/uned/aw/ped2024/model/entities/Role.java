package es.uned.aw.ped2024.model.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "roles")
    private Collection<Usuario> users;

    private String nombre;

    public Role() {
        super();
    }

    public Role(final String nombre) {
        super();
        this.nombre = nombre;
    }

    //

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String name) {
        this.nombre = name;
    }

    public Collection<Usuario> getUsers() {
        return users;
    }

    public void setUsers(final Collection<Usuario> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role role = (Role) obj;
        if (!getNombre().equals(role.getNombre())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Rol [nombre=").append(nombre).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }
}
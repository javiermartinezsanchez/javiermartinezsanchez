package es.uned.aw.ped2024.model.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Director extends Casting {

	
	@ManyToMany 
	@JoinTable(
			name="socios_directores",
			joinColumns=@JoinColumn(name="id_director",
			foreignKey=@ForeignKey(name="FK_director_socio"),
			nullable=false),
			inverseJoinColumns=@JoinColumn(name="id_usuario",
			foreignKey=@ForeignKey(name="FK_usuario_director"),
			nullable=false)

			)

	private Set<Cliente> socios;

}

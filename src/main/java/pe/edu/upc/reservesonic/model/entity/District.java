package pe.edu.upc.reservesonic.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "districts")
public class District {
	@Id
	@Column(name = "district_id", columnDefinition = "NUMERIC(10)", nullable = false)
	private Integer id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	// OneToMany relationships
	@OneToMany(mappedBy = "district", cascade = CascadeType.REMOVE)
	private List<User> users;

	@OneToMany(mappedBy = "district", cascade = CascadeType.REMOVE)
	private List<Admin> admins;

	@OneToMany(mappedBy = "district", cascade = CascadeType.REMOVE)
	private List<Studio> studios;

	// Constructor, getters & setters
	public District() {
		users = new ArrayList<User>();
		admins = new ArrayList<Admin>();
		studios = new ArrayList<Studio>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public List<Studio> getStudios() {
		return studios;
	}

	public void setStudios(List<Studio> studios) {
		this.studios = studios;
	}

}

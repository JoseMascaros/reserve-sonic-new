package pe.edu.upc.reservesonic.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin { //Owner
	@Id
	@Column(name = "admin_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "email", length = 25, nullable = false)
	private String email;

	@Column(name = "description", length = 60)
	private String description;

	// OneToMany relationships
	@OneToMany(mappedBy = "admin")
	private List<Studio> studios;

	// ManyToOne relationships
	@ManyToOne
	@JoinColumn(name = "district_id", nullable = false)
	private District district;

	// Constructor, getters & setters
	public Admin() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Studio> getStudios() {
		return studios;
	}

	public void setStudios(List<Studio> studios) {
		this.studios = studios;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

}

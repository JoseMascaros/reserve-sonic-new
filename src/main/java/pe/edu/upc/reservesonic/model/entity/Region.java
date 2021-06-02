package pe.edu.upc.reservesonic.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {
	@Id
	@Column(name = "region_id", length = 5, nullable = false)
	private String id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	// OneToMany relationships
	// @OneToMany(mappedBy = "region")
	// private List<District> districts;

	// Constructor, getters & setters
	public Region() {
		super();
		// districts = new ArrayList<District>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public List<District> getDistricts() {
	// return districts;
	// }

	// public void setDistricts(List<District> districts) {
	// this.districts = districts;
	// }

}
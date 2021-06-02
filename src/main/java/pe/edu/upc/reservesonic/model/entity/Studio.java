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
@Table(name = "studios")
public class Studio {
	@Id
	@Column(name = "studio_id", columnDefinition = "NUMERIC(4)")
	private Integer id;

	@Column(name = "name", length = 40)
	private String name;

	// OneToMany relationships
	@OneToMany(mappedBy = "studio")
	private List<Room> rooms;

	@OneToMany(mappedBy = "studio")
	private List<Review> reviews;

	// ManyToOne relationships
	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;

	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;

	// Constructor, getters & setters
	public Studio() {
		rooms = new ArrayList<Room>();
		reviews = new ArrayList<Review>();
	}

	public Studio(Integer id, String name) {
		this.id = id;
		this.name = name;
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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studio other = (Studio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

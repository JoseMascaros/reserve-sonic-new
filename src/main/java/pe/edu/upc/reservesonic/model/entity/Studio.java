package pe.edu.upc.reservesonic.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "studios")
@SequenceGenerator(name="sequenceStudio", sequenceName="Studios_studio_id_seq", initialValue = 5, allocationSize = 1)
public class Studio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceStudio")
	@Column(name = "studio_id", columnDefinition = "DECIMAL(4)")
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


}

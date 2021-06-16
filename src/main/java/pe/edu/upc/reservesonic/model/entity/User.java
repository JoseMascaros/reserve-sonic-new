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
@Table(name = "users")
@SequenceGenerator(name = "genUserId", initialValue = 1, allocationSize = 1)
public class User { //Musician

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genUserId")
	@Column(name = "user_id", columnDefinition = "NUMERIC(4)")
	private Integer id;

	@Column(name = "name", length = 30, nullable = false)
	private String username;

	@Column(name = "email", length = 50, nullable = false)
	private String email;

	@Column(name = "password", length = 60, nullable = false)
	private String password;

	@Column(name = "description", length = 70, nullable = false)
	private String description;

	// OneToMany relationships
	@OneToMany(mappedBy = "user")
	private List<Reservation> reservations;

	@OneToMany(mappedBy = "user")
	private List<Review> reviews;

	// ManyToOne relationships
	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;

	// Constructor, getters & setters
	public User() {
		reservations = new ArrayList<Reservation>();
		reviews = new ArrayList<Review>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
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

}
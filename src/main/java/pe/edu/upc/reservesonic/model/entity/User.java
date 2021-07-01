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
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User { // Musician

	@Id
	private Integer id;

	@Column(name = "username", length = 30, nullable = false)
	private String username;

	@Column(name = "email", length = 50, nullable = false)
	@Email
	private String email;

	@Column(name = "password", length = 60, nullable = false)
	private String password;

	@Column(name = "enable")
	private boolean enable;

	// @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade =
	// CascadeType.ALL)
	// private List<Authority> authorities;

	public User() {
		this.enable = true;
		// this.authorities = new ArrayList<>();
		reservations = new ArrayList<Reservation>();
		reviews = new ArrayList<Review>();
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.enable = true;
		// this.authorities = new ArrayList<>();
	}

	// Agregar el ROLE o ACCESS al usuario
	// public void addAuthority(String auth) {
	// Authority authority = new Authority();
	// authority.setAuthority(auth);
	// authority.setUser(this);

	// this.authorities.add(authority);
	// }

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
package pe.edu.upc.reservesonic.model.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reservations")
@SequenceGenerator(name = "genReservationId", initialValue = 1, allocationSize = 1)
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genReservationId")
	@Column(name = "reservation_id", columnDefinition = "NUMERIC(6)")
	private Integer id;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "hour")
	@Temporal(TemporalType.TIME)
	private Date hour;

	@Column(name = "price", length = 15, nullable = false)
	private Float price;

	@Column(name = "status", length = 35)
	private String status;

	// OneToMany relationships
	@OneToMany(mappedBy = "reservation")
	private List<Studio> studios;

	// ManyToOne relationships
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// Constructor, getters & setters
	public Reservation() {
		studios = new ArrayList<Studio>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Studio> getStudios() {
		return studios;
	}

	public void setStudios(List<Studio> studios) {
		this.studios = studios;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
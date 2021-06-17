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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "studios")
@SequenceGenerator(name="sequenceStudio", sequenceName="Studios_studio_id_seq", initialValue = 1, allocationSize = 1)
public class Studio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceStudio")
	@Column(name = "studio_id", columnDefinition = "DECIMAL(4)")
	private Integer id;

	@Column(name = "name", length = 40)
	private String name;
	

	@Temporal(TemporalType.TIME)
	@Column(name = "start_time")
	@DateTimeFormat(pattern = "HH:mm")
	private Date startTime; // hora de inicio
	

	@Temporal(TemporalType.TIME)
	@Column(name = "end_time")
	@DateTimeFormat(pattern = "HH:mm")
	private Date endTime; // hora de fin

	// OneToMany relationships
	@OneToMany(mappedBy = "studio")
	private List<Room> rooms;

	// ManyToOne relationships
	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;

	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;

	// Constructor, getters & setters
	public Studio() {
		rooms = new ArrayList<Room>();
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


	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}


	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}

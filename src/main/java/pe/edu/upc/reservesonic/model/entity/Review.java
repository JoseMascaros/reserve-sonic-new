package pe.edu.upc.reservesonic.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@Column(name = "review_id", length = 5, nullable = false)
	private String id;

	@Column(name = "content", length = 50, nullable = false)
	private String name;

	// ManyToOne relationships
	@ManyToOne
	@JoinColumn(name = "studio_id", nullable = false)
	private Studio studio;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// Constructor, getters & setters
	public Review() {
		// To do
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

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio studio) {
		this.studio = studio;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

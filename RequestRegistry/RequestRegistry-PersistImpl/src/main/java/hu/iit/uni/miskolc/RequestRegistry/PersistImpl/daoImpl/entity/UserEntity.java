package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "Users")
public class UserEntity {

	@Id
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Enabled")
	private boolean enabled;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DetailsID")
	private DetailsEntity details;

	public UserEntity() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public DetailsEntity getDetails() {
		return details;
	}

	public void setDetails(DetailsEntity details) {
		this.details = details;
	}
}

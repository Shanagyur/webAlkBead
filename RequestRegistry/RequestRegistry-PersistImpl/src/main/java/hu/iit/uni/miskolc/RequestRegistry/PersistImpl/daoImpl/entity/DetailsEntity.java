package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Details")
@Table(name = "Details")
public class DetailsEntity {

	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Id
	@Column(name = "Email")
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SettlementID")
	private SettlementEntity settlement;

	public DetailsEntity() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SettlementEntity getSettlement() {
		return settlement;
	}

	public void setSettlement(SettlementEntity settlement) {
		this.settlement = settlement;
	}
}

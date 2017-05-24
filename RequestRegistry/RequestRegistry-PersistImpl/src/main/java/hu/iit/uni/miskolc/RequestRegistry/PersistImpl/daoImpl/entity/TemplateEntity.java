package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Template")
@Table(name = "Templates")
public class TemplateEntity {

	@Id
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;
	
	public TemplateEntity() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

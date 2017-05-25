package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter;

import hu.iit.uni.miskolc.RequestRegistry.Model.Template;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.TemplateEntity;

public class TemplateEntityConverter {

	private TemplateEntityConverter() {
	}

	public static Template convertTemplateEntityToModel(TemplateEntity templateEntity) {
		Template template = new Template();
		
		template.setName(templateEntity.getName());
		template.setDescription(templateEntity.getDescription());
		
		return template;
	}
	
	public static TemplateEntity convertTemplateToEntity(Template template) {
		TemplateEntity templateEntity = new TemplateEntity();
		
		templateEntity.setName(template.getName());
		templateEntity.setDescription(template.getDescription());
		
		return templateEntity;
	}
}

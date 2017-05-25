package hu.iit.uni.miskolc.RequestRegistry.PersistImpl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hu.iit.uni.miskolc.RequestRegistry.Model.Template;
import hu.iit.uni.miskolc.RequestRegistry.Persist.dao.TemplateDao;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidTemplateException;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.TemplateEntity;

@Repository
@Transactional
public class TemplateDaoImpl implements TemplateDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public TemplateDaoImpl() {
	}

	@Override
	public void createTemplate(Template template) throws InvalidTemplateException {
		if(this.entityManager.find(TemplateEntity.class, template.getName()) != null) {
			TemplateEntity templateEntity = new TemplateEntity();

			templateEntity.setName(template.getName());
			templateEntity.setDescription(template.getDescription());
			
			this.entityManager.persist(templateEntity);
		} else {
			throw new InvalidTemplateException();
		}
	}
}

package hu.iit.uni.miskolc.RequestRegistry.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.iit.uni.miskolc.RequestRegistry.Model.Template;
import hu.iit.uni.miskolc.RequestRegistry.Persist.dao.TemplateDao;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidTemplateException;
import hu.iit.uni.miskolc.RequestRegistry.Service.TemplateService;

@Service
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateDao templateDao;
	
	public TemplateServiceImpl() {
	}

	@Override
	public void createTemplate(String name, String description) throws InvalidTemplateException {
		if(this.templateDao.getTemplateByName(name) != null) {
			throw new InvalidTemplateException();
		} else {
			Template template = new Template();
			template.setName(name);
			template.setDescription(description);
			
			this.templateDao.createTemplate(template);
		}
	}
}

package hu.iit.uni.miskolc.RequestRegistry.Service;

import hu.iit.uni.miskolc.RequestRegistry.Model.Template;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidTemplateException;

public interface TemplateService {

	Template getTemplateByName(String templateName) throws InvalidTemplateException;
	
	void createTemplate(String name, String description) throws InvalidTemplateException;
}

package hu.iit.uni.miskolc.RequestRegistry.Service;

import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidTemplateException;

public interface TemplateService {

	void createTemplate(String name, String description) throws InvalidTemplateException;
}

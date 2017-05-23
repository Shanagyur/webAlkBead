package hu.iit.uni.miskolc.RequestRegistry.Persist.dao;

import hu.iit.uni.miskolc.RequestRegistry.Model.Template;
import hu.iit.uni.miskolc.RequestRegistry.Persist.exception.InvalidTemplateException;

public interface TemplateDao {

	void createTemplate(Template template) throws InvalidTemplateException;
}

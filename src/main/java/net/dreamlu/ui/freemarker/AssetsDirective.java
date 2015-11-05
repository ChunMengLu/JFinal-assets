package net.dreamlu.ui.freemarker;

import java.io.IOException;
import java.util.Map;

import com.jfinal.kit.StrKit;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import net.dreamlu.kit.AssetsKit;

/**
 * freemarker合并压缩标签
 * @author L.cm
 */
public class AssetsDirective implements TemplateDirectiveModel {

	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		
		Object var = params.get("var");
		if (var == null) {
			throw new TemplateModelException("assets tag attribute var can not be null!");
		}
		String varName = var.toString();
		if (StrKit.isBlank(varName)) {
			throw new TemplateModelException("assets tag attribute var can not be null!");
		}
		Object file = params.get("file");
		if (file == null) {
			throw new TemplateModelException("assets tag attribute file can not be null!");
		}
		String fileName = file.toString();
		if (StrKit.isBlank(fileName)) {
			throw new TemplateModelException("assets tag attribute file can not be null!");
		}
		String path = AssetsKit.combo(fileName);

		BeansWrapper beansWrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_20).build();
		env.setVariable(varName, beansWrapper.wrap(path));
		body.render(env.getOut());
	}
	
}

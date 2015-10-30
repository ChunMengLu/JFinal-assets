package net.dreamlu.ui.beetl;

import java.util.Map;

import org.beetl.core.GeneralVarTagBinding;

/**
 * 
 */
public class AssetsTag extends GeneralVarTagBinding {
	
	@Override
	@SuppressWarnings("unchecked")
	public void render() {
		Map<String, Object> paras = (Map<String, Object>) this.args[1];
		Object type = paras.get("type");
		Object list = paras.get("list");
		
		
	}
	
}

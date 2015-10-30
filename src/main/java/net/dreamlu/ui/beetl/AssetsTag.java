package net.dreamlu.ui.beetl;

import java.io.IOException;
import java.util.Map;

import org.beetl.core.GeneralVarTagBinding;

import com.jfinal.kit.StrKit;

import net.dreamlu.kit.AssetsKit;

/**
 * <#assets file="">
 * 
 * <#/assets>
 */
public class AssetsTag extends GeneralVarTagBinding {
	
	@Override
	@SuppressWarnings("unchecked")
	public void render() {
		Map<String, Object> paras = (Map<String, Object>) this.args[1];
		Object file = paras.get("file");
		if (file == null) {
			throw new RuntimeException("assets tag attribute file can not be null" );
		}
		String fileName = file.toString();
		if (StrKit.isBlank(fileName)) {
			throw new RuntimeException("assets tag attribute file can not be null" );
		}
		try {
			String src = AssetsKit.combo(fileName);
			this.binds(src);
			this.doBodyRender();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

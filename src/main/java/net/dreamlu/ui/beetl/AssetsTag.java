package net.dreamlu.ui.beetl;

import java.util.Map;

import org.beetl.core.GeneralVarTagBinding;

import com.jfinal.kit.StrKit;

import net.dreamlu.kit.AssetsKit;

/**
 * beetl合并压缩标签
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
			this.binds(AssetsKit.combo(fileName));
			this.doBodyRender();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

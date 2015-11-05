package net.dreamlu.ui.beetl;

import java.util.Map;

import org.beetl.core.GeneralVarTagBinding;
import org.beetl.core.exception.BeetlException;

import com.jfinal.kit.StrKit;

import net.dreamlu.kit.AssetsKit;

/**
 * beetl合并压缩标签
 * @author L.cm
 */
public class AssetsTag extends GeneralVarTagBinding {
	
	@Override
	@SuppressWarnings("unchecked")
	public void render() {
		Map<String, Object> paras = (Map<String, Object>) this.args[1];
		Object file = paras.get("file");
		if (file == null) {
			throw new BeetlException("assets tag attribute file can not be null!");
		}
		String fileName = file.toString();
		if (StrKit.isBlank(fileName)) {
			throw new BeetlException("assets tag attribute file can not be null!");
		}
		try {
			this.binds(AssetsKit.combo(fileName));
			this.doBodyRender();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}

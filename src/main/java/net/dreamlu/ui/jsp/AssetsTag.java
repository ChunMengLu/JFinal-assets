package net.dreamlu.ui.jsp;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.jfinal.kit.StrKit;

import net.dreamlu.kit.AssetsKit;

/**
 * Jsp合并压缩标签
 * @author L.cm
 */
public class AssetsTag extends TagSupport {

	private static final long serialVersionUID = -1435356249307286716L;

	private String var;
	private String file;

	public void setVar(String var) {
		this.var = var;
	}
	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public int doStartTag() throws JspException {
		if (StrKit.isBlank(var)) {
			throw new JspException("assets tag attribute var can not be blank!");
		}
		if (StrKit.isBlank(file)) {
			throw new JspException("assets tag attribute file can not be blank!");
		}
		try {
			this.pageContext.setAttribute(var, AssetsKit.combo(file));
		} catch (IOException e) {
			throw new JspException(e);
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}

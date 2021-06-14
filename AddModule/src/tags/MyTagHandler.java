package tags;

import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport
{
	@Override
	public int doStartTag() throws JspException {
		try {
			//Task :....tags
			JspWriter out = pageContext.getOut();
			out.println("<h1>This is my custom Tags</h1>");
			out.println("<p>This is Custome paragraph</p>");
			out.println("<br>");
			out.println(new Date().toString());
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	   return SKIP_BODY;
	}

}

package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintTableTag extends TagSupport
{
	public int number;
	public String color;
	
    public void setColor(String color) {
		this.color = color;
	}


	// Setter
	public void setNumber(int number) {
		this.number = number;
	}


	@Override
	public int doStartTag() throws JspException {
		try {
			
			JspWriter out = pageContext.getOut();
			
			// print Table
			//1 - 10
			
			
			out.println("<div style='color: "+color+"' >");
			out.print("<br>");
			
			for(int i=1; i<=10; i++) {
				
				out.println(i +"      "+"*"+"     "+number+"      "+"="+"      "+(i * number)+"<br>");
			}
			
			out.println("</div>");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}
}

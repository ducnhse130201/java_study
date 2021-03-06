package customtag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.StringTokenizer;

public class DataFormatterTag extends SimpleTagSupport {
    private String header;
    private String items;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getHeader() {
        return header;
    }

    public String getItems() {
        return items;
    }


    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();

        out.print(String.format("<table style=\"border:1px solid green\">\n" +
                "\t<tr>\n" +
                "\t\t<td><span style=\"font-weight:bold\">%s</span></td>\n" +
                "\t</tr>\t\n", header));
        StringTokenizer tokenizer = new StringTokenizer(items, ",");
        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            out.print("<tr><td>" + token + "</td></tr>\n");
        }
        out.print("</table>");

    }
}

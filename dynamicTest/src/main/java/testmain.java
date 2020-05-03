
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class testmain {

    public static void main(String[] args) throws Exception{
		Configuration cfg=new Configuration(Configuration.VERSION_2_3_30);
		cfg.setDirectoryForTemplateLoading(new File("src/main/java/temp"));
		cfg.setDefaultEncoding("UTF-8");

        places p1 = new places("hi road");
		places p2 = new places("you road");
		ArrayList<places> placesList = new ArrayList<places>();

		placesList.add(p1);
        placesList.add(p2);

        dates date1= new dates(placesList);
		dates date2= new dates(placesList);
		ArrayList<dates> datesList = new ArrayList<dates>();
		datesList.add(date1);
		datesList.add(date2);

		Map<String, Object> product = new HashMap<String, Object>();
		product.put("datesList", datesList);

		Template temp = cfg.getTemplate("dynamic.html");
		
		Writer out = new OutputStreamWriter(System.out);
		temp.process(product, out);

		out.flush();
		out.close();
	    }
}
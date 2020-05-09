
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class testmain {

    public static void main(String[] args) throws Exception{
		Configuration cfg=new Configuration(Configuration.VERSION_2_3_30);
		cfg.setDirectoryForTemplateLoading(new File("src/main/java"));
		cfg.setDefaultEncoding("UTF-8");

		Map<String, Object> map = new HashMap<String, Object>();
		String flight1="flight1 info...";
		String flight2="flight2 info...";

		List<String> Hotels = new ArrayList<String>();
		Hotels.add("i'am Hotel 1");
		Hotels.add("i'am Hotel 2");
		Hotels.add("i'am Hotel 3");

		List<List<String>> days = new ArrayList<>();
		List<String> day1 = new ArrayList<String>();
		List<String> day2 = new ArrayList<String>();
		day1.add("i'am place 1 in day1");
		day1.add("i'am place 2 in day1");
		day2.add("i'am place 1 in day2");
		day2.add("i'am place 2 in day2");
		days.add(day1);
		days.add(day2);

		map.put("Flight1", flight1);
		map.put("Flight2", flight2);
		map.put("Hotels", Hotels);
		map.put("Days", days);


		String htmlStr = "";
		Template temp = cfg.getTemplate("itinerary_59.html");
//		Writer out = new OutputStreamWriter(System.out);
//		temp.process(map, out);
//		out.flush();
//		out.close();
		StringWriter sw= new StringWriter();
		BufferedWriter bf=new BufferedWriter(sw);
		temp.process(map,bf);
		htmlStr=sw.toString();
		bf.flush();
		bf.close();
		System.out.print(htmlStr);

	    }
}
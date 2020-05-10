
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Email.EmailSender;
import PDF.PDFGenerator;
import freemarker.template.Configuration;
import freemarker.template.Template;

public  class SendEmail {

        public static void emailSender(String email,
                                       String flight1,
                                       String flight2,
                                       List<String> hotels,
                                       List<List<String>> days) throws Exception {
            Configuration cfg=new Configuration(Configuration.VERSION_2_3_30);
            cfg.setDirectoryForTemplateLoading(new File("src/main/java"));
            cfg.setDefaultEncoding("UTF-8");

            Map<String, Object> map = new HashMap<String, Object>();



            map.put("Flight1", flight1);
            map.put("Flight2", flight2);
            map.put("Hotels", hotels);
            map.put("Days", days);

            String htmlStr = "";
            Template temp = cfg.getTemplate("itinerary_59.html");
            StringWriter sw= new StringWriter();
            BufferedWriter bf=new BufferedWriter(sw);
            temp.process(map,bf);
            htmlStr=sw.toString();
            bf.flush();
            bf.close();

            PDFGenerator generatorPDF = new PDFGenerator();

            String fileName = "./src/01.pdf";
            FileOutputStream out = new FileOutputStream(new File(fileName));

            generatorPDF.generatePDF(htmlStr, out);

            EmailSender emailSender = new EmailSender();
            String recipient=email;

            List<String> attachments = new ArrayList<String>();
            attachments.add(fileName);
            emailSender.sendEmail(recipient, attachments);
        }
    }


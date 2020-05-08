import Email.EmailSender;
import FlightObjects.Quote;
import HotelObjects.Data;
import PDF.PDFGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
    public  class SendEmail {

        public static void emailSender(String email,
                                       String flight1,
                                       String flight2,
                                       List<String> hotels,
                                       List<List<String>> days) throws Exception {

            System.out.println(email);
            System.out.println(flight1);
            System.out.println(flight2);
            System.out.println(hotels);
            System.out.println(days);
            Map<String, Object> map = new HashMap<String, Object>();



            map.put("title", "test 01");
            map.put("Flight1", flight1);
            map.put("Flight2", flight2);
            map.put("Hotels", hotels);
            map.put("Days", days);

            PDFGenerator generatorPDF = new PDFGenerator();
            String html = generatorPDF.getHtmlStr("./src/main/java/", "index.html", map);

            String fileName = "./src/01.pdf";
            FileOutputStream out = new FileOutputStream(new File(fileName));

            generatorPDF.generatePDF(html, out);

            EmailSender emailSender = new EmailSender();
            //String recipient=email;
            String recipient = "alexandrosco16@gmail.com";

            List<String> attachments = new ArrayList<String>();
            attachments.add(fileName);
            emailSender.sendEmail(recipient, attachments);
        }
    }


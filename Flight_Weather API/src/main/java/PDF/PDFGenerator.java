package PDF;

import com.lowagie.text.DocumentException;
import freemarker.template.*;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PDFGenerator {

    private static String filePath = "./src/main/java/";
    private static String fileName = "test.html";

    public String getHtmlStr(String filePath, String fileName, Map<String, Object> var) throws Exception {

        String htmlStr = "";
        try{
            File htmlFile = new File(filePath);
            Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            cfg.setDirectoryForTemplateLoading(htmlFile);
            cfg.setDefaultEncoding("UTF-8");

            // Sets how errors will appear.
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
            // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
            cfg.setLogTemplateExceptions(false);

            Template tp = cfg.getTemplate(fileName);
            StringWriter sWriter = new StringWriter();
            BufferedWriter bfWriter = new BufferedWriter(sWriter);
            // emerge the template with the data and store in writer
            tp.process(var, bfWriter);

            htmlStr = sWriter.toString();
            bfWriter.flush();
            bfWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return htmlStr;
    }


    public void generatePDF(String htmlStr, OutputStream out) throws Exception {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(htmlStr.getBytes()));
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(doc, null) ;
        renderer.layout();
        renderer.createPDF(out, false);
        renderer.finishPDF();
        out.close();

    }

    public List<String> getNewPDF(Map<String, Object> data, int fileNum) throws Exception{

        List<String> attachments = new ArrayList<String>();
        String html = getHtmlStr(filePath, fileName, data);
        try{
            for(int i=0;i<fileNum;i++){
                String fileName = "0" + i+".pdf";
                String filePath = "./src/" + fileName;
                FileOutputStream out = new FileOutputStream(new File(filePath));
                generatePDF(html, out);
                attachments.add(filePath);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return attachments;
    }

}


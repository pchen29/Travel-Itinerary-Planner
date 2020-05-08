package PDF;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import freemarker.template.*;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PDFGenerator {

    // the file path of the pdf template
    private static final String filePath = "./src/main/java/";
    // the file name of the pdf template
    private static final String fileName = "test.html";
    // the file path of final plans
    private static final String MERGED_PDF = "/sre/travel plans.pdf";

    /**
     *  emerge pdf template file with data
     *  transform the html file to string
     *
     * @param filePath
     * @param fileName
     * @param var
     * @return
     * @throws Exception
     */
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

    /**
     * generate pdf file
     *
     * @param htmlStr
     * @param out
     * @throws Exception
     */
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

    /**
     * grain the html string
     * generate pdf file
     * add files to the list of attachments
     *
     * @param dataList the list of multi-version plan
     * @return
     * @throws Exception
     */
    public List<String> getAttachmentsList(List<Map<String, Object>> dataList) throws Exception{

        List<String> attachments = new ArrayList<String>();
        try{
            for(int i=0;i<dataList.size();i++){
                String html = getHtmlStr(filePath, fileName, dataList.get(i));
                String fileName = "plan " + (i+1) +".pdf";
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

    /**
     * merge pdf files into one
     * @param files
     * @throws IOException
     */
    public void mergePDF(List<String> files) throws IOException {

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(MERGED_PDF));
        PdfMerger pdfMerger = new PdfMerger(pdfDoc);
        try{
            for(String file : files){
                System.out.println(files);
                PdfDocument pdf = new PdfDocument(new PdfReader(file));
                pdfMerger.merge(pdf, 1, pdf.getNumberOfPages());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        pdfMerger.close();
        pdfDoc.close();
    }

}


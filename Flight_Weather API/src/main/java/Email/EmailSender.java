package Email;

import PDF.PDFGenerator;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class EmailSender {

    private static String host = "smtp.gmail.com";
    private static String port = "465";
    private static String encoding = "UTF-8";

    /**
     * send email to a user with plans
     *
     * @param recipient the email address of recipient
     * @param data the data of multi-version plan
     */
    public void sendEmail(String recipient, List<Map<String, Object>> data) throws Exception {

        EmailInfo emailInfo = new EmailInfo();
        Properties props = new Properties();
        props.put("mail.smpt.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(props);

        /**
         * generate pdf files and
         * add their file path to attachment list
         */
        PDFGenerator generator = new PDFGenerator();
        List<String> attachments = generator.getAttachmentsList(data);

        try{// transport message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, emailInfo.getSender(), emailInfo.getPassword());
            MimeMessage message = createMessage(session, emailInfo.getSender(), recipient, attachments);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *create a message with the list of attachments
     *
     * @param session
     * @param sender
     * @param recipient
     * @param attachments
     * @return
     */
    private synchronized MimeMessage createMessage(Session session, String sender, String recipient, List<String>attachments){
        MimeMessage message = new MimeMessage(session);
        try {
            // set sender
            message.setFrom(new InternetAddress(sender, "Travel Planner", encoding));
            // set recipient
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipient, recipient,encoding));
            // set the subject of the email
            message.setSubject("Travel Plans", encoding);
            // add attachments
            Multipart multipart = new MimeMultipart();
            if(attachments.size() != 0){
                for(int i=0; i<attachments.size(); i++) {
                    String filePath = attachments.get(i);
                    MimeBodyPart bodyPart = new MimeBodyPart();
                    bodyPart.attachFile(filePath);
                    multipart.addBodyPart(bodyPart);
                }

                message.setContent(multipart);
            }
            else{
                System.out.println("can't find the file");
            }

            message.setSentDate(new Date());
            message.saveChanges();


        } catch (MessagingException e) {
            e.printStackTrace();
            Exception ex = null;
            if ((ex = e.getNextException()) != null) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }

}


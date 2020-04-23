package Email;

import java.util.List;

public class EmailInfo {

    // sender's email address
    private static String sender = "planyritinerary@gmail.com";
    // sender's email passport
    private static String password = "travelplan1";
    // recipient's email address
    private String recipient;
    // the file names of attachments
    private List<String> attachments;

    public EmailInfo(String recipient, List<String> attachments){
        this.attachments = attachments;
        this.recipient = recipient;
    }

    public static String getSender() {
        return sender;
    }

    public static String getPassword() {
        return password;
    }

    public String getRecipient() {
        return recipient;
    }

    public List<String> getAttachments() {
        return attachments;
    }
}

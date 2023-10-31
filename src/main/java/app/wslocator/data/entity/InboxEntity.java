package app.wslocator.data.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class InboxEntity {

    public InboxEntity(){}

    private int id;
    private String title;
    private String body;
    private String email;
    private String mobileNumber;
    LocalDateTime sendDate;
    String date;
    public InboxEntity(int id, String title, String body, String email, String mobileNumber, LocalDateTime sentDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.sendDate = sentDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        date = sendDate.format(formatter);
        

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public LocalDateTime getSendDate() {
        return sendDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }
    public String getdate() {
        return date;
    }
    public void setdate(String date) {
        this.date = date;
    }



    

    
}

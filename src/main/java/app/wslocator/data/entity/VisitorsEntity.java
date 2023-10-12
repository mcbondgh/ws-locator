package app.wslocator.data.entity;

public class VisitorsEntity {

    private int identifier;
    private String userAgent;
    private String ipAddress;
    private String location;
    private int pageVisits;
    public VisitorsEntity(int identifier, String userAgent, String ipAddress, String location, int pageVisits) {
        this.identifier = identifier;
        this.userAgent = userAgent;
        this.ipAddress = ipAddress;
        this.location = location;
        this.pageVisits = pageVisits;
    }
    public int getIdentifier() {
        return identifier;
    }
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
    public String getUserAgent() {
        return userAgent;
    }
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    public String getIPAddres() {
        return ipAddress;
    }
    public void setIPAddres(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getlocation() {
        return location;
    }
    public void setlocation(String location) {
        this.location = location;
    }
    public int getPageVisits() {
        return pageVisits;
    }
    public void setPageVisits(int pageVisits) {
        this.pageVisits = pageVisits;
    }

    


    
}

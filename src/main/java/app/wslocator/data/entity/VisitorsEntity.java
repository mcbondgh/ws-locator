package app.wslocator.data.entity;

public class VisitorsEntity {

    private int identifier;
    private String userAgent;
    private String IPAddres;
    private String locaation;
    private int pageVisits;
    public VisitorsEntity(int identifier, String userAgent, String iPAddres, String locaation, int pageVisits) {
        this.identifier = identifier;
        this.userAgent = userAgent;
        IPAddres = iPAddres;
        this.locaation = locaation;
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
        return IPAddres;
    }
    public void setIPAddres(String iPAddres) {
        IPAddres = iPAddres;
    }
    public String getLocaation() {
        return locaation;
    }
    public void setLocaation(String locaation) {
        this.locaation = locaation;
    }
    public int getPageVisits() {
        return pageVisits;
    }
    public void setPageVisits(int pageVisits) {
        this.pageVisits = pageVisits;
    }

    


    
}

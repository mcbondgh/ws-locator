package app.wslocator.data.entity;

public class RegionalAndDistrictEntity {


    
    public RegionalAndDistrictEntity(int regionId, int districtId, String regionName, String districtName,
            String capital, int size) {
        this.regionId = regionId;
        this.districtId = districtId;
        this.regionName = regionName;
        this.districtName = districtName;
        this.capital = capital;
        this.size = size;
    }


    private int regionId, districtId;
    public int getRegionId() {
        return regionId;
    }
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
    public int getDistrictId() {
        return districtId;
    }
    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }
    public String getRegionName() {
        return regionName;
    }
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    private String regionName, districtName, capital;
    private int size;


    

}//end of class...

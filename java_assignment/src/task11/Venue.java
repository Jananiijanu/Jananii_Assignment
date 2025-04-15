package task11;

public class Venue {
    private int venueId;
    private String venueName;
    private String address;
    private String location;

    
    public Venue(String venueName, String address) {
        this.venueName = venueName;
        this.address = address;
    }

  
    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

 
   

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

 
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getVenueName() { return venueName; }
    public String getLocation() { return location; }
}
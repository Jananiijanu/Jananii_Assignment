package task5;

	public class Sports extends Event {
	    private String sportName, teamsName;

	    public Sports() {}

	    public Sports(String eventName, String date, String time, int totalSeats, double ticketPrice, String venueName,
	                  String sportName, String teamsName) {
	        super(eventName, date, time, totalSeats, ticketPrice, venueName);
	        this.sportName = sportName;
	        this.teamsName = teamsName;
	    }

	    public void displayEventDetails() {
	        super.displayEventDetails();
	        System.out.println("Sport: " + sportName);
	        System.out.println("Teams: " + teamsName);
	    }
	}



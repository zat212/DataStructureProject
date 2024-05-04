package test_queue;

public class Patient {
	int ticketid;
	private String name;
	private int age;
	private String gender;
	private String appointmenttime;
	
	public Patient(int ticketid, String name, int age, String gender, String appointmenttime) {
		super();
		this.ticketid = ticketid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.appointmenttime = appointmenttime;
	}

	public int getTicketid() {
		return ticketid;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getAppointmenttime() {
		return appointmenttime;
	}

	@Override
	public String toString() {
		return "Patient ticketid = " + ticketid + ", name = " + name + ", age = " + age + ", gender = " + gender
				+ ", appointmenttime = " + appointmenttime;
	}
	
	
	
}

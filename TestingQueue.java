package test_queue;

import java.util.Scanner;

public class TestingQueue {	
    private static void showMenu() {
        System.out.println("Please Choose one");
        System.out.println("1. Enter Ticket information!");
        System.out.println("2. Check Patient total");
        System.out.println("3. Check the first Patient");
        System.out.println("4. To check the next patient");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
	private static void dequeuePatient(Queue<Patient> queue) {
		insertionSortQueue(queue);
		Patient orginP = queue.dequeue();
        System.out.println(orginP.toString());
    }
	private static void displayFirst(Queue<Patient> queue) {
		if(queue.first()==null) {
			System.out.println("You are the first person!!You can get the ticket!");
		}else {
		insertionSortQueue(queue);
		System.out.println(queue.first());
		}
	}
	public static void insertionSortQueue(Queue<Patient> queue) {
        Queue<Patient> sortedQueue = new SingleLL<>();
        while (!queue.isEmpty()){
           Patient currentPatient = queue.dequeue();
           while (!sortedQueue.isEmpty() && sortedQueue.first().getTicketid() > currentPatient.getTicketid()) {
                queue.enqueue(sortedQueue.dequeue());
            }
           sortedQueue.enqueue(currentPatient);
        }
        while (!sortedQueue.isEmpty()) {
            queue.enqueue(sortedQueue.dequeue());
        }
    }
    private static void enqueuePatient(Queue<Patient> queue,Scanner input) {
    	while(true) {
    		try {
    	System.out.print("Enter Your Ticket Id : ");
    	int tid = input.nextInt();
    	input.nextLine();
    	System.out.print("Enter Your Name : ");
    	String pName = input.nextLine();
    	System.out.print("Enter Your Age : ");
    	int pAge = input.nextInt();
    	input.nextLine();
    	System.out.print("Enter Your Gender : ");
    	String pGender = input.nextLine();
    	System.out.print("Enter Your AppointmentTime : ");
    	String ptime = input.nextLine();
    	Patient patient = new Patient(tid, pName, pAge, pGender, ptime);
        queue.enqueue(patient);
    	System.out.println("********Successful appointment************");
    	break;
    	}catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input! Please enter the correct data type.");
            input.nextLine();
        }
    }
  }
    public static void main(String[] args) {
		SingleLL<Patient> queue = new SingleLL<>();
		Scanner input = new Scanner(System.in);
		while (true) {
			showMenu();
			 try {
		            int userInput = input.nextInt();
		            input.nextLine(); 

		            switch (userInput) {
		                case 1:
		                    enqueuePatient(queue, input);
		                    break;
		                case 2:
		                	System.out.println("__________________________________");
		                    System.out.println("Total number of patients: " + queue.size() + " Patients");
		                    System.out.println("_______________________________________");
		                    break;
		                case 3:
		                	System.out.println("__________________________________");
		                    displayFirst(queue);
		                    System.out.println("_______________________________________");
		                    break;
		                case 4:
		                	if (!queue.isEmpty()) {
		                        dequeuePatient(queue);
		                        System.out.println("_______________________________________");
		                    } else {
		                    	System.out.println("__________________________________");
		                        System.out.println("There is no one!U can't check");
		                        System.out.println("__________________________________");
		                    }
		                    break;
		                case 5:
		                    System.out.println("Exiting the program.");
		                    input.close();
		                    System.exit(0);
		                default:
		                    System.out.println("Invalid choice. Please enter a valid option.");
		            }
		        } catch (java.util.InputMismatchException e) {
		            System.out.println("Invalid input! Please enter a valid integer choice.");
		            input.nextLine(); 
		        }
			}
		}
    }
		





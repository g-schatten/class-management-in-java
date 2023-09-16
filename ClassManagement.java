import java.util.Scanner;

class ClassManagement {
    public static String[] studentsId = {"S1", "S2", "S3"};
    public static String[] studentsName = {"A", "B", "C"};
    public static String[] teacherId = {"T1", "T2"};
    public static String[] teacherName = {"A", "B"};
    public static String[] courses = {"Course A", "Course B", "Course C"};
    public static int[] sections = {1, 2, 3};
    public static char[] timings = {'A', 'B', 'C'};
    public static boolean[][] studentEnrollments = new boolean[studentsId.length][courses.length];
    public static boolean[][] teacherAssignments = new boolean[teacherId.length][courses.length];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Who are you?");
            System.out.println("1. Student\n2. Teacher");
            int userType = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (userType == 1) {
                System.out.print("Provide Student ID: ");
                String studentId = scanner.nextLine();
                int studentIndex = -1;
                for (int i = 0; i < studentsId.length; i++) {
                    if (studentsId[i].equalsIgnoreCase(studentId)) {
                        studentIndex = i;
                        break;
                    }
                }

                if (studentIndex != -1) {
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    if (password.equals("password")) {
                        System.out.println("Welcome Student " + studentsName[studentIndex] + "!");
                        int choice;

                        do {
                            System.out.println("1. Add Course\n2. View Courses\n3. Logout");
                            choice = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character

                            switch (choice) {
                                case 1 -> {
                                    System.out.println("Available Courses:");
                                    for (int i = 0; i < courses.length; i++) {
                                        if (!studentEnrollments[studentIndex][i]) {
                                            System.out.println((i + 1) + ". " + courses[i]);
                                        }
                                    }
                                    System.out.println("0. Back");
                                    System.out.print("Select a course to enroll (0 to go back): ");
                                    int courseChoice = scanner.nextInt();
                                    if (courseChoice >= 1 && courseChoice <= courses.length) {
                                        int courseIndex = courseChoice - 1;
                                        if (!studentEnrollments[studentIndex][courseIndex]) {
                                            studentEnrollments[studentIndex][courseIndex] = true;
                                            System.out.println("You have been enrolled in " + courses[courseIndex] + " successfully!");
                                        } else {
                                            System.out.println("You are already enrolled in this course.");
                                        }
                                    } else if (courseChoice != 0) {
                                        System.out.println("Invalid input.");
                                    }
                                }
                                // Inside the student section
                                case 2 -> {
                                    System.out.println("Your Enrolled Courses:");
                                    int numEnrolledCourses = 0;
                                    for (int i = 0; i < courses.length; i++) {
                                        if (studentEnrollments[studentIndex][i]) {
                                            System.out.println((numEnrolledCourses + 1) + ". " + courses[i]);
                                            numEnrolledCourses++;
                                        }
                                    }
                                    if (numEnrolledCourses == 0) {
                                        System.out.println("No courses to show.");
                                    } else {
                                        System.out.println("0. Back");
                                        System.out.print("Select a course to remove (0 to go back): ");
                                        int courseSelected = scanner.nextInt();
                                        if (courseSelected >= 1 && courseSelected <= numEnrolledCourses) {
                                            int courseIndex = -1;
                                            int count = 0;
                                            for (int i = 0; i < courses.length; i++) {
                                                if (studentEnrollments[studentIndex][i]) {
                                                    count++;
                                                    if (count == courseSelected) {
                                                        courseIndex = i;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (courseIndex != -1) {
                                                studentEnrollments[studentIndex][courseIndex] = false;
                                                System.out.println("You have dropped " + courses[courseIndex] + " successfully.");
                                            }
                                        } else if (courseSelected != 0) {
                                            System.out.println("Invalid input.");
                                        }
                                    }
                                }
                                case 3 -> {
                                }
                                default -> System.out.println("Invalid choice.");
                            }
                        } while (choice != 3);
                    } else {
                        System.out.println("Incorrect password.");
                    }
                } else {
                    System.out.println("Student ID not found.");
                }
            } else if (userType == 2) {
                System.out.print("Provide Teacher ID: ");
                String teacherIdInput = scanner.nextLine();
                int teacherIndex = -1;
                for (int i = 0; i < teacherId.length; i++) {
                    if (teacherId[i].equalsIgnoreCase(teacherIdInput)) {
                        teacherIndex = i;
                        break;
                    }
                }

                if (teacherIndex != -1) {
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    if (password.equals("password")) {
                        System.out.println("Welcome Teacher " + teacherName[teacherIndex] + "!");
                        int choice;

                        do {
                            System.out.println("1. View Courses\n2. Logout");
                            choice = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character

                            switch (choice) {
                                case 1 -> {
                                    System.out.println("Courses Assigned to You:");
                                    boolean assigned = false;
                                    for (int i = 0; i < courses.length; i++) {
                                        if (teacherAssignments[teacherIndex][i]) {
                                            System.out.println(courses[i] + " - Section " + sections[i] + " - Timing " + timings[i]);
                                            assigned = true;
                                        }
                                    }
                                    if (!assigned) {
                                        System.out.println("No courses to show.");
                                    }
                                    System.out.println("0. Back");
                                }
                                case 2 -> {
                                }
                                default -> System.out.println("Invalid choice.");
                            }
                        } while (choice != 2);
                    } else {
                        System.out.println("Incorrect password.");
                    }
                } else {
                    System.out.println("Teacher ID not found.");
                }
            } else {
                System.out.println("Invalid user type.");
            }

            System.out.print("Do you want to continue (y/n)? ");
            String continueChoice = scanner.next();
            if (!continueChoice.equalsIgnoreCase("y")) {
                break;
            }
        }

        scanner.close();
    }
}

# class-management-in-java
this was done without oop (as per instruction)

Consider a class management system where courses offered for enrollment each have one or more sections. students can be registered in only one section of a particular course, given that the timing does not overlap with any previously registered course. after the enrollment is done successfully, they should be able to see the list of courses they are enrolled in. similarly, teachers should be able to see the list of sections they are assigned to and a list of students present in those sections.

develop a java program that will handle the mentioned requirements following the guidelines below(note: you cannot use oop concepts and can only use array, scanner and date library class):
1. separate each feature (adding or removing a course enrollment, viewing enrolled course list etc) into different method and keep the main() method concise
2. recognize the type of use using the system and design the program flow accordingly
3. place prompts for user appropriately
4. address a few error cases. for example, invalid inputs, making sure a student isn't being enrolled into different sections of the same course, course timings don't clash etc
5. put the entire program in an infinite loop and place option at every stage to go back to its previous stage
6. use meaningfull identifiers for methods and variables, use comments where necessary
7. using loops and arrays is a must

TEST DATABASE:
student id: S1, password:password, name: A
student id: S2, password:password, name: B
student id: S3, password:password, name: C
teacher id: T1, password:password, name: A
teacher id: T2, password:password, name: B
course name:Course A, section:1, timing:A, teacher name:T1
course name:Course A, section:2, timing:A, teacher name:T2
course name:Course A, section:3, timing:B, teacher name:T1
course name:Course B, section:1, timing:A, teacher name:T1
course name:Course C, section:1, timing:B, teacher name:T2
course name:Course C, section:2, timing:C, teacher name:T1

SAMPLE INPUT AND OUTPUT FOR TEACHER-

who are you?
1.Student 2.Teacher
>2
provide teacher id:>T1
password:>password
welcome teacher a!
1.view courses 2.logout
>1
1.course a 2.course b 3.course c 4.back
>1
list of students:
....
....
....
press 0 to go back
>0
1.course a 2.course b 3.course c 4.back

SAMPLE INPUT AND OUTPUT FOR STUDENT-

who are you?
1.student 2.teacher
>1
provide student id:>s1
password:>password
welcome student a!
1.add course 2.view course 3.back
>1
press 0 to go back
1.course a 2.course b 3.course c
course selected:>2
section selected:>1
you have been enrolled in "course b.1" successfully!
press 0 to go back
1.course a 2.course b 3.course c
course selected:>0
1.add course 2.view course 3.back
>2
1.course b //(not part of the input) print the currently enrolled course list
1.remove course 2.back
>1
index of course to be removed:>1
you have dropped "course b" successfully
no courses to show //(not part of the input) print the currently enrolled course list
1.back
>1
1.add course 2.view course 3.back
>

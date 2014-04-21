import java.util.Scanner;

/**
 * Created by Lappy486 on 4/20/14.
 */
public class BSTGUI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer = -0x01;
        BstObj BST = new BstObj();
        while (answer != 0) {
            System.out.println("Press 1 to insert a person in a binary tree");
            System.out.println("Press 2 to delete a person in a binary tree");
            System.out.println("Press 3 to find a person in a binary tree");
            System.out.println("Press 4 to print out the binary search tree");
            System.out.println("Press 5 to find the number the Person is in the tree");
            System.out.println("Press 0 to exit the program");
            answer = in.nextInt();

            if (answer == 1) {
                System.out.println("Please enter the persons first name");
                String firstName = in.next();
                System.out.println("Please enter the persons last name");
                String lastName = in.next();
                System.out.println("Please enter the persons age");
                int personAge = in.nextInt();
                System.out.println("Please enter the State initials the person was born in");
                String state = in.next();
                Person person = new Person(firstName, lastName, personAge, state);


                BST.insert(person);
                System.out.println("Person Inserted");

            }

            if (answer == 2) {
                System.out.println("Please enter the persons first name");
                String firstName = in.next();
                System.out.println("Please enter the persons last name");
                String lastName = in.next();
                System.out.println("Please enter the persons age");
                int personAge = in.nextInt();
                System.out.println("Please enter the State initials the person was born in");
                String state = in.next();
                Person person = new Person(firstName, lastName, personAge, state);
                BST.delete(person);
                System.out.println("Person Deleted");
            }
            if (answer == 3) {
                System.out.println("Please enter the persons first name");
                String firstName = in.next();
                System.out.println("Please enter the persons last name");
                String lastName = in.next();
                System.out.println("Please enter the persons age");
                int personAge = in.nextInt();
                System.out.println("Please enter the State initials the person was born in");
                String state = in.next();
                Person person = new Person(firstName, lastName, personAge, state);
                if (BST.find(person)) {
                    System.out.println("Person is in the Tree");
                }
                if (!BST.find(person)) {
                    System.out.println("Person is not in the Tree");
                }

            }
            if (answer == 4) {
                System.out.println(BST.nodesInOrder());
            }

            if (answer == 5) {
                int personNum = 0;
                String out = BST.nodesInOrder();

                System.out.println("What person do you want to find? (lastFirst format)");
                String per = in.next();

                if (!out.contains(per)) {
                    System.out.println(per + " is not in the tree");
                } else {
                    for (int i = 0; i < out.length(); i++) {
                        if (out.charAt(i) == ',') {
                            out = out.substring(0, out.charAt(i));
                            personNum++;
                            if (!out.contains(per)) {
                                System.out.println(per + " is the " + personNum + " person in the tree");
                                break;
                            }
                        }

                    }
                }
            }

        }

    }
}
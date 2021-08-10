import java.util.ArrayList;
import java.util.Scanner;

public abstract class Phonebook {
    protected ArrayList contactList;

    public void setContactList() {
        this.contactList = // contactList get from database
    }

    public abstract void display();
}

public class PhonebookTable extends Phonebook {

    @Override
    public void display() {
        for (Contact contact : contactList) {
            // display Contact in table
        }
    }
}

public class PhonebookInShortList extends Phonebook {

    @Override
    public void display() {
        for (Contact contact : contactList) {
            System.out.println("Name: " + contact.getName()
                    + ", Phone: " + contact.getPhone());
        }
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = null;
        System.out.println("\nChoose how display phonebook.\n" +
                "1 - in table\n" +
                "2 - in short list");
        int choice = scanner.nextInt();
        if (choice == 1) {
            phonebook = new PhonebookTable();
        } else if (choice == 2) {
            phonebook = new PhonebookInShortList();
        }
        phonebook.setContactList();
        phonebook.display();
    }
}






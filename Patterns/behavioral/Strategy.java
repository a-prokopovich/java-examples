
public class Phonebook {
    private ArrayList contactList;
    private DisplayStrategy displayStrategy;

    public void setContactList(ArrayList contactList) {
        this.contactList = contactList;
    }

    public void setDisplayStrategy(DisplayStrategy displayStrategy) {
        this.displayStrategy = displayStrategy;
    }

    public void display() {
        displayStrategy.display(contactList);
    }
}

public interface DisplayStrategy {
    void display(ArrayList contactList);
}

public class TableDisplayStrategy implements DisplayStrategy {

    @Override
    public void display(ArrayList contactList) {
        for (Contact contact : contactList) {
            // display Contact in table
        }
    }
}

public class DisplayInShortListStrategy implements DisplayStrategy {

    @Override
    public void display(ArrayList contactList) {
        for (Contact contact : contactList) {
            System.out.println("Name: " + contact.getName()
                                + ", Phone: " + contact.getPhone());
        }
    }
}

public class Main {

    public static void main(String[] args) {
        ArrayList<Contact> contactList = new ArrayList<>();
        // contactList get from database
        Phonebook phonebook = new Phonebook();
        phonebook.setContactList(contactList);
        DisplayStrategy displayStrategy = new TableDisplayStrategy();
        phonebook.setDisplayStrategy(displayStrategy);
        phonebook.display();
    }
}



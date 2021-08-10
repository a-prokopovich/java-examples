public interface PhonebookInterface {
    ContactIterator createContactIterator(Phonebook phonebook);
}

class Phonebook implements PhonebookInterface {
    private String city;
    private Contact contact;

    @Override
    public ContactIteratorImpl createContactIterator(Phonebook phonebook) {
        return new ContactIteratorImpl(this);
    }

    public String getCity() {
        return city;
    }
}

public interface ContactIterator {
    boolean hasNext();
    Contact getNext();
    void reset();
}

public class ContactIteratorImpl implements ContactIterator {
    private Phonebook phonebook;
    private List<Contact> contactList;
    private int currentPosition = 0;

    public ContactIteratorImpl(Phonebook phonebook) {
        this.phonebook = phonebook;
        contactList = new ArrayList<>();
    }

    private void load() {
        //get Contact from database to contactList
    }

    @Override
    public boolean hasNext() {
        load();
        return currentPosition < contactList.size();
    }

    @Override
    public Contact getNext() {
        if (!hasNext()) {
            return null;
        }
        Contact nextContact = contactList.get(currentPosition);
        currentPosition++;
        return nextContact;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}

public class Main {

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        ContactIterator iterator = phonebook.createContactIterator(phonebook);
        System.out.println("Phonebook " + phonebook.getCity());
        while (iterator.hasNext()) {
            System.out.println(iterator.getNext());
        }
    }
}



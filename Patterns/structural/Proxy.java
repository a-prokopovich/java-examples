
public interface Phonebook {
    void add(Contact contact);
    ArrayList<Contact> getAll();
    void open();
    void save();
}

//PhonebookProxy with locale Phonebook
public class PhonebookProxy implements Phonebook {
    private File file;
    private PhonebookImpl phonebook;
    private ArrayList<Contact> localeContactList;

    public PhonebookProxy(String filename) {
        file = new File(filename);
    }

    @Override
    public void open() {
        //get all contacts from file to localeContactList
    }

    @Override
    public void save() {
        if (phonebook != null) {
            phonebook.save();
        } else if (!localeContactList.isEmpty()) {
            open();
            phonebook.save();
        }
    }

    @Override
    public void add(Contact contact) {
        if (phonebook != null) {
            phonebook.add(contact);
        } else if (!localeContactList.contains(contact)) {
            localeContactList.add(contact);
        }
    }

    @Override
    public ArrayList<Contact> getAll() {
        if (phonebook == null) {
            open();
        }
        return phonebook.getAll();
    }
}

//real Phonebook
public class PhonebookImpl implements Phonebook {
    private File file;
    private ArrayList<Contact> contactList = new ArrayList<>();

    public PhonebookImpl(File newFile) {
        file = newFile;
        open();
    }

    @Override
    public void open() {
        //get all contacts from file
    }

    @Override
    public void save() {
        //save all contacts to file
    }

    @Override
    public void add(Contact contact) {
        if (!contactList.contains(contact)) {
            contactList.add(contact);
        }
    }

    @Override
    public ArrayList<Contact> getAll() {
        return contactList;
    }
}



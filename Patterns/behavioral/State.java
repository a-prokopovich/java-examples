
public interface State {
    void save();
    void edit();
}


public class PhonebookEditor {
    private State currentState;
    private ArrayList contactList;

    public PhonebookEditor(ArrayList contactList) {
        this.contactList = contactList;
    }

    public void save() {
        currentState.save();
    }

    public void edit() {
        currentState.edit();
    }

    public ArrayList getContactList() {
        return contactList;
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    private class DirtyState implements State {
        private State nextState;

        public DirtyState(State nextState) {
            this.nextState = nextState;
        }

        @Override
        public void save() {
            //save to database
            currentState = nextState;
        }

        @Override
        public void edit() { }
    }

    private class CleanState implements State {
        private State nextState;

        public CleanState() {
            this.nextState = new DirtyState(this);
        }

        @Override
        public void save() { }

        @Override
        public void edit() {
            currentState = nextState;
        }
    }
}


public class Main {

    public static void main(String[] args) {
        ArrayList<Contact> contactList = new ArrayList<>();
        // contactList get from database
        PhonebookEditor editor = new PhonebookEditor(contactList);
        Contact newContact = new Contct();
        //add new contact
        editor.addContact(newContact);
        editor.save();
    }
}



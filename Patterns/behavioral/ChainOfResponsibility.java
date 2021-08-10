public class Person {
    private String name;
    private Contact contact;
    private Address address;

    public Person(String name, Contact contact, Address address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }
}

public class Contact {
    private String phone;
    // and other fields

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

public class Address {
    private String city;
    // and other fields

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

public abstract class InputValidation {
    public InputValidation nextProcessor;

    public InputValidation(InputValidation nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public abstract boolean isInputValid(Object entity);
}


public class ContactValidation extends InputValidation {

    public ContactValidation(InputValidation nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isInputValid(Object entity) {
        if (entity instanceof Contact) {
            return isContactValid((Contact) entity);
        } else if (nextProcessor != null) {
            return nextProcessor.isInputValid(entity);
        }
        return false;
    }

    public boolean isContactValid(Contact contact) {
        return contact.getPhone().matches("[+\\d]{5}[-][\\d]{3}[-][\\d]{2}[-][\\d]{2}");
    }
}


public class AddressValidation extends InputValidation {

    public AddressValidation(InputValidation nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isInputValid(Object entity) {
        if (entity instanceof Address) {
            return isAddressValid((Address) entity);
        } else if (nextProcessor != null) {
            return nextProcessor.isInputValid(entity);
        }
        return false;
    }

    public boolean isAddressValid(Address contact) {
        return contact.getCity().matches("[A-Za-z]+");
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hi. Call your name: ");
        String name = scanner.nextLine();

        Contact contact = new Contact();
        System.out.print("Enter your contact: ");
        //enter contact
        contact.setPhone(scanner.nextLine());

        Address address = new Address();
        System.out.print("Enter your address: ");
        //enter contact
        address.setCity(scanner.nextLine());

        InputValidation inputValidation = new ContactValidation(null);
        if(inputValidation.isInputValid(contact) && inputValidation.isInputValid(address)) {
            Person person = new Person(name, contact, address);
        }
    }
}




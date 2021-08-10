public class BankCard {
    ...
}

public class DebitCard extends BankCard {
    ...
}

public class СreditCard extends BankCard {
    ...
}

public class Customer {
    String name;
    ...
    List<? extends BankCard> cards;
}

public class Address {
    private String country;
    private City city;
    private String street;
    private Date building;

    public Address(String country, City city, String street, Date building) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public void saveAddress() {
        // save to database
    }
}

// flyweight
public class City {
    private String name;
    private String index;
    private String phoneCode;

    public City(String name, String index, String phoneCode) {
        this.name = name;
        this.index = index;
        this.phoneCode = phoneCode;
    }
    //...
}

public class AddressFactory {
    static Map<String, City> cityMap = new HashMap<>();

    public static City getCity(String name, String index, String phoneCode) {
        City result = cityMap.get(name);
        if (result == null) {
            result = new City(name, index, phoneCode);
            cityMap.put(name, result);
        }
        return result;
    }
}




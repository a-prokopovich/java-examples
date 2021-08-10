
public Enum GeoLiteSingleton {
    INSTANCE;

    private String geoLiteLocation = "resourses/static/GeoLite2-Country_20210608";
    private String geoLiteName = "GeoLite2-Country.mmdb";

    private DatabaseReader buildDatabase() {
        File database = new File(geoLiteLocation, geoLiteName);
        return new DatabaseReader.Builder(database).build();
    }
}

public class GeoLiteService {

    public String findCountryByIpAddress(String ip) {
        try(DatabaseReader dbReader = GeoLiteSingleton.INSTANCE.buildDatabase()){
            InetAddress ipAddress = InetAddress.getByName(ip);
            CountryResponse response = dbReader.country(ipAddress);
            Country country = response.getCountry();
            nameCountry = country.getName();
        } catch(AddressNotFoundException e){
            e.printStacktrace();
        } catch(IOException|GeoIp2Exception e){
            e.printStacktrace();
        }
        return nameCountry;
    }
}

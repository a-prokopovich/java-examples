
import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface LocalDateTimeAttribute {
    EntityAttributeDateTime convertToLocalDateTime();
}

public class EntityAttributeDateTime {
    LocalDateTime dateTime;

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    //...
}

public class DateTimeAttributeAdapter implements LocalDateTimeAttribute {
    Timestamp dateTime;
    private EntityAttributeDateTime entityDateTime;

    public DateTimeAttributeAdapter(Timestamp dateTime) {
        this.dateTime = dateTime;
        this.entityDateTime = new EntityAttributeDateTime();
    }

    @Override
    public EntityAttributeDateTime convertToLocalDateTime() {
        entityDateTime.setDateTime(
                (dateTime == null) ? null : dateTime.toLocalDateTime());
        return entityDateTime;
    }
}

public class Main {

    public static void main(String[] args) {
        Timestamp dateTime;
        //dateTime = "get from database"
        DateTimeAttributeAdapter columnDateTime = new DateTimeAttributeAdapter(dateTime);
        EntityAttributeDateTime entityAttribute = columnDateTime.convertToLocalDateTime();
        System.out.println("Local datetime: " + entityAttribute.getDateTime());
    }
}




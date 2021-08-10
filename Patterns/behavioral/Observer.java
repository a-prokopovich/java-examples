
// publisher
public class Subject {
    protected ArrayList<RoomListener> listeners;

    public Subject() {
        listeners = new ArrayList<>();
    }

    public void subscribe(RoomListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(RoomListener listener) {
        listeners.remove(listener);
    }

    protected void notify(String bulbStatus) {
        listeners.forEach((listener) -> {
            listener.changedBulbStatus(bulbStatus);
        });
    }
}

// concrete publisher
public class Room extends Subject {
    private String name;
    private String country;
    private String bulbStatus;

    public String getBulbStatus() {
        return bulbStatus;
    }
}

public interface RoomListener {
    void changedBulbStatus(String bulbStatus);
}


public class ChangeRoomListener implements RoomListener {
    private String bulbStatus;

    @Override
    public void changedBulbStatus(String bulbStatus) {
        this.bulbStatus = bulbStatus;
        //save new bulbStatus in database

    }
}

public class Controller {

    public void changeBulbStatus() {
        Room room = new Room();
        RoomListener listener = new ChangeRoomListener();
        room.subscribe(listener);
        Room changedRoom = // room from client GUI
        if(!room.getBulbStatus().equals(changedRoom.getBulbStatus())) {
            room.notify(changedRoom.getBulbStatus());
        }
    }
}



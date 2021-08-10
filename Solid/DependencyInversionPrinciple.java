package com.prokopovich.roomswithbulbs.dao;

public interface RoomDao {
    Room create(Room newRoom);
    Room findOne(int id) throws DaoException;
}

public class RoomDaoImpl implements RoomDao {

    public Room create(Room newRoom) {
        ...
    }

    @Override
    public Room findOne(int id) {
        ...
    }
}

//////////////////////////////////////////////

package com.prokopovich.roomswithbulbs.service;

public class RoomService {

    private final RoomDao roomDao;

    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public Room addNewRoom(Room newRoom) {
        return roomDao.create(newRoom);
    }

    public Room getRoomById(int id) {
        return roomDao.findOne(id);
    }
}


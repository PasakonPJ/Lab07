package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import se331.lab.rest.dao.EventDao;
import se331.lab.rest.entity.Event;

import java.util.List;

public class EventServicelmpl implements EventService{

    @Autowired
    EventDao eventDao;
    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public List<Event> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize,page);
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }
}

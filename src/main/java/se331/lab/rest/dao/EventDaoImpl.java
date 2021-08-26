package se331.lab.rest.dao;

import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {
    List<Event> eventList;
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare tood")
                .title("Cat adoption Day ")
                .description("Find ur new feline friend at this event")
                .location("Meow town")
                .date("january 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Kat Laydee")
                .build());
        eventList.add(Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening tood")
                .description("Join us as we tend to the community edible plants.")
                .location("Meow town")
                .date("january 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Kat Laydee")
                .build());
        eventList.add(Event.builder()
                .id(789L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Carey Wales")
                .build());
        eventList.add(Event.builder()
                .id(1001L)
                .category("animal welfare")
                .title("Dog Adoption Day")
                .description("Find your new canine friend at this event.")
                .location("Woof Town")
                .date("August 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Dawg Dahd")
                .build());
        eventList.add(Event.builder()
                .id(1002L)
                .category("food")
                .title("Canned Food Drive ")
                .description("Bring your canned food to donate to those in need.")
                .location("Tin City")
                .date("September 14, 2022")
                .time("3:00")
                .petAllowed(true)
                .organizer("Kahn Opiner")
                .build());
        eventList.add(Event.builder()
                .id(1003L)
                .category("sustainability")
                .title("Highway Cleanup ")
                .description("Help pick up trash along the highway.")
                .location("Highway 50")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer("Brody Kill")
                .build());
//////////////////////5.7///////////////
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .name("Peter")
                .address("Nan")
                .build());
        organizerList.add(Organizer.builder()
                .id(2L)
                .name("rimuru temp")
                .address("Japan")
                .build());
        organizerList.add(Organizer.builder()
                .id(3L)
                .name("Spider man")
                .address("England")
                .build());
        organizerList.add(Organizer.builder()
                .id(4L)
                .name("Naruto Usumaki")
                .address("Japan")
                .build());
        organizerList.add(Organizer.builder()
                .id(5L)
                .name("Conan")
                .address("Hawaii")
                .build());
        organizerList.add(Organizer.builder()
                .id(6L)
                .name("Somchai jaipain")
                .address("Thailand")
                .build());
    }

    @Override
    public Integer getEventSize() {
        return eventList.size();
    }

    @Override
    public List<Event> getEvents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return eventList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Event getEvent(Long id) {
        return eventList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
    }

// 5.7/////////////////////////////////

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
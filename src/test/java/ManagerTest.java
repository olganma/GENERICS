import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Ticket ticket1 = new Ticket(123, 2000, "DME", "DME", 115);
    Ticket ticket2 = new Ticket(124, 1330, "VKO", "VKO", 105);
    Ticket ticket3 = new Ticket(139, 1400, "DME", "VKO", 90);
    Ticket ticket4 = new Ticket(135, 1500, "VKO", "DME", 100);
    Ticket ticket5 = new Ticket(185, 1000, "DME", "VKO", 130);
    Ticket ticket6 = new Ticket(1567, 900, "DME", "VKO", 180);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void ShouldSearchOne() {
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.searchBy("DME", "DME");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchFewAndSort() {
        Ticket[] expected = {ticket6, ticket5, ticket3};
        Ticket[] actual = manager.searchBy("DME", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchNone() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("SVO", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }
}
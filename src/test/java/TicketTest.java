import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    public void ShouldGetParams() {
        Ticket ticket1 = new Ticket(123, 2000, "DME", "DME", 115);
        Assertions.assertEquals(123, ticket1.getId());
        Assertions.assertEquals(2000, ticket1.getPrice());
        Assertions.assertEquals("DME", ticket1.getFrom());
        Assertions.assertEquals("DME", ticket1.getTo());
        Assertions.assertEquals(115, ticket1.getMinutes());
    }

    @Test
    public void ShouldSetID() {
        Ticket ticket1 = new Ticket(123, 2000, "DME", "DME", 115);
        ticket1.setId(124);
        Assertions.assertEquals(124, ticket1.getId());
    }

    @Test
    public void ShouldSetPrice() {
        Ticket ticket1 = new Ticket(123, 2000, "DME", "DME", 115);
        ticket1.setPrice(1000);
        Assertions.assertEquals(1000, ticket1.getPrice());
    }

    @Test
    public void ShouldSetFrom() {
        Ticket ticket1 = new Ticket(123, 2000, "DME", "DME", 115);
        ticket1.setFrom("VKO");
        Assertions.assertEquals("VKO", ticket1.getFrom());
    }

    @Test
    public void ShouldSetTo() {
        Ticket ticket1 = new Ticket(123, 2000, "DME", "DME", 115);
        ticket1.setTo("VKO");
        Assertions.assertEquals("VKO", ticket1.getTo());
    }

    @Test
    public void ShouldSetMinutes() {
        Ticket ticket1 = new Ticket(123, 2000, "DME", "DME", 115);
        ticket1.setMinutes(120);
        Assertions.assertEquals(120, ticket1.getMinutes());
    }

    @Test
    public void ShouldCompareIfFirstMLess() {
        Ticket ticket1 = new Ticket(123, 1000, "DME", "DME", 115);
        Ticket ticket2 = new Ticket(124, 1330, "VKO", "VKO", 105);
        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
    }

    @Test
    public void ShouldCompareIfFirstMore() {
        Ticket ticket1 = new Ticket(123, 2000, "DME", "DME", 115);
        Ticket ticket2 = new Ticket(124, 1330, "VKO", "VKO", 105);
        Assertions.assertEquals(1, ticket1.compareTo(ticket2));
    }

    @Test
    public void ShouldCompareIfEqual() {
        Ticket ticket1 = new Ticket(123, 1000, "DME", "DME", 115);
        Ticket ticket2 = new Ticket(124, 1000, "VKO", "VKO", 105);
        Assertions.assertEquals(0, ticket1.compareTo(ticket2));
    }

}
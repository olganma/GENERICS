import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Ticket ticket1 = new Ticket(123, 2000, "DME", "DME", 115);
    Ticket ticket2 = new Ticket(124, 1330, "VKO", "VKO", 105);
    Ticket ticket3 = new Ticket(139, 1400, "DME","VKO", 90);
    Ticket ticket4 = new Ticket(135, 1500, "VKO","DME", 100);
    Ticket ticket5 = new Ticket(185, 1000, "DME","VKO", 130);

    @Test
    public void ShouldRemoveProductIfIdExits() {
        Repository repo = new Repository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.removeById(ticket2.getId());
        Ticket[] expected = {ticket1, ticket3, ticket4};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
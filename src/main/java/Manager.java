import java.util.Arrays;

public class Manager {

    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public boolean matchesFrom(Ticket ticket, String search) {
        return ticket.getFrom().contains(search);
    }

    public boolean matchesTo(Ticket ticket, String search) {
        return ticket.getTo().contains(search);
    }

    public Ticket[] searchBy(String textFrom, String textTo) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        for (Ticket ticket : repo.findAll()) {
            if (matchesFrom(ticket, textFrom) && matchesTo(ticket, textTo)) {
                Ticket tmp[] = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}

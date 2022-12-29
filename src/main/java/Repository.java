public class Repository {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket product) {
        Ticket tmp[] = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = product;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public void removeById(int id) {
        Ticket tmp[] = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket product : tickets) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

}

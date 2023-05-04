import java.util.*;

public class Test {
    private static Map<Account, Client> clientMap = createClientMap();

    public static void main(String[] args) {
        Client ivanov = new Client("Иванов", 25);
        long start1 = System.currentTimeMillis();
        System.out.println(getAccounts(ivanov));

        long end1 = System.currentTimeMillis();
        long difference1 = end1 - start1;

        System.out.println("--------------------------------------");

        long start2 = System.currentTimeMillis();
        System.out.println(getAccountsStream(ivanov));
        long end2 = System.currentTimeMillis();
        long difference2 = end2-start2;

        System.out.println("Метод getAccounts нашёл "+getAccounts(ivanov).size()+" аккаунтов");
        System.out.println("Метод getAccountStream нашёл "+getAccountsStream(ivanov).size()+" аккаунтов");
        System.out.println();

        System.out.println("Метод getAccounts работал: "+difference1);
        System.out.println("Метод getAccountsStream работал: "+difference2);
    }
    public static List<Account> getAccounts(Client client) {
        List<Account> result = new ArrayList<>();
        for (Map.Entry<Account, Client> pair : clientMap.entrySet()) {
            if (pair.getValue().equals(client))
                result.add(pair.getKey());
        }
        return result;
    }
    public static List<Account> getAccountsStream(Client client) {
        List<Account> result = new ArrayList<>();
        int i = 0;
        clientMap.entrySet().stream().filter(a->a.getValue().equals(client)).forEach(entry->result.add(entry.getKey()));
        return result;
    }
    public static HashMap<Account, Client> createClientMap() {
        HashMap<Account, Client> map = new HashMap<>();
        List<Client> clients = new ArrayList<>();

        Client ivanov = new Client("Иванов", 25);
        Client petrov = new Client("Петров", 30);
        Client sidorov = new Client("Сидоров", 35);
        Client andreev = new Client("Андреев", 40);
        Client alekseev = new Client("Алексеев", 45);
        Client matveev = new Client("Матвеев", 20);
        Client vladimirov = new Client("Владимиров", 50);
        Client bystrov = new Client("Быстров", 55);

        clients.add(ivanov);
        clients.add(petrov);
        clients.add(sidorov);
        clients.add(andreev);
        clients.add(alekseev);
        clients.add(matveev);
        clients.add(vladimirov);
        clients.add(bystrov);

        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int index = random.nextInt(8);
            Client client = clients.get(index);
            Account account = new Account();
            map.put(account,client);
        }


        return map;
    }
}
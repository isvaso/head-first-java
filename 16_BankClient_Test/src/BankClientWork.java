public class BankClientWork {

    public static void main(String[] args) {

        int clientsCount = 6;
        Client[] cl = new Client[clientsCount];

        cl[0] = new ClientBasic();
        cl[0].setName("Angelo Bitters");
        cl[0].setAge(34);
        cl[0].setBill(500);

        cl[1] = new ClientPremium();
        cl[1].setName("Bill Arc");
        cl[1].setAge(56);
        cl[1].setBill(10000000);

        cl[2] = new ClientPremium();
        cl[2].setAge(48);
        cl[2].setBill(999999999);

        cl[3] = new ClientExtended();
        cl[3].setName("Vasily Egorov");
        cl[3].setAge(28);
        cl[3].setBill(3500);

        cl[4] = new ClientBasic();
        cl[4].setName("Egor Erorich");
        cl[4].setAge(22);
        cl[4].setBill(200);

        cl[5] = new ClientExtended();
        cl[5].setName("Olga Ivanova");
        cl[5].setAge(32);
        cl[5].setBill(2300);

        for (Client c : cl) {//set investors

            if (c instanceof ClientExtended && c.getName().equals("Olga Ivanova")) {//if c's class is ClientExtended and...
                ((ClientExtended) c).setIsInvestor(true);//cast c to ClientExtended and set setIsInvestor = true
            }

            if (c instanceof ClientPremium && c.getName().equals("Ara Dzgan")) {//if c's class is ClientPremium and...
                ((ClientPremium) c).setIsInvestor(true);//cast c to ClientExtended and set setIsInvestor = true
            }

        }

        for (Client c : cl) {//fee for month for every client of bank
            int m = c.getBill() - c.getFee();
            System.out.println(c.getName() + " your fee for month is " + c.getFee() + ".00$. Next month your bill will have " + m + ".00$.");
        }
    }
}

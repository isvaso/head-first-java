import java.io.*;

public class PortfolioTest {

    public static void main(String[] args) {

        StockInstrument aapl = new StockInstrument("Apple Inc.", "AAPL", new int[] {14560, 14600, 14600, 14600, 14450});
        StockInstrument nvda = new StockInstrument("Nvidia Corp.", "NVDA", new int[] {18800, 18800, 18688, 18688, 18500, 18500});
        StockInstrument tsla = new StockInstrument("Tesla Inc.", "TSLA", new int[] {70400, 70400, 72000, 69000});
        int portfolioValue;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Portfolio.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(aapl);
            outputStream.writeObject(nvda);
            outputStream.writeObject(tsla);
        } catch (IOException e) {
            e.printStackTrace();
        }

        aapl = null;
        nvda = null;
        tsla = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("Portfolio.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            StockInstrument recieveAapl = (StockInstrument) objectInputStream.readObject();
            StockInstrument recieveNvda = (StockInstrument) objectInputStream.readObject();
            StockInstrument recieveTsla = (StockInstrument) objectInputStream.readObject();

            aapl = recieveAapl;
            nvda = recieveNvda;
            tsla = recieveTsla;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        portfolioValue = aapl.getSumCost() + nvda.getSumCost() + tsla.getSumCost();

        System.out.println("Title: " + aapl.getTitle() + "\nTicket: " + aapl.getTicket() + "\nAmount: " + aapl.getAmount() + "\nAverage Cost: $" + (float)aapl.getAverageCost()/100 + "\n");
        System.out.println("Title: " + nvda.getTitle() + "\nTicket: " + nvda.getTicket() + "\nAmount: " + nvda.getAmount() + "\nAverage Cost: $" + (float)nvda.getAverageCost()/100 + "\n");
        System.out.println("Title: " + tsla.getTitle() + "\nTicket: " + tsla.getTicket() + "\nAmount: " + tsla.getAmount() + "\nAverage Cost: $" + (float)tsla.getAverageCost()/100 + "\n");
        System.out.println("Portfolio Value: $" + (float)portfolioValue/100);
    }
}

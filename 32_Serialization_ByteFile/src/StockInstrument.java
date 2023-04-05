import java.io.*;

public class StockInstrument implements Serializable {

    private String title;
    private String ticket;
    private int[] costBasisList; // then costBasis / 100!

    public StockInstrument(String setTitle, String setTicket, int[] setCostBasis) {
        title = setTitle;
        ticket = setTicket;
        costBasisList = setCostBasis;
    }

    public void addCostBasis(int newCostBasis) {
        int newBasisListIndex = costBasisList.length + 1;
        costBasisList[newBasisListIndex] = newCostBasis;
    }

    public String getTitle() {
        return title;
    }

    public String getTicket() {
        return ticket;
    }

    public int[] getCostBasisList() {
        return costBasisList;
    }

    public int getAverageCost() {
        int sumCost = 0;
        int amount = costBasisList.length;
        int average;

        for (int singleCostBasis : costBasisList) {
            sumCost += singleCostBasis;
        }

        average = sumCost/amount;

        return average;
    }

    public int getSumCost() {
        int sumCost = 0;

        for (int singleCostBasis : costBasisList) {
            sumCost += singleCostBasis;
        }
        return sumCost;
    }

    public int getAmount() {
        return costBasisList.length;
    }

}

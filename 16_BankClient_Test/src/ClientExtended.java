public class ClientExtended extends Client implements Investor {

    private static final  int FEE = 4; //price
    private static final  int INVESTOR_FEE = 1; //add price for investor
    private boolean isInvestor = false;

    public ClientExtended() {
        System.out.println("Create Extended.");
    }

    @Override
    public int getFee() {
        return FEE+getInvestorFee();
    }

    public int getInvestorFee() {
        int f = 0;
        if (isInvestor) {
            f = INVESTOR_FEE;
        } else {
            f = 0;
        }
        return f;
    }

    public void setIsInvestor(boolean s) {
        isInvestor = s;
    }

    public boolean getIsInvestor() {
        return isInvestor;
    }
}

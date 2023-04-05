public class ClientBasic extends Client {

    private static final  int FEE = 3; //price

    public ClientBasic() {
        //super();
        System.out.println("Create Basic.");
    }

    @Override
    public int getFee() {

        return FEE;
    }
}

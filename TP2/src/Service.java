public class Service {

    private int nbUse;

    public Service() {
        this.nbUse = 0;
    }

    public int cost(){
        return 0;
    }

    public void execute(){

    }

    public int getNumberOfUse() {
        return nbUse;
    }

    /** The user uses this service . The user has to pay this service ’s cost .
    ∗ @param user the user of this service
    ∗ @throws NotEnoughMoneyException if the user has not enough money
    ∗                                 to pay this service ’s cost
    */
    public void isUsedBy(ServiceUser serviceUser) throws NotEnoughMoneyException{

    }
}

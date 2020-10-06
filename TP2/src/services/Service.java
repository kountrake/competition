package services;

/**
 * The type exercice1.Service.
 */
public class Service {

    private int nbUse;

    /**
     * Instantiates a new exercice1.Service.
     */
    public Service() {
        this.nbUse = 0;
    }

    /**
     * Cost int.
     *
     * @return the int
     */
    public int cost(){
        return 0;
    }

    /**
     * Execute.
     */
    public void execute(){

    }

    /**
     * Gets number of use.
     *
     * @return the number of use
     */
    public int getNumberOfUse() {
        return nbUse;
    }

    /**
     * The user uses this service . The user has to pay this service ’s cost .
     * ∗ @param user the user of this service
     * ∗ @throws exercice1.NotEnoughMoneyException if the user has not enough money
     * ∗                                 to pay this service ’s cost
     *
     * @param serviceUser the service user
     * @throws NotEnoughMoneyException the not enough money exception
     */
    public void isUsedBy(ServiceUser serviceUser) throws NotEnoughMoneyException{
        serviceUser.decreaseMoney(cost());
        if (serviceUser.getMoney()<0){
            serviceUser.decreaseMoney(-(cost())); //Give the money back before throwing Exception
            throw new NotEnoughMoneyException("Not enough money..");
        }
        nbUse++;
    }
}

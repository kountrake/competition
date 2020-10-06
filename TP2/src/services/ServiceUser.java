package services;

/**
 * The type exercice1.Service user.
 */
public class ServiceUser {

    private int money;

    /**
     * Instantiates a new exercice1.Service user.
     *
     * @param money the money
     */
    public ServiceUser(int money) {
        this.money = money;
    }

    /**
     * Gets money.
     *
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Decrease money.
     *
     * @param money the money
     */
    public void decreaseMoney(int money) {
        this.money -= money;
    }
}

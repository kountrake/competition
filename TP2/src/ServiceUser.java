public class ServiceUser {

    private int money;

    public ServiceUser(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void decreaseMoney(int money) {
        this.money -= money;
    }
}

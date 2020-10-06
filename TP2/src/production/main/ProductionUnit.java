package production.main;

/**
 * The type Production unit.
 */
public class ProductionUnit {

    /**
     * The Processed products.
     */
    protected int processedProducts;
    /**
     * The Available resources.
     */
    protected int availableResources;

    /**
     * Instantiates a new Production unit.
     */
    public ProductionUnit() {
        processedProducts = 0;
    }

    /**
     * Operate.
     *
     * @param product the products
     */
    public void operate(ManufactureProducts product){
        try {
            process(product);
            processedProducts++;
        } catch (ProductionProblemException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets available resources.
     *
     * @return the available resources
     */
    public int getAvailableResources() {
        return availableResources;
    }

    /**
     * Add available resources.
     *
     * @param availableResources the available resources
     */
    public void addAvailableResources(int availableResources) {
        this.availableResources += availableResources;
    }

    /**
     * Gets processed products.
     *
     * @return the processed products
     */
    public int getProcessedProducts() {
        return processedProducts;
    }

    /**
     * Process.
     *
     * @param product the products
     */
    public void process(ManufactureProducts product) throws ProductionProblemException{
        if (product.requiredResourceQuantity()>getAvailableResources()){
            throw new ProductionProblemException();
        }
        addAvailableResources(-(product.requiredResourceQuantity()));
        product.increaseProductionDuration(getProductionDuration());
    }

    /**
     * Get production duration int.
     *
     * @return the int
     */
    public int getProductionDuration(){
        return 0;
    }

    /**
     * Handle product process.
     *
     * @param products the products
     */
    protected void handleProductProcess(ManufactureProducts products){

    }
}

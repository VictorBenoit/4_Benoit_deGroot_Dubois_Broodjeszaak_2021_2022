package domain.model;

//Brinio 2-12: klasse beleg voor het aanmaken van een beleg en de nodige informatie op te vragen, setters en getters zijn toegevoegd


public class Beleg {

    private String name;
    private double price;
    private int amount;
    private int sales;

    public Beleg(String name, double price, int amount, int sales) {
        setName(name);
        setPrice(price);
        setAmount(amount);
        setSales(sales);
    }

    public void aanPassenVoorraad() {
        amount--;
    }

    public void aanPassenVerkoop() {
        sales++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getSales() {
        return sales;
    }
}

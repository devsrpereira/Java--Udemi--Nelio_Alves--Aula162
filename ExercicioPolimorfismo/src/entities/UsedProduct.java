package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    private LocalDate manufactorDate;

    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsedProduct(){super();}
    public UsedProduct(String name, Double price, LocalDate manufactorDate) {
        super(name, price);
        this.manufactorDate = manufactorDate;
    }

    public LocalDate getManufactorDate() {
        return manufactorDate;
    }
    public void setManufactorDate(LocalDate manufactorDate) {
        this.manufactorDate = manufactorDate;
    }

    @Override
    public String priceTag() {
        return getName() + " (used) $ " + String.format("%.2f",getPrice()) + " (Manufacture date: " + dtf1.format(getManufactorDate())+ ")";
    }
}

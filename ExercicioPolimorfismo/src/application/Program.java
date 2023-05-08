package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> productList = new ArrayList<>();

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i+1) + " data: ");
            System.out.print("Commun, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if (ch == 'i'){
                System.out.print("Custom fee: ");
                Double customsFee = sc.nextDouble();
                Product product = new ImportedProduct(name,price, customsFee);
                productList.add(product);
            } else if(ch == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(sc.next(),dtf1) ;
                Product product = new UsedProduct(name,price, manufactureDate);
                productList.add(product);
            } else {
                Product product = new Product(name, price);
                productList.add(product);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product x : productList) {
            System.out.println(x.priceTag());
        }

        System.out.println();


        sc.close();
    }
}

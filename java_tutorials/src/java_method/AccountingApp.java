package java_method;

public class AccountingApp {

    public static double valueOfSupply = 10000.0;

    public static double vatRate = 0.1;

    public static double getVAT() {
        return valueOfSupply * vatRate;
    }
    public static double getTotal(){
        return valueOfSupply + getVAT();
    }

    public static void main(String[] args){
        double valueofSupply = 10000.0;
        double vatRate = 0.1;
        double vat = valueofSupply * vatRate;
        double total = valueofSupply + vat;

        System.out.println("Value of supply: "+ valueofSupply);
        System.out.println("VAT: "+ vat);
        System.out.println("Total: " + total);
    }
}

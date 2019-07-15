package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order o) {
        this.order = o;
    }

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        // print headers
        receipt.append("======Printing Orders======\n");

        // print date, bill no, customer name
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());

        // prints lineItems
        double totalSalesTax = 0d;
        double totalAmountIncludeTax = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getDescription());
            receipt.append('\t');
            receipt.append(lineItem.getPrice());
            receipt.append('\t');
            receipt.append(lineItem.getQuantity());
            receipt.append('\t');
            receipt.append(lineItem.totalAmount());
            receipt.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmountIncludeTax += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        receipt.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        receipt.append("Total Amount").append('\t').append(totalAmountIncludeTax);
        return receipt.toString();
    }
}
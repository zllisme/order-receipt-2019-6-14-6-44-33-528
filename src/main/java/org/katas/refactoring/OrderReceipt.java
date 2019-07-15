package org.katas.refactoring;

import java.security.PublicKey;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    private StringBuilder receipt
            = new StringBuilder("======Printing Orders======\n");

    private double totalSalesTax = 0d;

    private double totalAmountIncludeTax = 0d;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        // print headers
        createHeaderReceipt();
        // prints lineItems
        createMiddleReceiptAndCalTail();

        // prints the state tax
        createTailReceipt();

        return receipt.toString();
    }

    private void createMiddleReceiptAndCalTail() {
        for (LineItem lineItem : order.getLineItems()) {
            createLineItemReceipt(lineItem);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmountIncludeTax += lineItem.totalAmount() + salesTax;
        }
    }

    private void createLineItemReceipt(LineItem lineItem) {
        receipt.append(lineItem.getDescription()).append('\t')
                .append(lineItem.getPrice()).append('\t')
                .append(lineItem.getQuantity()).append('\t')
                .append(lineItem.totalAmount()).append('\n');
    }

    private void createHeaderReceipt() {
        receipt.append(order.getCustomerName())
                .append(order.getCustomerAddress());
    }

    private void createTailReceipt() {
        receipt.append("Sales Tax\t").append(totalSalesTax )
                .append("Total Amount\t").append(totalAmountIncludeTax);
    }
}
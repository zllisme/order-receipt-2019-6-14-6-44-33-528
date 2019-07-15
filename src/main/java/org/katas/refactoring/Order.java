package org.katas.refactoring;

import java.util.List;

public class Order {
    private String customerName;
    private String CustomerAddress;
    private List<LineItem> LineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        CustomerAddress = customerAddress;
        LineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public List<LineItem> getLineItems() {
        return LineItems;
    }
}

package org.katas.refactoring;

import java.util.List;

public class Order {
    private String nm;
    private String addr;
    private List<LineItem> li;

    public Order(String nm, String addr, List<LineItem> li) {
        this.nm = nm;
        this.addr = addr;
        this.li = li;
    }

    public String getCustomerName() {
        return nm;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return li;
    }
}

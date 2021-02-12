package org.epoch.fact;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class Address {
    private String addressLine1;

    public Address(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Override
    public String toString() {
        return "Address{" + "addressLine1=" + addressLine1 + '}';
    }

}

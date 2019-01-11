package based.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollection {
    List addressList;
    Set addressSet;
    Map addressMap;
    Properties addressProp;

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    public List getAddressList(){
        System.out.println("List Elemetns : " + addressList);
        return addressList;
    }

    public Properties getAddressProp() {
        System.out.println("Properties Elemetns : " + addressList);
        return addressProp;
    }

    public Map getAddressMap() {
        System.out.println("Map Elemetns : " + addressList);
        return addressMap;
    }

    public Set getAddressSet() {
        System.out.println("Set Elemetns : " + addressList);
        return addressSet;
    }
}

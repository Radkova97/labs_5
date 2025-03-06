package phones;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class FindPhone {
    private List<Phone> data=new PhoneDB().getPhoneData();
    
    public List<Phone> byColor(Color col) {
        List<Phone> find=new LinkedList<>();
        for(Phone ph : data)
            if (ph.getColor()==col)   find.add(ph);
        return find;
    }
    
    public List<Phone> byModel(String mod) {
        List<Phone> find=new LinkedList<>();
        for(Phone ph : data)
            if (ph.getModel().equalsIgnoreCase(mod))   find.add(ph);
        return find;
    }
    
    public List<Phone> byMSize(int memSize) {
        List<Phone> find=new LinkedList<>();
        for(Phone ph : data)
            if (ph.getMemorySize()==memSize)   find.add(ph);
        return find;
    }
    
    public List<Phone> byModelAndPriceLow(String mod, double price) {
        List<Phone> find=new LinkedList<>();
        for(Phone ph : data)
            if (ph.getModel().equalsIgnoreCase(mod) &&
                                ph.getPrice()<price)   find.add(ph);
        return find;
    }
    
    public List<Phone> byMSizeAndNotColor(int memSize, Color col) {
        List<Phone> find=new LinkedList<>();
        for(Phone ph : data)
            if (ph.getMemorySize()==memSize && !(ph.getColor()==col))   find.add(ph);
        return find;
    }    
}

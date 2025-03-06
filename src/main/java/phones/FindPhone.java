package phones;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class FindPhone {
    private List<Phone> data = new PhoneDB().getPhoneData();

    public List<Phone> findByCriteria(List<Tag> criteria) {
        List<Phone> result = new ArrayList<>();
        for (Phone ph : data) {
            boolean matches = true;
            for (Tag tag : criteria) {
                if (!tag.find(ph)) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                result.add(ph);
            }
        }
        return result;
    }

    public List<Phone> byModelAndPriceLowAndColor(String mod, double price, Color color) {
        List<Tag> criteria = new ArrayList<>();
        criteria.add(new ModelTag(mod));
        criteria.add(new PriceTag(price));
        criteria.add(new ColorTag(color));
        return findByCriteria(criteria);
    }
}

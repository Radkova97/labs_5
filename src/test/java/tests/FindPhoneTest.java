package tests;

import org.junit.Test;
import phones.*;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FindPhoneTest {

    private final FindPhone findPhone = new FindPhone();

    @Test
    public void byColorTest() {
        List<Tag> criteria = new ArrayList<>();
        criteria.add(new ColorTag(Color.RED));

        List<Phone> result = findPhone.findByCriteria(criteria);
        assertEquals(3, result.size()); // Проверяем, что найдено 3 телефона красного цвета
    }
    @Test
    public void byModelTest() {
        List<Tag> criteria = new ArrayList<>();
        criteria.add(new ModelTag("vokii"));

        List<Phone> result = findPhone.findByCriteria(criteria);
        assertEquals(4, result.size()); // Проверяем, что найдено 4 телефона модели "vokii"
    }
    @Test
    public void byMemorySizeTest() {
        List<Tag> criteria = new ArrayList<>();
        criteria.add(new Tag() {
            @Override
            public boolean find(Phone ph) {
                return ph.getMemorySize() == 64;
            }
        });

        List<Phone> result = findPhone.findByCriteria(criteria);
        assertEquals(2, result.size()); // Проверяем, что найдено 2 телефона с памятью 64 ГБ
    }
    @Test
    public void byModelAndPriceLowTest() {
        List<Tag> criteria = new ArrayList<>();
        criteria.add(new ModelTag("vokii"));
        criteria.add(new PriceTag(13000));

        List<Phone> result = findPhone.findByCriteria(criteria);
        assertEquals(2, result.size()); // Проверяем, что найдено 2 телефона "vokii" дешевле 13000
    }
    @Test
    public void byMemorySizeAndNotColorTest() {
        List<Tag> criteria = new ArrayList<>();
        criteria.add(new Tag() {
            @Override
            public boolean find(Phone ph) {
                return ph.getMemorySize() == 8 && ph.getColor() != Color.RED;
            }
        });

        List<Phone> result = findPhone.findByCriteria(criteria);
        assertEquals(3, result.size()); // Проверяем, что найдено 3 телефона с 8 ГБ памяти, но не красного цвета
    }
    @Test
    public void byModelAndPriceLowAndColorTest() {
        List<Phone> result = findPhone.byModelAndPriceLowAndColor("nokii", 12500, Color.WHITE);
        assertEquals(1, result.size()); // Проверяем, что найден 1 телефон "nokii", дешевле 12500, белого цвета
    }
}

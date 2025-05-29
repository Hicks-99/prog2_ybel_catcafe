package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CatCafeTest {
    private final CatCafe cafe = new CatCafe();

    @Test
    void testCatCount() {
        cafe.addCat(new FelineOverLord("Cat1", 1));
        cafe.addCat(new FelineOverLord("Cat2", 2));

        assertEquals(2, cafe.getCatCount());
    }

    @Test
    void testAddCat_null() {
        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }

    @Test
    void testGetCatByName_exists() {
        FelineOverLord cat = new FelineOverLord("Cat", 1);
        cafe.addCat(cat);

        assertEquals(cat, cafe.getCatByName("Cat").get());
    }

    @Test
    void testGetCatByName_not_exists() {
        cafe.addCat(new FelineOverLord("Cat1", 1));

        assertTrue(cafe.getCatByName("Cat2").isEmpty());
    }

    @Test
    void testGetCatByWeight_without_cat() {
        assertTrue(cafe.getCatByWeight(0, 10).isEmpty());
    }

    @Test
    void testGetCatByWeight_in_range() {
        FelineOverLord cat = new FelineOverLord("Cat", 1);
        cafe.addCat(cat);

        assertEquals(cat, cafe.getCatByWeight(0, 10).get());
    }

    @Test
    void testGetCatByWeight_not_in_range() {
        cafe.addCat(new FelineOverLord("Cat", 11));

        assertTrue(cafe.getCatByWeight(0, 10).isEmpty());
    }

    @Test
    void testGetCatByWeight_two_in_range() {
        FelineOverLord cat1 = new FelineOverLord("Cat1", 1);
        cafe.addCat(new FelineOverLord("Cat2", 2));
        cafe.addCat(cat1);

        assertEquals(cat1, cafe.getCatByWeight(0, 10).get());
    }

    @Test
    void testGetCatByWeight_negative_weight() {
        assertTrue(cafe.getCatByWeight(-1, 10).isEmpty());
    }

    @Test
    void testGetCatByWeight_invalid_range() {
        assertTrue(cafe.getCatByWeight(5, 3).isEmpty());
    }
}
package de.mglaubitz.enumresources.test;

import org.junit.Assert;
import org.junit.Test;

public class EnumArrayResourcesTest extends BaseResourceTest {

    @Test
    public void testArrayRes() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_string_array);

        Assert.assertEquals(R.array.test_string_array, enumResources.get(TestEnum.CONSTANT_1).getArrayRes());
    }

    @Test
    public void testArrayResForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_string_array, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.array.test_string_array, enumResources.get(TestEnum.CONSTANT_1).getArrayRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testStringArray() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_string_array);

        Assert.assertArrayEquals(resources.getStringArray(R.array.test_string_array), enumResources.get(TestEnum.CONSTANT_1).getStringArray(resources));
    }

    @Test
    public void testStringArrayForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_string_array, TestEnum.Fields.FIELD_1);

        Assert.assertArrayEquals(resources.getStringArray(R.array.test_string_array), enumResources.get(TestEnum.CONSTANT_1)
                .getStringArray(resources, TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testIntegerArray() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_int_array);

        Assert.assertArrayEquals(resources.getIntArray(R.array.test_int_array), enumResources.get(TestEnum.CONSTANT_1).getIntArray(resources));
    }

    @Test
    public void testIntArrayForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_int_array, TestEnum.Fields.FIELD_1);

        Assert.assertArrayEquals(resources.getIntArray(R.array.test_int_array), enumResources.get(TestEnum.CONSTANT_1)
                .getIntArray(resources, TestEnum.Fields.FIELD_1));
    }
}
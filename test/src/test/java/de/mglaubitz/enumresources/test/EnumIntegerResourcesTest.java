package de.mglaubitz.enumresources.test;

import org.junit.Assert;
import org.junit.Test;

public class EnumIntegerResourcesTest extends BaseResourceTest {

    @Test
    public void testIntegerRes() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocInteger(R.integer.test);

        Assert.assertEquals(R.integer.test, enumResources.get(TestEnum.CONSTANT_1).getIntegerRes());
    }

    @Test
    public void testInteger() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocInteger(R.integer.test);

        Assert.assertEquals(resources.getInteger(R.integer.test), enumResources.get(TestEnum.CONSTANT_1).getInteger(resources));
    }

    @Test
    public void testIntegerResForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocInteger(R.integer.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.integer.test, enumResources.get(TestEnum.CONSTANT_1).getIntegerRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testIntegerForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocInteger(R.integer.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(resources.getInteger(R.integer.test), enumResources.get(TestEnum.CONSTANT_1)
                .getInteger(resources, TestEnum.Fields.FIELD_1));
    }
}
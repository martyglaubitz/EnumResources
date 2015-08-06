package de.mglaubitz.enumresources.test;

import org.junit.Assert;
import org.junit.Test;

public class EnumColorResourcesTest extends BaseResourceTest{

    @Test
    public void testColorRes() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocColor(R.color.test);

        Assert.assertEquals(R.color.test, enumResources.get(TestEnum.CONSTANT_1).getColorRes());
    }

    @Test
    public void testColor() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocColor(R.color.test);

        Assert.assertEquals(resources.getColor(R.color.test), enumResources.get(TestEnum.CONSTANT_1).getColor(resources));
    }

    @Test
    public void testColorResForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocColor(R.color.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.color.test, enumResources.get(TestEnum.CONSTANT_1).getColorRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testColorForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocColor(R.color.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(resources.getColor(R.color.test), enumResources.get(TestEnum.CONSTANT_1)
                .getColor(resources, TestEnum.Fields.FIELD_1));
    }

}
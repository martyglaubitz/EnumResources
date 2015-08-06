package de.mglaubitz.enumresources.test;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class EnumDrawableResourcesTest extends BaseResourceTest {

    @Test
    public void testDrawableRes() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocDrawable(R.drawable.test);

        Assert.assertEquals(R.drawable.test, enumResources.get(TestEnum.CONSTANT_1).getDrawableRes());
    }

    @Test
    public void testDrawable() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocDrawable(R.drawable.test);

        Assert.assertEquals(resources.getDrawable(R.drawable.test), enumResources.get(TestEnum.CONSTANT_1).getDrawable(resources));
    }

    @Test
    public void testDrawableResForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocDrawable(R.drawable.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.drawable.test, enumResources.get(TestEnum.CONSTANT_1).getDrawableRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testDrawableForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocDrawable(R.drawable.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(resources.getDrawable(R.drawable.test), enumResources.get(TestEnum.CONSTANT_1)
                .getDrawable(resources, TestEnum.Fields.FIELD_1));
    }

}
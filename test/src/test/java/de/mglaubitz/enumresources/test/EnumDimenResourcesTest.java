package de.mglaubitz.enumresources.test;

import org.junit.Assert;
import org.junit.Test;

public class EnumDimenResourcesTest extends BaseResourceTest {
    
    @Test
    public void testDimenRes() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocDimension(R.dimen.test);

        Assert.assertEquals(R.dimen.test, enumResources.get(TestEnum.CONSTANT_1).getDimensionRes());
    }

    @Test
    public void testDimen() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocDimension(R.dimen.test);

        Assert.assertEquals(resources.getDimensionPixelSize(R.dimen.test), enumResources.get(TestEnum.CONSTANT_1).getDimensionPixelSize(resources));
    }

    @Test
    public void testDimenResForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocDimension(R.dimen.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.dimen.test, enumResources.get(TestEnum.CONSTANT_1).getDimensionRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testDimenForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocDimension(R.dimen.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(resources.getDimensionPixelSize(R.dimen.test), enumResources.get(TestEnum.CONSTANT_1)
                .getDimensionPixelSize(resources, TestEnum.Fields.FIELD_1));
    }

}
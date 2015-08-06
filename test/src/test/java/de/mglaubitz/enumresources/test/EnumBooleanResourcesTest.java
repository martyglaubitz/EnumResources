package de.mglaubitz.enumresources.test;

import org.junit.Assert;
import org.junit.Test;

public class EnumBooleanResourcesTest extends BaseResourceTest {

    @Test
    public void testBooleanRes() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocBoolean(R.bool.test);

        Assert.assertEquals(R.bool.test, enumResources.get(TestEnum.CONSTANT_1).getBooleanRes());
    }

    @Test
    public void testBoolean() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocBoolean(R.bool.test);

        Assert.assertEquals(resources.getBoolean(R.bool.test), enumResources.get(TestEnum.CONSTANT_1).getBoolean(resources));
    }

    @Test
    public void testBooleanResForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocBoolean(R.bool.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.bool.test, enumResources.get(TestEnum.CONSTANT_1).getBooleanRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testBooleanForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocBoolean(R.bool.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(resources.getBoolean(R.bool.test), enumResources.get(TestEnum.CONSTANT_1)
                .getBoolean(resources, TestEnum.Fields.FIELD_1));
    }

}
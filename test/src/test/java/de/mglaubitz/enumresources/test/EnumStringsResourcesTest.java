package de.mglaubitz.enumresources.test;

import org.junit.Assert;
import org.junit.Test;

public class EnumStringsResourcesTest extends BaseResourceTest {

    @Test
    public void testStringRes() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocString(R.string.hello_world);

        Assert.assertEquals(R.string.hello_world, enumResources.get(TestEnum.CONSTANT_1).getStringRes());
    }

    @Test
    public void testString() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocString(R.string.hello_world);

        Assert.assertEquals(resources.getString(R.string.hello_world), enumResources.get(TestEnum.CONSTANT_1).getString(resources));
    }

    @Test
    public void testStringResForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocString(R.string.hello_world, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.string.hello_world, enumResources.get(TestEnum.CONSTANT_1).getStringRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testStringForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocString(R.string.hello_world, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(resources.getString(R.string.hello_world), enumResources.get(TestEnum.CONSTANT_1)
                .getString(resources, TestEnum.Fields.FIELD_1));
    }

}
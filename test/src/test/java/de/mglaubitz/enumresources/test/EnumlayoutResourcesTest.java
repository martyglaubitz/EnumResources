package de.mglaubitz.enumresources.test;

import org.junit.Assert;
import org.junit.Test;

public class EnumLayoutResourcesTest extends BaseResourceTest {
    
    @Test
    public void testDimenRes() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocLayout(R.layout.activity_context);

        Assert.assertEquals(R.layout.activity_context, enumResources.get(TestEnum.CONSTANT_1).getLayoutRes());
    }

    @Test
    public void testDimenResForField() {
        enumResources.get(TestEnum.CONSTANT_1)
                .assocLayout(R.layout.activity_context, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.layout.activity_context, enumResources.get(TestEnum.CONSTANT_1).getLayoutRes(TestEnum.Fields.FIELD_1));
    }

}
package de.mglaubitz.enumresources.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import de.mglaubitz.enumresources.EnumResources;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml", resourceDir = "src/test/res")
public class EnumDimenResourcesTest {

    @Before
    public void setUo() {
        EnumResources.get(TestEnum.FIELD_1)
                .assocDimension(R.dimen.test);
    }

    @Test
    public void testDimenRes() {
        Assert.assertEquals(R.dimen.test, EnumResources.get(TestEnum.FIELD_1).getDimensionRes());
    }

}
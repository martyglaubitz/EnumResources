package de.mglaubitz.enumresources.test;

import android.content.res.Resources;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import de.mglaubitz.enumresources.EnumResources;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml", resourceDir = "src/test/res")
public class EnumDimenResourcesTest {

    @Before
    public void setUp() {
        EnumResources.get(TestEnum.CONSTANT_1)
                .assocDimension(R.dimen.test);
    }

    @After
    public void tearDown() {
        EnumResources.reset();
    }

    @Test
    public void testDimenRes() {
        Assert.assertEquals(R.dimen.test, EnumResources.get(TestEnum.CONSTANT_1).getDimensionRes());
    }

    @Test
    public void testDimen() {
        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getDimensionPixelSize(R.dimen.test), EnumResources.get(TestEnum.CONSTANT_1).getDimensionPixelSize(resources));
    }

    @Test
    public void testDimenResForField() {
        EnumResources.reset();

        EnumResources.get(TestEnum.CONSTANT_1)
                .assocDimension(R.dimen.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.dimen.test, EnumResources.get(TestEnum.CONSTANT_1).getDimensionRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testDimenForField() {
        EnumResources.reset();

        EnumResources.get(TestEnum.CONSTANT_1)
                .assocDimension(R.dimen.test, TestEnum.Fields.FIELD_1);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getDimensionPixelSize(R.dimen.test), EnumResources.get(TestEnum.CONSTANT_1)
                .getDimensionPixelSize(resources, TestEnum.Fields.FIELD_1));
    }

}
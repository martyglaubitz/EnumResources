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

@SuppressWarnings("deprecation")
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml", resourceDir = "src/test/res")
public class EnumDrawableResourcesTest {

    private EnumResources _enumResources;

    @Before
    public void setUp() {
        _enumResources = new EnumResources();
    }

    @After
    public void tearDown() {
        _enumResources = null;
    }

    @Test
    public void testDrawableRes() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocDrawable(R.drawable.test);

        Assert.assertEquals(R.drawable.test, _enumResources.get(TestEnum.CONSTANT_1).getDrawableRes());
    }

    @Test
    public void testDrawable() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocDrawable(R.drawable.test);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getDrawable(R.drawable.test), _enumResources.get(TestEnum.CONSTANT_1).getDrawable(resources));
    }

    @Test
    public void testDrawableResForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocDrawable(R.drawable.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.drawable.test, _enumResources.get(TestEnum.CONSTANT_1).getDrawableRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testDrawableForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocDrawable(R.drawable.test, TestEnum.Fields.FIELD_1);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getDrawable(R.drawable.test), _enumResources.get(TestEnum.CONSTANT_1)
                .getDrawable(resources, TestEnum.Fields.FIELD_1));
    }

}
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
public class EnumColorResourcesTest {

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
    public void testColorRes() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocColor(R.color.test);

        Assert.assertEquals(R.color.test, _enumResources.get(TestEnum.CONSTANT_1).getColorRes());
    }

    @Test
    public void testColor() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocColor(R.color.test);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getColor(R.color.test), _enumResources.get(TestEnum.CONSTANT_1).getColor(resources));
    }

    @Test
    public void testColorResForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocColor(R.color.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.color.test, _enumResources.get(TestEnum.CONSTANT_1).getColorRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testColorForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocColor(R.color.test, TestEnum.Fields.FIELD_1);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getColor(R.color.test), _enumResources.get(TestEnum.CONSTANT_1)
                .getColor(resources, TestEnum.Fields.FIELD_1));
    }

}
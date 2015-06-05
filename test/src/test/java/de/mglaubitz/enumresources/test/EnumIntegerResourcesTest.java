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
public class EnumIntegerResourcesTest {

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
    public void testIntegerRes() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocInteger(R.integer.test);

        Assert.assertEquals(R.integer.test, _enumResources.get(TestEnum.CONSTANT_1).getIntegerRes());
    }

    @Test
    public void testInteger() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocInteger(R.integer.test);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getInteger(R.integer.test), _enumResources.get(TestEnum.CONSTANT_1).getInteger(resources));
    }

    @Test
    public void testIntegerResForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocInteger(R.integer.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.integer.test, _enumResources.get(TestEnum.CONSTANT_1).getIntegerRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testIntegerForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocInteger(R.integer.test, TestEnum.Fields.FIELD_1);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getInteger(R.integer.test), _enumResources.get(TestEnum.CONSTANT_1)
                .getInteger(resources, TestEnum.Fields.FIELD_1));
    }

}
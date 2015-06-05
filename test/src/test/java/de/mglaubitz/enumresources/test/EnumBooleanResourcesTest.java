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
public class EnumBooleanResourcesTest {

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
    public void testBooleanRes() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocBoolean(R.bool.test);

        Assert.assertEquals(R.bool.test, _enumResources.get(TestEnum.CONSTANT_1).getBooleanRes());
    }

    @Test
    public void testBoolean() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocBoolean(R.bool.test);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getBoolean(R.bool.test), _enumResources.get(TestEnum.CONSTANT_1).getBoolean(resources));
    }

    @Test
    public void testBooleanResForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocBoolean(R.bool.test, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.bool.test, _enumResources.get(TestEnum.CONSTANT_1).getBooleanRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testBooleanForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocBoolean(R.bool.test, TestEnum.Fields.FIELD_1);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getBoolean(R.bool.test), _enumResources.get(TestEnum.CONSTANT_1)
                .getBoolean(resources, TestEnum.Fields.FIELD_1));
    }

}
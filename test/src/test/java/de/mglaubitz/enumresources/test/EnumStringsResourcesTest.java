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
public class EnumStringsResourcesTest {

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
    public void testStringRes() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocString(R.string.hello_world);

        Assert.assertEquals(R.string.hello_world, _enumResources.get(TestEnum.CONSTANT_1).getStringRes());
    }

    @Test
    public void testString() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocString(R.string.hello_world);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getString(R.string.hello_world), _enumResources.get(TestEnum.CONSTANT_1).getString(resources));
    }

    @Test
    public void testStringResForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocString(R.string.hello_world, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.string.hello_world, _enumResources.get(TestEnum.CONSTANT_1).getStringRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testStringForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocString(R.string.hello_world, TestEnum.Fields.FIELD_1);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertEquals(resources.getString(R.string.hello_world), _enumResources.get(TestEnum.CONSTANT_1)
                .getString(resources, TestEnum.Fields.FIELD_1));
    }

}
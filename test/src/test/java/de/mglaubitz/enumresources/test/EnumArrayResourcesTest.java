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
public class EnumArrayResourcesTest {

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
    public void testArrayRes() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_string_array);

        Assert.assertEquals(R.array.test_string_array, _enumResources.get(TestEnum.CONSTANT_1).getArrayRes());
    }

    @Test
    public void testArrayResForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_string_array, TestEnum.Fields.FIELD_1);

        Assert.assertEquals(R.array.test_string_array, _enumResources.get(TestEnum.CONSTANT_1).getArrayRes(TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testStringArray() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_string_array);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertArrayEquals(resources.getStringArray(R.array.test_string_array), _enumResources.get(TestEnum.CONSTANT_1).getStringArray(resources));
    }

    @Test
    public void testStringArrayForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_string_array, TestEnum.Fields.FIELD_1);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertArrayEquals(resources.getStringArray(R.array.test_string_array), _enumResources.get(TestEnum.CONSTANT_1)
                .getStringArray(resources, TestEnum.Fields.FIELD_1));
    }

    @Test
    public void testIntegerArray() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_int_array);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertArrayEquals(resources.getIntArray(R.array.test_int_array), _enumResources.get(TestEnum.CONSTANT_1).getIntArray(resources));
    }

    @Test
    public void testIntArrayForField() {
        _enumResources.get(TestEnum.CONSTANT_1)
                .assocArray(R.array.test_int_array, TestEnum.Fields.FIELD_1);

        final Resources resources =  Robolectric.setupActivity(ContextActivity.class).getResources();
        Assert.assertArrayEquals(resources.getIntArray(R.array.test_int_array), _enumResources.get(TestEnum.CONSTANT_1)
                .getIntArray(resources, TestEnum.Fields.FIELD_1));
    }
}
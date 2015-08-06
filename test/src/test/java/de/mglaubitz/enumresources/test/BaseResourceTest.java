package de.mglaubitz.enumresources.test;

import android.content.res.Resources;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import de.mglaubitz.enumresources.EnumResources;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml", resourceDir = "src/test/res")
public abstract class BaseResourceTest {

	protected EnumResources enumResources;

	protected Resources     resources;

	@Before
	public void setUp() {
		enumResources = new EnumResources();
		resources = RuntimeEnvironment.application.getResources();
	}

	@After
	public void tearDown() {
		enumResources = null;
		resources = null;
	}

}

package de.mglaubitz.enumresources;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.SparseIntArray;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * A untility class to associate enum values with android ressources.
 */
public class EnumResources {

	@SuppressWarnings("rawtypes")
	private final Map<Class<? extends Enum>, Map> _map = new HashMap<>();

	@SuppressWarnings("unchecked")
	public <T extends Enum<T>> EnumAssociation get(final T enumValue) {
		final Class<T> tClass = (Class<T>)(Class<?>)enumValue.getClass();

		Map<T,EnumAssociation> enumAssociationMap = _map.get(tClass);
		if (enumAssociationMap == null) {
			_map.put(tClass, enumAssociationMap = new EnumMap<>(tClass));
		}

		EnumAssociation result = enumAssociationMap.get(enumValue);
		if (result == null) {
			enumAssociationMap.put(enumValue, result = new EnumAssociation());
		}

		return result;
	}

	public static class EnumAssociation {

		private static final int ARRAY_FIELD_INDEX              = 0;

		private static final int BOOL_FIELD_INDEX               = 1;

		private static final int COLOR_FIELD_INDEX              = 2;

		private static final int DRAWABLE_FIELD_INDEX           = 3;

		private static final int DIMENSION_FIELD_INDEX          = 4;

        private static final int INTEGER_FIELD_INDEX            = 5;

		private static final int LAYOUT_FIELD_INDEX             = 6;

		private static final int STRING_FIELD_INDEX             = 7;




		private final SparseIntArray _associations = new SparseIntArray();

		private final SparseIntArray _enumAssociations = new SparseIntArray();


		public EnumAssociation assocArray(@ArrayRes final int arrayRes) {
			_associations.put(ARRAY_FIELD_INDEX, arrayRes);

			return this;
		}

		public EnumAssociation assocArray(@ArrayRes final int arrayRes, final Enum<?> enumValue) {
			_enumAssociations.put(enumValue.ordinal(), arrayRes);

			return this;
		}


		public EnumAssociation assocBoolean(@BoolRes final int boolRes) {
			_associations.put(BOOL_FIELD_INDEX, boolRes);

			return this;
		}

		public EnumAssociation assocBoolean(@BoolRes final int boolRes, final Enum<?> enumValue) {
			_enumAssociations.put(enumValue.ordinal(), boolRes);

			return this;
		}


		public EnumAssociation assocColor(@ColorRes final int colorRes) {
			_associations.put(COLOR_FIELD_INDEX, colorRes);

			return this;
		}

		public EnumAssociation assocColor(@ColorRes final int colorRes, final Enum<?> enumValue) {
			_enumAssociations.put(enumValue.ordinal(), colorRes);

			return this;
		}


		public EnumAssociation assocDrawable(@DrawableRes final int drawableRes) {
			_associations.put(DRAWABLE_FIELD_INDEX, drawableRes);

			return this;
		}

		public EnumAssociation assocDrawable(@DrawableRes final int drawableRes, final Enum<?> enumValue) {
			_enumAssociations.put(enumValue.ordinal(), drawableRes);

			return this;
		}


		public EnumAssociation assocDimension(@DimenRes final int dimensionRes) {
			_associations.put(DIMENSION_FIELD_INDEX, dimensionRes);

			return this;
		}

		public EnumAssociation assocDimension(@DimenRes final int dimensionRes, final Enum<?> enumValue) {
			_enumAssociations.put(enumValue.ordinal(), dimensionRes);

			return this;
		}

        public EnumAssociation assocInteger(@IntegerRes final int integerRes) {
            _associations.put(INTEGER_FIELD_INDEX, integerRes);

            return this;
        }

        public EnumAssociation assocInteger(@IntegerRes final int integerRes, final Enum<?> enumValue) {
            _enumAssociations.put(enumValue.ordinal(), integerRes);

            return this;
        }

		public EnumAssociation assocLayout(@LayoutRes final int layoutRes) {
			_associations.put(LAYOUT_FIELD_INDEX, layoutRes);

			return this;
		}

		public EnumAssociation assocLayout(@LayoutRes final int layoutRes, final Enum<?> enumValue) {
			_enumAssociations.put(enumValue.ordinal(), layoutRes);

			return this;
		}

		public EnumAssociation assocString(@StringRes final int stringRes) {
			_associations.put(STRING_FIELD_INDEX, stringRes);

			return this;
		}

		public EnumAssociation assocString(@StringRes final int stringRes, final Enum<?> enumValue) {
			_enumAssociations.put(enumValue.ordinal(), stringRes);

			return this;
		}


		public boolean getBoolean(final Resources resources) {
			return resources.getBoolean(_associations.get(BOOL_FIELD_INDEX));
		}

		public boolean getBoolean(final Resources resources, final Enum<?> enumValue) {
			return resources.getBoolean(_enumAssociations.get(enumValue.ordinal()));
		}


		@BoolRes public int getBooleanRes() {
			return _associations.get(BOOL_FIELD_INDEX);
		}

		@BoolRes public int getBooleanRes(final Enum<?> enumValue) {
			return _enumAssociations.get(enumValue.ordinal());
		}


		public int getColor(final Resources resources) {
			return resources.getColor(_associations.get(COLOR_FIELD_INDEX));
		}

		public int getColor(final Resources resources, final Enum<?> enumValue) {
			return resources.getColor(_enumAssociations.get(enumValue.ordinal()));
		}


		@ColorRes public int getColorRes() {
			return _associations.get(COLOR_FIELD_INDEX);
		}

		@ColorRes public int getColorRes(final Enum<?> enumValue) {
			return _enumAssociations.get(enumValue.ordinal());
		}


		@Nullable
		public Drawable getDrawable(final Resources resources) {
			//noinspection deprecation
			return resources.getDrawable(_associations.get(DRAWABLE_FIELD_INDEX));
		}

		@Nullable
		public Drawable getDrawable(final Resources resources, final Enum<?> enumValue) {
			//noinspection deprecation
			return resources.getDrawable(_enumAssociations.get(enumValue.ordinal()));
		}


		@DrawableRes public int getDrawableRes() {
			return _associations.get(DRAWABLE_FIELD_INDEX);
		}

		@DrawableRes public int getDrawableRes(final Enum<?> enumValue) {
			return _enumAssociations.get(enumValue.ordinal());
		}


		public int getInteger(final Resources resources) {
			return resources.getInteger(_associations.get(INTEGER_FIELD_INDEX));
		}

		public int getInteger(final Resources resources, final Enum<?> enumValue) {
			return resources.getInteger(_enumAssociations.get(enumValue.ordinal()));
		}

		@IntegerRes public int getIntegerRes() {
			return _associations.get(INTEGER_FIELD_INDEX);
		}

		@IntegerRes public int getIntegerRes(final Enum<?> enumValue) {
			return _enumAssociations.get(enumValue.ordinal());
		}

		@NonNull
		public int[] getIntArray(final Resources resources) {
			return resources.getIntArray(_associations.get(ARRAY_FIELD_INDEX));
		}

		@NonNull
		public int[] getIntArray(final Resources resources, final Enum<?> enumValue) {
			return resources.getIntArray(_enumAssociations.get(enumValue.ordinal()));
		}


		@ArrayRes public int getArrayRes() {
			return _associations.get(ARRAY_FIELD_INDEX);
		}

		@ArrayRes public int getArrayRes(final Enum<?> enumValue) {
			return _enumAssociations.get(enumValue.ordinal());
		}

		@LayoutRes public int getLayoutRes() {
			return _associations.get(LAYOUT_FIELD_INDEX);
		}

		@LayoutRes public int getLayoutRes(final Enum<?> enumValue) {
			return _enumAssociations.get(enumValue.ordinal());
		}

		@NonNull
		public String getString(final Resources resources) {
			return resources.getString(_associations.get(STRING_FIELD_INDEX));
		}

		@NonNull
		public String getString(final Resources resources, final Enum<?> enumValue) {
			return resources.getString(_enumAssociations.get(enumValue.ordinal()));
		}


		@StringRes public int getStringRes() {
			return _associations.get(STRING_FIELD_INDEX);
		}

		@StringRes public int getStringRes(final Enum<?> enumValue) {
			return _enumAssociations.get(enumValue.ordinal());
		}


		@NonNull
		public String[] getStringArray(final Resources resources) {
			return resources.getStringArray(_associations.get(ARRAY_FIELD_INDEX));
		}

		@NonNull
		public String[] getStringArray(final Resources resources, final Enum<?> enumValue) {
			return resources.getStringArray(_enumAssociations.get(enumValue.ordinal()));
		}


		public int getDimensionPixelSize(final Resources resources) {
			return resources.getDimensionPixelSize(_associations.get(DIMENSION_FIELD_INDEX));
		}

		public int getDimensionPixelSize(final Resources resources, final Enum<?> enumValue) {
			return resources.getDimensionPixelSize(_enumAssociations.get(enumValue.ordinal()));
		}


		@DimenRes public int getDimensionRes() {
			return _associations.get(DIMENSION_FIELD_INDEX);
		}

		@DimenRes public int getDimensionRes(final Enum<?> enumValue) {
			return _enumAssociations.get(enumValue.ordinal());
		}
	}
}

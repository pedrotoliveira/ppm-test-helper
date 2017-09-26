package br.com.ppm.test.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * The Class ReflectionUtil.
 */
public final class ReflectionUtil {

	/** The Constant FIELDS_SEPARATOR. */
	private static final String FIELDS_SEPARATOR = "\\.";

	/**
	 * No instances for this class.
   	 */
	private ReflectionUtil() {
	}

	/**
	 * Gets the value by field name.
	 * <p>
	 * Use the dot notation: "thing.child";
	 * <p>
	 * To access Map fields, use the same notation: "some.mapField.thing";
	 * <p>
	 * To access List fields, use the index: "some.listField.0";
	 * <p>
	 * @param fieldName the field
	 * @param target    the target
	 * <p>
	 * @return the by field name
	 */
	public static Object getByFieldName(final String fieldName, final Object target) {
//		hasLength(fieldName, "Field must not be empty");
//		notNullParameter(target, "Target must not be null");

		String[] fields = fieldName.split(FIELDS_SEPARATOR);

//		notEmptyParameter(fields, "fieldName");

		try {
			Object value = target;

			for (String fName : fields) {
				if (isMap(value)) {
					value = getValueFromMap(fName, value);
				} else if (isList(value)) {
					value = getValueFromList(fName, value);
				} else {
					value = getValueFromField(fName, value);
				}
			}

			return value;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new IllegalArgumentException("Exception accessing field", e);
		}
	}

	/**
	 * Checks if is map.
	 *
	 * @param target the target
	 * @return true, if is map
	 */
	private static boolean isMap(final Object target) {
		return target instanceof Map<?, ?>;
	}

	/**
	 * Checks if is list.
	 *
	 * @param target the target
	 * @return true, if is list
	 */
	private static boolean isList(final Object target) {
		return target instanceof List<?>;
	}

	/**
	 * Gets the value from field.
	 *
	 * @param field the field
	 * @param target the target
	 * @return the value from field
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	private static Object getValueFromField(final String field, final Object target)
			throws NoSuchFieldException, SecurityException, IllegalAccessException {

		if (target == null) {
			return null;
		}
		Field f = null;
		try {
			f = target.getClass().getDeclaredField(field);
		} catch (NoSuchFieldException n) {
			if (target.getClass().getSuperclass() != null) {
				f = target.getClass().getSuperclass().getDeclaredField(field);
			}
		}
		f.setAccessible(true);
		return f.get(target);
	}

	/**
	 * Gets the value from map.
	 *
	 * @param field the field
	 * @param target the target
	 * @return the value from map
	 */
	private static Object getValueFromMap(final String field, final Object target) {
		if (target == null || !isMap(target)) {
			return null;
		}
		return ((Map<?, ?>) target).get(field);
	}

	/**
	 * Gets the value from list.
	 *
	 * @param field the field
	 * @param target the target
	 * @return the value from list
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	private static Object getValueFromList(final String field, final Object target)
			throws NoSuchFieldException, SecurityException, IllegalAccessException {

		if (target == null || !isList(target)) {
			return null;
		}
		if (NumberUtils.isNumber(field)) {
			int index = Integer.parseInt(field);
			return ((List<?>) target).get(index);
		} else {
			return getValueFromField(field, target);
		}
	}

	/**
	 * Sets the value by field name.
	 * <p>
	 * @param field  the field
	 * @param target the target
	 * @param value  the value
	 */
	public static void setByFieldName(final String field, final Object target, final Object value) {
//		hasLength(field, "Field must not be empty");
//		notNullParameter(target, "Target must not be null");

		try {
			Field f = target.getClass().getDeclaredField(field);
			f.setAccessible(true);
			f.set(target, value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new IllegalArgumentException("Exception accessing field");
		}
	}

	/**
	 * Gets the by field "get" method.
	 * <p>
	 * @param field  the field
	 * @param target the target
	 * <p>
	 * @return the by field get method
	 */
	public static Object getFieldByGetMethod(final String field, final Object target) {
        Objects.requireNonNull(field, "Field is Empty");
//		notNullParameter(target, "Target must not be null");

		String methodName = String.format("get%s", StringUtils.capitalize(field));

		try {
			Method method = target.getClass().getMethod(methodName);
			return method.invoke(target);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

		}
		throw new IllegalArgumentException("Exception accessing field");
	}
}

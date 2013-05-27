package org.softlang.company.features;

import java.lang.reflect.*;
import java.util.*;

/**
 * Walk an object graph to return all sub-objects
 */
public class Walker implements Iterable<Object> {

	private List<Object> objects = new LinkedList<Object>();

	/**
	 * Construct a walker
	 */
	public Walker(Object root) {
		walk(root);
	}

	/*
	 * A private helper to explore all sub-objects
	 */
	@SuppressWarnings("rawtypes")
	private void walk(Object x) {
		// Special case for lists
		if (x instanceof List)
			for (Object o : (List) x) {
				objects.add(o);
				walk(o);
			}
		else {
			// Regular case based on getters
			for (Method m : x.getClass().getDeclaredMethods()) {
				if (m.getName().startsWith("get")
						&& m.getParameterTypes().length == 0) {
					try {
						Object o = m.invoke(x, new Object[] {});
						objects.add(o);
						walk(o);
					} catch (IllegalAccessException e) {
						// assert "DEAD CODE"
					} catch (IllegalArgumentException e) {
						// assert "DEAD CODE"
					} catch (InvocationTargetException e) {
						// assert "DEAD CODE"
					}
				}
			}
		}
	}

	/**
	 * Return iterator for all sub-objects
	 */
	public Iterator<Object> iterator() {
		return objects.iterator();
	}
}
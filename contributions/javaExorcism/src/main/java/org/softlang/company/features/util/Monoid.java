package org.softlang.company.features.util;

/**
 * An associative operation "append" with its unit "unit".
 */
public interface Monoid<R> {
	R unit();
	R append(R x, R y);
}

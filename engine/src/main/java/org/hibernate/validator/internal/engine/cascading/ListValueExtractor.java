/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.internal.engine.cascading;

import java.util.List;

import org.hibernate.validator.spi.cascading.ExtractedValue;
import org.hibernate.validator.spi.cascading.ValueExtractor;

class ListValueExtractor implements ValueExtractor<List<@ExtractedValue ?>> {

	static final ListValueExtractor INSTANCE = new ListValueExtractor();

	private ListValueExtractor() {
	}

	@Override
	public void extractValues(List<?> originalValue, ValueReceiver receiver) {
		int i = 0;
		for ( Object object : originalValue ) {
			receiver.indexedValue( object, "<collection element>", i );
			i++;
		}
	}
}

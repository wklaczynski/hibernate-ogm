/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.dialect.batch.spi;

import org.hibernate.ogm.dialect.spi.AssociationContext;
import org.hibernate.ogm.model.key.spi.AssociationKey;
import org.hibernate.ogm.model.key.spi.EntityKey;

/**
 * An operation representing the removal of an association
 *
 * @author Davide D'Alto &lt;davide@hibernate.org&gt;
 */
public class RemoveAssociationOperation implements GroupableEntityOperation {

	private final AssociationKey associationKey;
	private final AssociationContext context;

	public RemoveAssociationOperation(AssociationKey associationKey, AssociationContext context) {
		this.associationKey = associationKey;
		this.context = context;
	}

	public AssociationKey getAssociationKey() {
		return associationKey;
	}

	public AssociationContext getContext() {
		return context;
	}

	@Override
	public EntityKey getEntityKey() {
		return getAssociationKey().getEntityKey();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( getClass().getSimpleName() );
		sb.append( "[" );
		sb.append( getEntityKey() );
		sb.append( ", collectionRole=" );
		sb.append( getAssociationKey().getMetadata().getCollectionRole() );
		sb.append( "]" );
		return sb.toString();
	}

}

/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.business.queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.model.utils.ListExt;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * @author Joao Barata
 */
public class CapellaElement_CapellaIncomingRelation_Requirement extends CapellaElement_CapellaRelation_Requirement {

  /**
   * @see org.polarsys.capella.core.business.queries.ui.business.queries.IBusinessQuery#getCurrentElements(EObject, boolean)
   */
  @Override
	public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
    List<EObject> currentElements = new ArrayList<EObject>();

    for (EObject referencer : EObjectExt.getReferencers(element, CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET)) {
      Requirement requirement = ((CapellaIncomingRelation) referencer).getSource();
      if (requirement != null) {
        currentElements.add(requirement);
      }
    }

    currentElements = ListExt.removeDuplicates(currentElements);

    return currentElements;
  }

  @Override
	public List<EReference> getEStructuralFeatures() {
    return Collections.singletonList(CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE);
  }
}
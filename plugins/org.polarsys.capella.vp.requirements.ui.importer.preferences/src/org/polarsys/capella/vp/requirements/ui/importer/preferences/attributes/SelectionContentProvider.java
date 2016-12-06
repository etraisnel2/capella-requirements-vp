/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.PropertiesFileAttributesProvider;

/**
 * @author Joao Barata
 */
// TODO split this class and it internal to each section
public class SelectionContentProvider implements ITreeContentProvider {
  private static Object[] EMPTY_ARRAY = new Object[0];
  protected Viewer _viewer = null;

  /**
   * @see IContentProvider#dispose()
   */
  public void dispose() {
    /** no op */
  }

  /**
   * @see IContentProvider#inputChanged(Viewer, Object, Object)
   * @param viewer
   *          the viewer
   * @param oldInput
   *          the old input element, or <code>null</code> if the viewer did not previously have an input
   * @param newInput
   *          the new input element, or <code>null</code> if the viewer does not have an input
   */
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    _viewer = viewer;
  }

  /**
   * @see ITreeContentProvider#getChildren(Object)
   */
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof AttributeSet) {
      return ((AttributeSet) parentElement).getChildren().toArray();
    }else if(parentElement instanceof PropertiesFileAttributesProvider){
      return PropertiesFileAttributesProvider.getInstance().getPropertiesFiles().toArray();
    }
    return EMPTY_ARRAY;
  }

  /**
   * @see ITreeContentProvider#getParent(Object)
   */
  public Object getParent(Object element) {
    if (element instanceof AttributeSet) {
      return ((AttributeSet) element).getParent();
    }
    return null;
  }

  /**
   * @see ITreeContentProvider#hasChildren(Object)
   */
  public boolean hasChildren(Object element) {
    return getChildren(element).length > 0;
  }

  /**
   * @see IStructuredContentProvider#getElements(Object)
   */
  public Object[] getElements(Object inputElement) {
    return getChildren(inputElement);
  }
}

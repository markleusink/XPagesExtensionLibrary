/*
 * � Copyright IBM Corp. 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */

package com.ibm.xsp.extlib.component.dojo.form;

import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.el.ValueBinding;

import com.ibm.xsp.extlib.component.dojo.converter.DateConverter;
import com.ibm.xsp.extlib.component.dojo.form.constraints.DateTimeConstraints;
import com.ibm.xsp.util.FacesUtil;

/**
 * Dojo DateTextBox component. 
 * 
 * @author Philippe Riand
 */
public class UIDojoDateTextBox extends UIDojoRangeBoundTextBox {

    public static final String COMPONENT_TYPE = "com.ibm.xsp.extlib.dojo.form.DateTextBox"; //$NON-NLS-1$
    public static final String RENDERER_TYPE = "com.ibm.xsp.extlib.dojo.form.DateTextBox"; //$NON-NLS-1$

    private DateTimeConstraints constraints;
	
	public UIDojoDateTextBox() {
		setRendererType(RENDERER_TYPE);
	}
	
    public DateTimeConstraints getConstraints() {
		return this.constraints;
	}

	public void setConstraints(DateTimeConstraints constraints) {
		this.constraints = constraints;
	}

	// Converter
    @Override
	protected Converter getDefaultConverter() {
    	DateConverter converter = new DateConverter();
    	return converter;
    }

    // State management
	@Override
	public void restoreState(FacesContext _context, Object _state) {
		Object _values[] = (Object[]) _state;
		super.restoreState(_context, _values[0]);
        this.constraints = (DateTimeConstraints) FacesUtil.objectFromSerializable(_context, this, _values[1]);
	}
	
	@Override
	public Object saveState(FacesContext _context) {
		Object _values[] = new Object[2];
		_values[0] = super.saveState(_context);
		_values[1] = FacesUtil.objectToSerializable(_context, constraints);
		return _values;
	}
}

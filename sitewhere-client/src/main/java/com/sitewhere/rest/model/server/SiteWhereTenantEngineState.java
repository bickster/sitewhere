/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.server;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.server.ISiteWhereTenantEngineState;
import com.sitewhere.spi.server.ITenantEngineComponent;
import com.sitewhere.spi.server.lifecycle.LifecycleStatus;

/**
 * Contains information about the runtime
 * 
 * @author Derek
 */
@JsonInclude(Include.NON_NULL)
public class SiteWhereTenantEngineState implements ISiteWhereTenantEngineState {

	/** Serial version UID */
	private static final long serialVersionUID = 2078848111680197247L;

	/** Lifecycle status */
	private LifecycleStatus lifecycleStatus;

	/** Hierarchy of tenant engine components */
	private List<ITenantEngineComponent> componentHierarchyState;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.spi.server.ISiteWhereTenantEngineState#getLifecycleStatus()
	 */
	public LifecycleStatus getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(LifecycleStatus lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sitewhere.spi.server.ISiteWhereTenantEngineState#getComponentHierarchyState()
	 */
	public List<ITenantEngineComponent> getComponentHierarchyState() {
		return componentHierarchyState;
	}

	public void setComponentHierarchyState(List<ITenantEngineComponent> componentHierarchyState) {
		this.componentHierarchyState = componentHierarchyState;
	}
}
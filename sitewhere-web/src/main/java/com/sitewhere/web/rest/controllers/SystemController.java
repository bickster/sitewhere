/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.web.rest.controllers;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitewhere.SiteWhere;
import com.sitewhere.Tracer;
import com.sitewhere.core.user.SitewhereRoles;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.server.ISiteWhereServerState;
import com.sitewhere.spi.server.debug.TracerCategory;
import com.sitewhere.spi.system.IVersion;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * Controller for system operations.
 * 
 * @author Derek Adams
 */
@Controller
@RequestMapping(value = "/system")
@Api(value = "system", description = "Operations related to SiteWhere CE system management.")
public class SystemController extends SiteWhereController {

	/** Static logger instance */
	private static Logger LOGGER = Logger.getLogger(SystemController.class);

	/**
	 * Get version information about the server.
	 * 
	 * @return
	 * @throws SiteWhereException
	 */
	@RequestMapping(value = "/version", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get version information")
	@Secured({ SitewhereRoles.ROLE_AUTHENTICATED_USER })
	public IVersion getVersion() throws SiteWhereException {
		Tracer.start(TracerCategory.RestApiCall, "getVersion", LOGGER);
		try {
			return SiteWhere.getServer().getVersion();
		} finally {
			Tracer.stop(LOGGER);
		}
	}

	/**
	 * Get runtime information about the server.
	 * 
	 * @return
	 * @throws SiteWhereException
	 */
	@RequestMapping(value = "/state", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get server runtime information")
	@Secured({ SitewhereRoles.ROLE_AUTHENTICATED_USER })
	public ISiteWhereServerState getServerState() throws SiteWhereException {
		Tracer.start(TracerCategory.RestApiCall, "getServerState", LOGGER);
		try {
			return SiteWhere.getServer().getServerState();
		} finally {
			Tracer.stop(LOGGER);
		}
	}
}
/*
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.sitewhere.spi.device;

import java.util.List;

import com.sitewhere.spi.ISiteWhereLifecycle;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.common.IMetadataProvider;
import com.sitewhere.spi.device.command.IDeviceCommand;
import com.sitewhere.spi.device.event.IDeviceAlert;
import com.sitewhere.spi.device.event.IDeviceCommandInvocation;
import com.sitewhere.spi.device.event.IDeviceEventBatch;
import com.sitewhere.spi.device.event.IDeviceEventBatchResponse;
import com.sitewhere.spi.device.event.IDeviceLocation;
import com.sitewhere.spi.device.event.IDeviceMeasurements;
import com.sitewhere.spi.device.event.request.IDeviceAlertCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceCommandInvocationCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceLocationCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceMeasurementsCreateRequest;
import com.sitewhere.spi.device.request.IDeviceAssignmentCreateRequest;
import com.sitewhere.spi.device.request.IDeviceCommandCreateRequest;
import com.sitewhere.spi.device.request.IDeviceCreateRequest;
import com.sitewhere.spi.device.request.IDeviceSpecificationCreateRequest;
import com.sitewhere.spi.device.request.ISiteCreateRequest;
import com.sitewhere.spi.device.request.IZoneCreateRequest;
import com.sitewhere.spi.search.IDateRangeSearchCriteria;
import com.sitewhere.spi.search.ISearchCriteria;
import com.sitewhere.spi.search.ISearchResults;

/**
 * Interface for device operations.
 * 
 * @author Derek
 */
public interface IDeviceManagement extends ISiteWhereLifecycle {

	/**
	 * Create a new device specification.
	 * 
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceSpecification createDeviceSpecification(IDeviceSpecificationCreateRequest request)
			throws SiteWhereException;

	/**
	 * Get a device specification by unique token.
	 * 
	 * @param token
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceSpecification getDeviceSpecificationByToken(String token) throws SiteWhereException;

	/**
	 * Update an existing device specification.
	 * 
	 * @param token
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceSpecification updateDeviceSpecification(String token,
			IDeviceSpecificationCreateRequest request) throws SiteWhereException;

	/**
	 * List device specifications that match the search criteria.
	 * 
	 * @param includeDeleted
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceSpecification> listDeviceSpecifications(boolean includeDeleted,
			ISearchCriteria criteria) throws SiteWhereException;

	/**
	 * Delete an existing device specification.
	 * 
	 * @param token
	 * @param force
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceSpecification deleteDeviceSpecification(String token, boolean force)
			throws SiteWhereException;

	/**
	 * Creates a device command associated with an existing device specification.
	 * 
	 * @param spec
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceCommand createDeviceCommand(IDeviceSpecification spec, IDeviceCommandCreateRequest request)
			throws SiteWhereException;

	/**
	 * Get a device command by unique token.
	 * 
	 * @param token
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceCommand getDeviceCommandByToken(String token) throws SiteWhereException;

	/**
	 * Update an existing device command.
	 * 
	 * @param token
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceCommand updateDeviceCommand(String token, IDeviceCommandCreateRequest request)
			throws SiteWhereException;

	/**
	 * List device command objects associated with a device specification.
	 * 
	 * @param specToken
	 * @param includeDeleted
	 * @return
	 * @throws SiteWhereException
	 */
	public List<IDeviceCommand> listDeviceCommands(String specToken, boolean includeDeleted)
			throws SiteWhereException;

	/**
	 * Delete an existing device command.
	 * 
	 * @param token
	 * @param force
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceCommand deleteDeviceCommand(String token, boolean force) throws SiteWhereException;

	/**
	 * Create a new device.
	 * 
	 * @param device
	 * @return
	 * @throws SiteWhereException
	 */
	public IDevice createDevice(IDeviceCreateRequest device) throws SiteWhereException;

	/**
	 * Gets a device by unique hardware id.
	 * 
	 * @param hardwareId
	 * @return
	 * @throws SiteWhereException
	 */
	public IDevice getDeviceByHardwareId(String hardwareId) throws SiteWhereException;

	/**
	 * Update device information.
	 * 
	 * @param hardwareId
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IDevice updateDevice(String hardwareId, IDeviceCreateRequest request) throws SiteWhereException;

	/**
	 * Gets the current assignment for a device. Null if none.
	 * 
	 * @param device
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceAssignment getCurrentDeviceAssignment(IDevice device) throws SiteWhereException;

	/**
	 * List devices that meet the given criteria.
	 * 
	 * @param includeDeleted
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDevice> listDevices(boolean includeDeleted, ISearchCriteria criteria)
			throws SiteWhereException;

	/**
	 * List all devices that are not currently assigned.
	 * 
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDevice> listUnassignedDevices(ISearchCriteria criteria) throws SiteWhereException;

	/**
	 * Delete an existing device.
	 * 
	 * @param hardwareId
	 * @param force
	 * @return
	 * @throws SiteWhereException
	 */
	public IDevice deleteDevice(String hardwareId, boolean force) throws SiteWhereException;

	/**
	 * Create a new device assignment.
	 * 
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceAssignment createDeviceAssignment(IDeviceAssignmentCreateRequest request)
			throws SiteWhereException;

	/**
	 * Get a device assignment by unique token.
	 * 
	 * @param token
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceAssignment getDeviceAssignmentByToken(String token) throws SiteWhereException;

	/**
	 * Delete a device assignment. Depending on 'force' flag the assignment will be marked
	 * for delete or actually be deleted.
	 * 
	 * @param token
	 * @param force
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceAssignment deleteDeviceAssignment(String token, boolean force) throws SiteWhereException;

	/**
	 * Get the device associated with an assignment.
	 * 
	 * @param assignment
	 * @return
	 * @throws SiteWhereException
	 */
	public IDevice getDeviceForAssignment(IDeviceAssignment assignment) throws SiteWhereException;

	/**
	 * Get the site associated with an assignment.
	 * 
	 * @param assignment
	 * @return
	 * @throws SiteWhereException
	 */
	public ISite getSiteForAssignment(IDeviceAssignment assignment) throws SiteWhereException;

	/**
	 * Update metadata associated with a device assignment.
	 * 
	 * @param token
	 * @param metadata
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceAssignment updateDeviceAssignmentMetadata(String token, IMetadataProvider metadata)
			throws SiteWhereException;

	/**
	 * Update the status of an existing device assignment.
	 * 
	 * @param token
	 * @param status
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceAssignment updateDeviceAssignmentStatus(String token, DeviceAssignmentStatus status)
			throws SiteWhereException;

	/**
	 * Updates the state of a device assignment based on a batch of new events.
	 * 
	 * @param token
	 * @param batch
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceAssignment updateDeviceAssignmentState(String token, IDeviceEventBatch batch)
			throws SiteWhereException;

	/**
	 * Add a batch of events for the given assignment.
	 * 
	 * @param assignmentToken
	 * @param batch
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceEventBatchResponse addDeviceEventBatch(String assignmentToken, IDeviceEventBatch batch)
			throws SiteWhereException;

	/**
	 * Ends a device assignment.
	 * 
	 * @param token
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceAssignment endDeviceAssignment(String token) throws SiteWhereException;

	/**
	 * Get the device assignment history for a given device.
	 * 
	 * @param hardwareId
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceAssignment> getDeviceAssignmentHistory(String hardwareId,
			ISearchCriteria criteria) throws SiteWhereException;

	/**
	 * Get a list of device assignments for a site.
	 * 
	 * @param siteToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceAssignment> getDeviceAssignmentsForSite(String siteToken,
			ISearchCriteria criteria) throws SiteWhereException;

	/**
	 * Add measurements for a given device assignment.
	 * 
	 * @param assignment
	 * @param measurements
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceMeasurements addDeviceMeasurements(IDeviceAssignment assignment,
			IDeviceMeasurementsCreateRequest measurements) throws SiteWhereException;

	/**
	 * Gets device measurement entries for an assignment based on criteria.
	 * 
	 * @param assignmentToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceMeasurements> listDeviceMeasurements(String assignmentToken,
			IDateRangeSearchCriteria criteria) throws SiteWhereException;

	/**
	 * List device measurements for a site.
	 * 
	 * @param siteToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceMeasurements> listDeviceMeasurementsForSite(String siteToken,
			IDateRangeSearchCriteria criteria) throws SiteWhereException;

	/**
	 * Add location for a given device assignment.
	 * 
	 * @param assignment
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceLocation addDeviceLocation(IDeviceAssignment assignment,
			IDeviceLocationCreateRequest request) throws SiteWhereException;

	/**
	 * Gets device location entries for an assignment.
	 * 
	 * @param assignmentToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceLocation> listDeviceLocations(String assignmentToken,
			IDateRangeSearchCriteria criteria) throws SiteWhereException;

	/**
	 * List device locations for a site.
	 * 
	 * @param siteToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceLocation> listDeviceLocationsForSite(String siteToken,
			IDateRangeSearchCriteria criteria) throws SiteWhereException;

	/**
	 * List device locations for the given tokens within the given time range.
	 * 
	 * @param assignmentTokens
	 * @param start
	 * @param end
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceLocation> listDeviceLocations(List<String> assignmentTokens,
			IDateRangeSearchCriteria criteria) throws SiteWhereException;

	/**
	 * Add alert for a given device assignment.
	 * 
	 * @param assignment
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceAlert addDeviceAlert(IDeviceAssignment assignment, IDeviceAlertCreateRequest request)
			throws SiteWhereException;

	/**
	 * Gets the most recent device alert entries for an assignment.
	 * 
	 * @param assignmentToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceAlert> listDeviceAlerts(String assignmentToken,
			IDateRangeSearchCriteria criteria) throws SiteWhereException;

	/**
	 * List device alerts for a site.
	 * 
	 * @param siteToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceAlert> listDeviceAlertsForSite(String siteToken,
			IDateRangeSearchCriteria criteria) throws SiteWhereException;

	/**
	 * Add a device command invocation event for the given assignment.
	 * 
	 * @param assignment
	 * @param command
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IDeviceCommandInvocation addDeviceCommandInvocation(IDeviceAssignment assignment,
			IDeviceCommand command, IDeviceCommandInvocationCreateRequest request) throws SiteWhereException;

	/**
	 * Gets device command invocations for an assignment based on criteria.
	 * 
	 * @param assignmentToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceCommandInvocation> listDeviceCommandInvocations(String assignmentToken,
			IDateRangeSearchCriteria criteria) throws SiteWhereException;

	/**
	 * List device command invocations for a site.
	 * 
	 * @param siteToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IDeviceCommandInvocation> listDeviceCommandInvocationsForSite(String siteToken,
			IDateRangeSearchCriteria criteria) throws SiteWhereException;

	/**
	 * Create a site based on the given input.
	 * 
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public ISite createSite(ISiteCreateRequest request) throws SiteWhereException;

	/**
	 * Delete a site based on unique site token. If 'force' is specified, the database
	 * object will be deleted, otherwise the deleted flag will be set to true.
	 * 
	 * @param siteToken
	 * @param force
	 * @return
	 * @throws SiteWhereException
	 */
	public ISite deleteSite(String siteToken, boolean force) throws SiteWhereException;

	/**
	 * Update information for a site.
	 * 
	 * @param siteToken
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public ISite updateSite(String siteToken, ISiteCreateRequest request) throws SiteWhereException;

	/**
	 * Get a site by unique token.
	 * 
	 * @param token
	 * @return
	 * @throws SiteWhereException
	 */
	public ISite getSiteByToken(String token) throws SiteWhereException;

	/**
	 * Get a list of all sites.
	 * 
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<ISite> listSites(ISearchCriteria criteria) throws SiteWhereException;

	/**
	 * Create a new zone.
	 * 
	 * @param site
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IZone createZone(ISite site, IZoneCreateRequest request) throws SiteWhereException;

	/**
	 * Update an existing zone.
	 * 
	 * @param token
	 * @param request
	 * @return
	 * @throws SiteWhereException
	 */
	public IZone updateZone(String token, IZoneCreateRequest request) throws SiteWhereException;

	/**
	 * Get a zone by its unique token.
	 * 
	 * @param zoneToken
	 * @return
	 * @throws SiteWhereException
	 */
	public IZone getZone(String zoneToken) throws SiteWhereException;

	/**
	 * Get a list of all zones associated with a Site.
	 * 
	 * @param siteToken
	 * @param criteria
	 * @return
	 * @throws SiteWhereException
	 */
	public ISearchResults<IZone> listZones(String siteToken, ISearchCriteria criteria)
			throws SiteWhereException;

	/**
	 * Delete a zone given its unique token.
	 * 
	 * @param zoneToken
	 * @param force
	 * @return
	 * @throws SiteWhereException
	 */
	public IZone deleteZone(String zoneToken, boolean force) throws SiteWhereException;
}
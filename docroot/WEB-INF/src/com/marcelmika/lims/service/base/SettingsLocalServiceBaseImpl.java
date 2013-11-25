/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.marcelmika.lims.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.marcelmika.lims.model.Settings;
import com.marcelmika.lims.service.BuddyLocalService;
import com.marcelmika.lims.service.ConversationLocalService;
import com.marcelmika.lims.service.OpenedConversationLocalService;
import com.marcelmika.lims.service.SettingsLocalService;
import com.marcelmika.lims.service.persistence.BuddyPersistence;
import com.marcelmika.lims.service.persistence.ConversationPersistence;
import com.marcelmika.lims.service.persistence.OpenedConversationPersistence;
import com.marcelmika.lims.service.persistence.SettingsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the settings local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.marcelmika.lims.service.impl.SettingsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.marcelmika.lims.service.impl.SettingsLocalServiceImpl
 * @see com.marcelmika.lims.service.SettingsLocalServiceUtil
 * @generated
 */
public abstract class SettingsLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements SettingsLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.marcelmika.lims.service.SettingsLocalServiceUtil} to access the settings local service.
	 */

	/**
	 * Adds the settings to the database. Also notifies the appropriate model listeners.
	 *
	 * @param settings the settings
	 * @return the settings that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Settings addSettings(Settings settings) throws SystemException {
		settings.setNew(true);

		return settingsPersistence.update(settings, false);
	}

	/**
	 * Creates a new settings with the primary key. Does not add the settings to the database.
	 *
	 * @param sid the primary key for the new settings
	 * @return the new settings
	 */
	public Settings createSettings(long sid) {
		return settingsPersistence.create(sid);
	}

	/**
	 * Deletes the settings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sid the primary key of the settings
	 * @return the settings that was removed
	 * @throws PortalException if a settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Settings deleteSettings(long sid)
		throws PortalException, SystemException {
		return settingsPersistence.remove(sid);
	}

	/**
	 * Deletes the settings from the database. Also notifies the appropriate model listeners.
	 *
	 * @param settings the settings
	 * @return the settings that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Settings deleteSettings(Settings settings) throws SystemException {
		return settingsPersistence.remove(settings);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Settings.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return settingsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return settingsPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return settingsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return settingsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Settings fetchSettings(long sid) throws SystemException {
		return settingsPersistence.fetchByPrimaryKey(sid);
	}

	/**
	 * Returns the settings with the primary key.
	 *
	 * @param sid the primary key of the settings
	 * @return the settings
	 * @throws PortalException if a settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 * @throws java.lang.Exception
	 */
	public Settings getSettings(long sid)
		throws PortalException, SystemException, java.lang.Exception {
		return settingsPersistence.findByPrimaryKey(sid);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return settingsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the settingses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of settingses
	 * @param end the upper bound of the range of settingses (not inclusive)
	 * @return the range of settingses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Settings> getSettingses(int start, int end)
		throws SystemException {
		return settingsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of settingses.
	 *
	 * @return the number of settingses
	 * @throws SystemException if a system exception occurred
	 */
	public int getSettingsesCount() throws SystemException {
		return settingsPersistence.countAll();
	}

	/**
	 * Updates the settings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param settings the settings
	 * @return the settings that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Settings updateSettings(Settings settings) throws SystemException {
		return updateSettings(settings, true);
	}

	/**
	 * Updates the settings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param settings the settings
	 * @param merge whether to merge the settings with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the settings that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Settings updateSettings(Settings settings, boolean merge)
		throws SystemException {
		settings.setNew(false);

		return settingsPersistence.update(settings, merge);
	}

	/**
	 * Returns the buddy local service.
	 *
	 * @return the buddy local service
	 */
	public BuddyLocalService getBuddyLocalService() {
		return buddyLocalService;
	}

	/**
	 * Sets the buddy local service.
	 *
	 * @param buddyLocalService the buddy local service
	 */
	public void setBuddyLocalService(BuddyLocalService buddyLocalService) {
		this.buddyLocalService = buddyLocalService;
	}

	/**
	 * Returns the buddy persistence.
	 *
	 * @return the buddy persistence
	 */
	public BuddyPersistence getBuddyPersistence() {
		return buddyPersistence;
	}

	/**
	 * Sets the buddy persistence.
	 *
	 * @param buddyPersistence the buddy persistence
	 */
	public void setBuddyPersistence(BuddyPersistence buddyPersistence) {
		this.buddyPersistence = buddyPersistence;
	}

	/**
	 * Returns the conversation local service.
	 *
	 * @return the conversation local service
	 */
	public ConversationLocalService getConversationLocalService() {
		return conversationLocalService;
	}

	/**
	 * Sets the conversation local service.
	 *
	 * @param conversationLocalService the conversation local service
	 */
	public void setConversationLocalService(
		ConversationLocalService conversationLocalService) {
		this.conversationLocalService = conversationLocalService;
	}

	/**
	 * Returns the conversation persistence.
	 *
	 * @return the conversation persistence
	 */
	public ConversationPersistence getConversationPersistence() {
		return conversationPersistence;
	}

	/**
	 * Sets the conversation persistence.
	 *
	 * @param conversationPersistence the conversation persistence
	 */
	public void setConversationPersistence(
		ConversationPersistence conversationPersistence) {
		this.conversationPersistence = conversationPersistence;
	}

	/**
	 * Returns the opened conversation local service.
	 *
	 * @return the opened conversation local service
	 */
	public OpenedConversationLocalService getOpenedConversationLocalService() {
		return openedConversationLocalService;
	}

	/**
	 * Sets the opened conversation local service.
	 *
	 * @param openedConversationLocalService the opened conversation local service
	 */
	public void setOpenedConversationLocalService(
		OpenedConversationLocalService openedConversationLocalService) {
		this.openedConversationLocalService = openedConversationLocalService;
	}

	/**
	 * Returns the opened conversation persistence.
	 *
	 * @return the opened conversation persistence
	 */
	public OpenedConversationPersistence getOpenedConversationPersistence() {
		return openedConversationPersistence;
	}

	/**
	 * Sets the opened conversation persistence.
	 *
	 * @param openedConversationPersistence the opened conversation persistence
	 */
	public void setOpenedConversationPersistence(
		OpenedConversationPersistence openedConversationPersistence) {
		this.openedConversationPersistence = openedConversationPersistence;
	}

	/**
	 * Returns the settings local service.
	 *
	 * @return the settings local service
	 */
	public SettingsLocalService getSettingsLocalService() {
		return settingsLocalService;
	}

	/**
	 * Sets the settings local service.
	 *
	 * @param settingsLocalService the settings local service
	 */
	public void setSettingsLocalService(
		SettingsLocalService settingsLocalService) {
		this.settingsLocalService = settingsLocalService;
	}

	/**
	 * Returns the settings persistence.
	 *
	 * @return the settings persistence
	 */
	public SettingsPersistence getSettingsPersistence() {
		return settingsPersistence;
	}

	/**
	 * Sets the settings persistence.
	 *
	 * @param settingsPersistence the settings persistence
	 */
	public void setSettingsPersistence(SettingsPersistence settingsPersistence) {
		this.settingsPersistence = settingsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.marcelmika.lims.model.Settings",
			settingsLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.marcelmika.lims.model.Settings");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return Settings.class;
	}

	protected String getModelClassName() {
		return Settings.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = settingsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = BuddyLocalService.class)
	protected BuddyLocalService buddyLocalService;
	@BeanReference(type = BuddyPersistence.class)
	protected BuddyPersistence buddyPersistence;
	@BeanReference(type = ConversationLocalService.class)
	protected ConversationLocalService conversationLocalService;
	@BeanReference(type = ConversationPersistence.class)
	protected ConversationPersistence conversationPersistence;
	@BeanReference(type = OpenedConversationLocalService.class)
	protected OpenedConversationLocalService openedConversationLocalService;
	@BeanReference(type = OpenedConversationPersistence.class)
	protected OpenedConversationPersistence openedConversationPersistence;
	@BeanReference(type = SettingsLocalService.class)
	protected SettingsLocalService settingsLocalService;
	@BeanReference(type = SettingsPersistence.class)
	protected SettingsPersistence settingsPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private SettingsLocalServiceClpInvoker _clpInvoker = new SettingsLocalServiceClpInvoker();
}
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

package com.marcelmika.lims.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Conversation service. Represents a row in the &quot;LiferayLIMS_Conversation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.marcelmika.lims.model.impl.ConversationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.marcelmika.lims.model.impl.ConversationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Conversation
 * @see com.marcelmika.lims.model.impl.ConversationImpl
 * @see com.marcelmika.lims.model.impl.ConversationModelImpl
 * @generated
 */
public interface ConversationModel extends BaseModel<Conversation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a conversation model instance should use the {@link Conversation} interface instead.
	 */

	/**
	 * Returns the primary key of this conversation.
	 *
	 * @return the primary key of this conversation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this conversation.
	 *
	 * @param primaryKey the primary key of this conversation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cid of this conversation.
	 *
	 * @return the cid of this conversation
	 */
	public long getCid();

	/**
	 * Sets the cid of this conversation.
	 *
	 * @param cid the cid of this conversation
	 */
	public void setCid(long cid);

	/**
	 * Returns the user ID of this conversation.
	 *
	 * @return the user ID of this conversation
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this conversation.
	 *
	 * @param userId the user ID of this conversation
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this conversation.
	 *
	 * @return the user uuid of this conversation
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this conversation.
	 *
	 * @param userUuid the user uuid of this conversation
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the conversation ID of this conversation.
	 *
	 * @return the conversation ID of this conversation
	 */
	@AutoEscape
	public String getConversationId();

	/**
	 * Sets the conversation ID of this conversation.
	 *
	 * @param conversationId the conversation ID of this conversation
	 */
	public void setConversationId(String conversationId);

	/**
	 * Returns the conversation type of this conversation.
	 *
	 * @return the conversation type of this conversation
	 */
	@AutoEscape
	public String getConversationType();

	/**
	 * Sets the conversation type of this conversation.
	 *
	 * @param conversationType the conversation type of this conversation
	 */
	public void setConversationType(String conversationType);

	/**
	 * Returns the conversation visibility of this conversation.
	 *
	 * @return the conversation visibility of this conversation
	 */
	@AutoEscape
	public String getConversationVisibility();

	/**
	 * Sets the conversation visibility of this conversation.
	 *
	 * @param conversationVisibility the conversation visibility of this conversation
	 */
	public void setConversationVisibility(String conversationVisibility);

	/**
	 * Returns the conversation name of this conversation.
	 *
	 * @return the conversation name of this conversation
	 */
	@AutoEscape
	public String getConversationName();

	/**
	 * Sets the conversation name of this conversation.
	 *
	 * @param conversationName the conversation name of this conversation
	 */
	public void setConversationName(String conversationName);

	/**
	 * Returns the unread messages of this conversation.
	 *
	 * @return the unread messages of this conversation
	 */
	public int getUnreadMessages();

	/**
	 * Sets the unread messages of this conversation.
	 *
	 * @param unreadMessages the unread messages of this conversation
	 */
	public void setUnreadMessages(int unreadMessages);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Conversation conversation);

	public int hashCode();

	public CacheModel<Conversation> toCacheModel();

	public Conversation toEscapedModel();

	public String toString();

	public String toXmlString();
}
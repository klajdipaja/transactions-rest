package com.elidjongrembi.transactions.service;

import java.util.List;

import com.elidjongrembi.transactions.exception.ServiceException;

public interface BaseService<T> {
	List<T> readAll() throws ServiceException;

	/**
	 * Loads all entities.
	 *
	 * @param offset
	 * @param limit
	 * @return
	 * @throws ServiceException
	 */
	List<T> readAll(Integer offset, Integer limit) throws ServiceException;

	/**
	 * Loads all entities from an offset to a limit.
	 *
	 * @param pk
	 * @return
	 * @throws ServiceException
	 */
	T read(long pk) throws ServiceException;

	/**
	 * Creates the entity.
	 *
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	T create(T entity) throws ServiceException;

	/**
	 * Updates the entity.
	 *
	 * @param entity
	 * @throws ServiceException
	 */
	void update(T entity) throws ServiceException;

	/**
	 * Deletes the entity.
	 *
	 * @param entity
	 * @throws ServiceException
	 */
	void delete(T entity) throws ServiceException;

	/**
	 * Counts all the entities.
	 *
	 * @return
	 * @throws ServiceException
	 */
	int count() throws ServiceException;
	
}

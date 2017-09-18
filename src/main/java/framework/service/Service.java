package framework.service;

import commons.exceptions.ServiceException;

public interface Service<T> {

	public boolean process(T t) throws  ServiceException;

}

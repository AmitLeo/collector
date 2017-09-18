package onboard.common.beans;

import onboard.common.exceptions.DuplicateRecordException;

public interface Service<T> {
	
	public boolean process(T t) throws DuplicateRecordException;

}

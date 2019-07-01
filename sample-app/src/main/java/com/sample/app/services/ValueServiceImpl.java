package com.sample.app.services;

import org.springframework.stereotype.Service;

/**
 * The Class ValueServiceImpl.
 */
@Service
public class ValueServiceImpl implements ValueService {

	int value = 0;

	/* (non-Javadoc)
	 * @see com.sample.app.services.ValueService#increaseValue()
	 */
	public int increaseValue() throws Exception{
		return ++value;
	}

	/* (non-Javadoc)
	 * @see com.sample.app.services.ValueService#decreaseValue()
	 */
	public int decreaseValue() throws Exception{
		return --value;
	}

	/* (non-Javadoc)
	 * @see com.sample.app.services.ValueService#getCurrentValue()
	 */
	public int getCurrentValue() {
		return value;
	}

}

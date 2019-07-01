package com.sample.app.services;

import org.springframework.stereotype.Service;

@Service
public class ValueServiceImpl implements ValueService {

	int value = 0;

	public int incrementValue() {
		return ++value;
	}

	public int decrementValue() {
		return --value;
	}

	public int getCurrentValue() {
		return value;
	}

}

package org.spout.datamap;

abstract class BasicData<T> implements Data<T> {

	private final T value;

	public BasicData(T value) {
		this.value = value;
	}

	@Override
	public T getValue() {
		return value;
	}
}

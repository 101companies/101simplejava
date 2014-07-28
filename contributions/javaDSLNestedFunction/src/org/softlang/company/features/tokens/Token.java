package org.softlang.company.features.tokens;

public abstract class Token<T> {
	private final T value;
	
	public Token(T value){
		this.value = value;
	}
	public T getValue() {
		return value;
	}
}

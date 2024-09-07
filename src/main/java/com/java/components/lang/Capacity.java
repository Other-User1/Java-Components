package com.java.components.lang;

public class Capacity {
    private final int capacity;
	private final int minCapacity;
	private final int maxCapacity;

	public Capacity(int capacity) {
		this.capacity = capacity;
		this.minCapacity = 0;
		this.maxCapacity = Integer.MAX_VALUE;
	}

	public Capacity(int capacity, int minCapacity, int maxCapacity) {
		this.capacity = capacity;
		this.minCapacity = minCapacity;
		this.maxCapacity = maxCapacity;
	}

	int getCapacity() {
		return capacity;
	}

	int getMinimumCapacity() {
		return minCapacity;
	}

	int getMaximumCapacity() {
		return maxCapacity;
	}
}
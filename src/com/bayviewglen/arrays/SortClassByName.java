package com.bayviewglen.arrays;

import java.util.Comparator;

public class SortClassByName implements Comparator<Contact> {

	@Override
	public int compare(Contact a, Contact b) {
		return (a.getLast() + a.getFirst()).compareTo(b.getLast()+b.getFirst());
	}	
}
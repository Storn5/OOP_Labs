package ua.lpnuai.oop.mokryk02;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public class StringIterator implements Iterable<String>, Serializable {
	private String[] data;
	private int size = 0;
	
	public StringIterator() {
		data = new String[0];
	}
	
	public String toString() {
		return data.toString();
	}
	
	public void add(String str) {
		data = Arrays.copyOf(data, data.length+1);
		data[size++] = str;
	}
	
	public void clear() {
		data = new String[0];
	}
	
	public boolean remove(String str) {
		String[] newData = new String[size-1];
		int j = 0;
		for (int i = 0; i < size; i ++)
			if (!data[i].equals(str))
				newData[j++] = data[i];
		size --;
		data = newData;
		return true;
	}
	
	public Object[] toArray() {
		return data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(String str) {
		for (int i = 0; i < size; i ++)
			if (data[i].equals(str))
				return true;
		return false;
	}
	
	public boolean containsAll(StringIterator si) {
		Object[] arr = si.toArray();
		return Arrays.asList(data).containsAll(Arrays.asList(arr));
	}
	
	public class InnerIterator implements Iterator<String> {
		int index;
		
		public InnerIterator() {
			index = 0;
		}
		
		public boolean hasNext() {
			return index < size;
		}
		
		public String next() {
			return data[index++];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public Iterator<String> iterator() {
		return new InnerIterator();
	}
}
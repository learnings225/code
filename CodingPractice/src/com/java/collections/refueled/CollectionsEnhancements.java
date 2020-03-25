package com.java.collections.refueled;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 8 Collections Enhancements:
 * 
 * 		- Lambda/Streams
 * 				- Collections are most common stream source and destination
 * 		- Interfaces: Default methods, static methods
 * 				- Java 8 language feature
 * 				- allows interfaces to be extended compatibly
 * 		- Collection interface enhancements
 * 				- first changes in > 15 years
 * 				- Iterable, Collection, List got a few new methods
 * 				- Map, Comparator got a lot of few new methods
 * 
 * Example explanations:
 * 
 * 		- Iterable.forEach
 * 
 * 				// Java 7
 * 					List<String> list = ... ;
 * 					for(String str: list)
 * 						System.out.println(str);
 * 
 * 				// Java 8
 * 					list.forEach(System.out::println);
 * 
 * 
 * 		- Collection is a sub interface of Iterable, so this works for all collections.
 * 
 * 		- Iterator interface
 * 
 * 			- iterator.remove
 * 			- Most Iterators don't support removal, so everybody had to write:
 *  				
 *  				@Override
 *  				public void remove() {
						throw new UnsupportedOperationException();
					}
					
 * 			- default implementation for remove exactly does this.
 * 			- To write a non-removing Iterator, just omit remove() !
 * 			- To write an Iterator that supports remove(), just override it as usual!!
 * 
 * 		- Collection Interface
 * 			- Collection.removeIf - bulk mutating operation
 * 																						If Collection is ArrayList
 * 				// Java 7
					for(Iterator<String> it : coll.iterator(); it.hasNext();) {
						String s = it.next();
						if(s.startsWith("A")) {														O(n^2)
							it.remove();
						}
					}
 * 
 * 				// Java 8
 * 					coll.removeIf(str -> str.startsWith("A"));										O(n)
 * 
 * 		- List Interface
 * 			- List.replaceAll - bulk mutation operation
 * 			- Transforms each element in-place
 * 
 * 				// Java 7
 * 					for(ListIterator<String> it : list.listIterator(); it.hasNext();) {
						it.set(it.next().toUpperCase());
					}
					
					for(int i = 0; i < list.size(); i++) {
						list.set(i, list.get(i).toUpperCase());
					}
					
					
				// Java 8
					list.replaceAll(String :: toUpperCase);
					
								Note: Can't change the element type. To do that, use a Stream
				
 * 		- List Interface
 * 			- List.sort - sorts a list in-place
 * 			- Why is this better than Collections.sort?
 * 				- old Collections.sort used three step process:
 * 						- copy into a temporary array
 * 						- sort the array
 * 						- copy back to the list
 * 
 * 			- List.sort
 * 				- default does exactly the above
 * 				- ArrayList.sort overrides and sorts in-place - no copying!!
 * 				- Collections.sort now just calls list.sort - callers automatically benefit
 * 
 * 		- Map Interface: forEach
 * 				// Java 7
 * 					for(Map.Entry<String, String> entry: map.entrySet()) {
 * 						System.out.println(entry.getKey + " : " + entry.getValue());
 * 					}
 * 
 * 				// Java 8
 * 					map.forEach((k, v) -> System.out.println(k + " : " + v));
 * 
 * 		- Map Interface: replaceAll
 * 				// Java 7
 * 					for(Map.Entry<String, String> entry: map.entrySet()) {
 * 						entry.setValue(entry.getValue().toUpperCase());
 * 					}
 * 
 * 				// Java 8
 * 					map.replaceAll((k, v) -> v.toUpperCase()));
 * 
 * 
 * 		- Map Interface: "Multi-map" example
 * 			- Multimap: like a map, with multiple values for each key
 * 				- Guava, and Eclipse collections have nice implementations
 * 
 * 			- Example: simplified Multimap using Map<String, Set<Integer>>
 * 					Map<String, Set<Integer>> multimap = new HashMap<>();
 * 
 * 			- doing this in plain java 7 is quite painful
 * 
 * 			// Java 7
 * 				// put(str, i);
 * 
 * 				Set<Integer> set = multimap.get(str);
 * 				if(set == null) {
 * 					set = new HashSet<>();
 * 					multimap.put(str, set);
 * 				}
 * 
 * 				set.add(i);
 * 
 * 				// remove(str, i);
 * 
 * 				Set<Integer> set = multimap.get(str);
 * 				if(set != null) {
 * 					if(set.remove(i) && set.isEmpty()) {
 * 					multimap.remove(str);
 * 					...									// BLEAH!!
 * 				}
 * 
 * 
 * 			// Java 8
 * 
 * 				// put(str, i)
 * 				multimap.computeIfAbsent(str, x -> new HashSet<>()).add(i);
 * 				
 * 				// remove(str, i);
 * 				multimap.computeIfPresent(k, (k1, set) -> set.remove(v) && set.isEmpty() ? null : set);
 * 
 * 				// contains(str, i)
 * 				multimap.getOrDefault(str, Collections.emptySet()).contains(i);
 * 
 * 				// size()
 * 				multimap.values().stream().mapToInt(Set::size).sum();
 * 
 * 				// values()
 * 				multimap.values().stream().flatMap(Set::stream);
 * 
 * 
 * 		- Comparator Interface
 * 			- Comparators are difficult because there are lots of conditionals and repeated code
 * 			- Java 8 adds static and default methods to Comparator that:
 * 				- avoid repeated code
 * 				- allow composition of arbitrary to make more complex ones
 * 				- easily create null-friendly comparators
 * 			- Comparator Example
 * 				- two-level sort: sort by last name, then by nullable first name, nulls first
 * 
 * 				// Java 7
 * 					Collections.sort(students, new Comparator<Student>() {
 * 						@Override
 * 						public int compare(Student s1, Student s2) {
 * 							int r = s1.getLastName().compareTo(s2.getLastName());
 * 							if(r != 0) 
 * 								return r;
 * 							String f1 = s1.getFirstName();
 * 							String f2 = s2.getFirstName();
 * 							if(f1 == null) {
 * 								return f2 == null ? 0 : -1;
 * 							} else {
 * 								return f2 == null ? 1 : f1.compareTo(f2);
 * 							}
 * 						}
 * 					});
 * 
 * 
 * 				// Java 8 - Statement Lambda
 * 					Collections.sort(students, (s1, s2) -> {
 * 							int r = s1.getLastName().compareTo(s2.getLastName());
 * 							if(r != 0) 
 * 								return r;
 * 							String f1 = s1.getFirstName();
 * 							String f2 = s2.getFirstName();
 * 							if(f1 == null) {
 * 								return f2 == null ? 0 : -1;
 * 							} else {
 * 								return f2 == null ? 1 : f1.compareTo(f2);
 * 							}
 * 					});
 * 
 * 				// Java 8 Comparator Methods
 * 
 * 					students.sort(comparing(Student :: getLastName)
 * 									.thenComparing(Student::getFirstName,
 * 												nullsFirst(naturalOrder())));
 * 
 * Java 9 Collection Enhancements:
 * 
 * 
 * 
 * 
 * https://www.youtube.com/watch?v=LgR9ByD1dEw
 * 
 * @author srimeda
 *
 */
public class CollectionsEnhancements {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
	}
}

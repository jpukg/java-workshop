package com.jos.dem.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

public class PredicateTest {

	private List<Person> persons = Arrays.asList(
		new Person("josdem", 5), 
		new Person("tgrip", 4), 
		new Person("edzero", 3), 
		new Person("jeduan", 5), 
		new Person("siedrix", 5)
	);

	@Test
	public void shouldGetPersonsWithFourInRankingOrMore(){
		Predicate<Person> isHighRanked = person -> person.getRanking() >= 4;
		assertEquals(4, persons.stream().filter(isHighRanked).count());
	}

	@Test
	public void shouldGetPersonsHihgRankedAndStartsWithJ(){
		Predicate<Person> isHighRanked = person -> person.getRanking() >= 4;
		Predicate<Person> startsWithJ = person -> person.getNickname().startsWith("j");
		assertEquals(2, persons.stream()
										.filter(isHighRanked)
                    .filter(startsWithJ)
                    .count());
	}

}

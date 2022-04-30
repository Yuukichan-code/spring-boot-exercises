package com.yuukiexample.batchprocessing

import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor
import java.util.*

class PersonItemProcessor : ItemProcessor<Person, Person> {
    @Throws(Exception::class)
    override fun process(person: Person): Person {
        val firstName = person.firstName.uppercase(Locale.getDefault())
        val lastName = person.lastName.uppercase(Locale.getDefault())
        val transformedPerson = Person(firstName, lastName)
        log.info("Converting ($person) into ($transformedPerson)")
        return transformedPerson
    }

    companion object {
        private val log = LoggerFactory.getLogger(PersonItemProcessor::class.java)
    }
}
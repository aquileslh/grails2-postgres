package com.tekdays

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TekUser)
class TekEventTests {

    /*void testSomething() {
       fail "Implement me"
    }*/

    void "test toString"() {
			when: "a tekEvent has a name and a city"
				def tekEvent = new TekEvent(name:'Groovy One',
					city: 'San Francisco',
					organizer: [fullName: 'John Doe']as TekUser)
			
			then: "the toString method will combine them."
			
			tekEvent.toString() == 'Groovy One, San Pancho'
		}
}
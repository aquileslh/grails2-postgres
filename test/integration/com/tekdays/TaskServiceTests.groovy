package com.tekdays

import static org.junit.Assert.*
import org.junit.*

class TaskServiceTests {

def taskService

	@Before
	void setUp() {
		// Setup logic here
		new TekUser( fullName : 'Tammy tester',
			userName : 'tester',
			email : 'tester@gmail.com',
			webSite : 'test.blog.com.mx',
			bio : 'Un test personal').save()
	}

	@After
	void tearDown() {
		// Tear down logic here
	}

	@Test
	void "test addDefaultTasks"() {
		when : "nosotros pasamos un evento"
		def e = new TekEvent(name : 'Test event',
			city : 'test city',
			description : 'Mi primer test',
			organizer : TekUser.findByUserName('tester'),
			venue : 'Test Center',
			startDate: new Date('02/16/2017'),
    	endDate: new Date('02/18/2017'))
		taskService.addDefaultTask(e)
		then : "El evento tiene 6 tareas por default"
		e.tasks.size() == 6
	}
}
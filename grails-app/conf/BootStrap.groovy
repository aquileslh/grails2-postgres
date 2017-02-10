import com.tekdays.*

class BootStrap {

    def init = { servletContext ->
    	def event1 = new TekEvent (name: 'Codigo groovy',
    		city: 'Chiapas',
    		organizer: 'picaho',
    		venue: 'TDD',
    		startDate: new Date('02/15/2017'),
    		endDate: new Date('02/20/2017'),
    		description: 'nuevo taller para programadores iniciales')
    	if ( !event1.save() ) {
    		event1.errors.allErrors.each{error ->
    			println "Un error ocurrio con el event1: ${error}"
    		}
    	}
    }

    def destroy = {
    }

}

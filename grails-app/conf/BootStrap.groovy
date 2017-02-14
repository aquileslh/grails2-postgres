import com.tekdays.*

class BootStrap {

    def init = { servletContext -> //Inicio

    	/*def usr1 = new TekUser(fullName: 'Omar',
    		userName: 'omar',
    		password: 'omar',
    		email: 'omar@gmail.com',
    		webSite: 'omar.blog.com.mx',
    		bio: 'desarrollador java')
    	if ( !usr1.save() ) {
    		usr1.errors.allErrors.each{error ->
    			println "Un error ocurrio en usr1: ${error}"
    		}
    	}

    	def event1 = new TekEvent(name: 'java',
    		city: 'jeruco',
    		organizer: TekUser.findByFullName('Omar'),
    		venue: 'TDT',
    		startDate: new Date('02/16/2017'),
    		endDate: new Date('02/18/2017'),
    		description: 'programacion en java'
    		)
    	if ( !event1.save() ) {
    		usr1.errors.allErrors.each{error ->
    			println "Un error ocurrio en event1: ${error}"
    		}
    	}
*/
        def g1 = TekEvent.findByName('java')
  /*      g1.addToVolunteers(new TekUser(fullName: 'Sarah',
            userName: 'sarah',
            password: 'sarah',
            email: 'sarah@gmail.com',
            webSite: 'www.sarah.com.mx',
            bio: 'desarrolladora')
            )
        g1.addToVolunteers(new TekUser(fullName: 'Bill',
            userName: 'bill',
            password: 'bill',
            email: 'bill@gmail.com',
            webSite: 'www.bill.com.mx',
            bio: 'desarrollador de software'
            ))
        g1.save()

        g1.addToRespondents('ben@gmail.com')
        g1.addToRespondents('zachary@gmail.com')
        g1.addToRespondents('salomon@gmail.com')
        g1.save()

        def s1 = new Sponsor(name : 'Contegix',
            webSite : 'http://www.contegix.com.mx',
            description : 'nueva empresa')
        s1.save()
        def s2 = new Sponsor(name : 'computing incorporated',
            webSite : 'http://www.computing.com.mx',
            description: 'software engineering')
        s2.save()
*/
        def s1 = Sponsor.findByName('Contegix')
        def s2 = Sponsor.findByName('computing incorporated')
        def sp1 = new Sponsorship(event : g1,
            sponsor : s1,
            contributionType : 'Other',
            description : 'cool t-shirts')
        sp1.save()

        def sp2 = new Sponsorship(event : g1,
            sponsor : s2,
            contributionType : 'Venue',
            description: 'puedes jugar para el moscone')
        sp2.save()
        
    }//Fin del init 

    def destroy = {
    }

}

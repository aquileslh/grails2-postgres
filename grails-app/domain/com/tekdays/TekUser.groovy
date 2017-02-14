package com.tekdays

class TekUser {

	String fullName
	String userName
	String password
	String email
	String webSite
	String bio

	static constraints = {
		fullName()
		userName()
		email()
		webSite()
		bio maxSize: 5000
	}

	String toString () { fullName }
}

package com.tekdays

class Sponsor {

	String name
	String webSite
	String description
	byte[] logo

	static constraints = {
		name blank : false
		webSite blank : false, url: true
		description nullable : true, maxSize : 5000
		logo nullable : true, maxSize : 1000000
		sponsorships nullable : true
	}

	static hasMany = [sponsorships : Sponsorship]
	String toString(){
		name
	}
}

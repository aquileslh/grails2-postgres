package com.tekdays

import static org.springframework.http.HttpStatus.*
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class ApiTekEventController {
	
	static allowedMethods = [save : "POST", update : "PUT", delete : "DELETE"]

	def index(Integer max){
		params.max = Math.min(max ?: 10, 100)
		respond TekEvent.list(params),
			model : [ tekEventInstanceCount : TekEvent.count() ]
	}

}
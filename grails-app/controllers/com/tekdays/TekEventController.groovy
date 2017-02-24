package com.tekdays

import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional
import org.springframework.transaction.annotation.Transactional
import org.springframework.dao.DataIntegrityViolationException

class TekEventController {

    def taskService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    @Transactional(readOnly = true)
    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [tekEventInstanceList: TekEvent.list(params), tekEventInstanceTotal: TekEvent.count()]
    }

    @Transactional
    def create() {
        [tekEventInstance: new TekEvent(params)]
    }

    @Transactional
    def save() {
        def tekEventInstance = new TekEvent(params)
        tekEventInstance.startDate = new Date('02/16/2017')
        
        if (tekEventInstance.save(flush: true)) {
            taskService.addDefaultTask ( tekEventInstance )
        }else{
            render(view: "create", model: [tekEventInstance: tekEventInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), tekEventInstance.id])
        redirect(action: "show", id: tekEventInstance.id)
    }

        @Transactional(readOnly = true)
        def show(Long id) {
            def tekEventInstance = TekEvent.get(id)
            if (!tekEventInstance) {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), id])
                redirect(action: "list")
                return
            }

            [tekEventInstance: tekEventInstance]
        }

        @Transactional
        def edit(Long id) {
            def tekEventInstance = TekEvent.get(id)
            if (!tekEventInstance) {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), id])
                redirect(action: "list")
                return
            }

            [tekEventInstance: tekEventInstance]
        }

        @Transactional
        def update(Long id, Long version) {
            def tekEventInstance = TekEvent.get(id)
            if (!tekEventInstance) {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), id])
                redirect(action: "list")
                return
            }

            if (version != null) {
                if (tekEventInstance.version > version) {
                    tekEventInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                      [message(code: 'tekEvent.label', default: 'TekEvent')] as Object[],
                      "Another user has updated this TekEvent while you were editing")
                    render(view: "edit", model: [tekEventInstance: tekEventInstance])
                    return
                }
            }

            tekEventInstance.properties = params

            if (!tekEventInstance.save(flush: true)) {
                render(view: "edit", model: [tekEventInstance: tekEventInstance])
                return
            }

            flash.message = message(code: 'default.updated.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), tekEventInstance.id])
            redirect(action: "show", id: tekEventInstance.id)
        }

        def delete(Long id) {
            def tekEventInstance = TekEvent.get(id)
            if (!tekEventInstance) {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), id])
                redirect(action: "list")
                return
            }

            try {
                tekEventInstance.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), id])
                redirect(action: "list")
            }
            catch (DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), id])
                redirect(action: "show", id: id)
            }
        }
    }

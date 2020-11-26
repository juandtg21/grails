package binxhealth

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PartnerStatesAvailableController {

    PartnerStatesAvailableService partnerStatesAvailableService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond partnerStatesAvailableService.list(params), model:[partnerStatesAvailableCount: partnerStatesAvailableService.count()]
    }

    def show(Long id) {
        respond partnerStatesAvailableService.get(id)
    }

    def create() {
        respond new PartnerStatesAvailable(params)
    }

    def save(PartnerStatesAvailable partnerStatesAvailable) {
        if (partnerStatesAvailable == null) {
            notFound()
            return
        }

        try {
            partnerStatesAvailableService.save(partnerStatesAvailable)
        } catch (ValidationException e) {
            respond partnerStatesAvailable.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'partnerStatesAvailable.label', default: 'PartnerStatesAvailable'), partnerStatesAvailable.id])
                redirect partnerStatesAvailable
            }
            '*' { respond partnerStatesAvailable, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond partnerStatesAvailableService.get(id)
    }

    def update(PartnerStatesAvailable partnerStatesAvailable) {
        if (partnerStatesAvailable == null) {
            notFound()
            return
        }

        try {
            partnerStatesAvailableService.save(partnerStatesAvailable)
        } catch (ValidationException e) {
            respond partnerStatesAvailable.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'partnerStatesAvailable.label', default: 'PartnerStatesAvailable'), partnerStatesAvailable.id])
                redirect partnerStatesAvailable
            }
            '*'{ respond partnerStatesAvailable, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        partnerStatesAvailableService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'partnerStatesAvailable.label', default: 'PartnerStatesAvailable'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'partnerStatesAvailable.label', default: 'PartnerStatesAvailable'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

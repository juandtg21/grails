package binxhealth

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MissingOrdersController {

    MissingOrdersService missingOrdersService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond missingOrdersService.list(params), model:[missingOrdersCount: missingOrdersService.count(),missingOrdersList:missingOrdersService.list()]
    }

    def show(Long id) {
        respond missingOrdersService.get(id)
    }

    def create() {
        respond new MissingOrders(params)
    }

    def save(MissingOrders missingOrders) {
        if (missingOrders == null) {
            notFound()
            return
        }

        try {
            missingOrdersService.save(missingOrders)
        } catch (ValidationException e) {
            respond missingOrders.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'missingOrders.label', default: 'MissingOrders'), missingOrders.id])
                redirect missingOrders
            }
            '*' { respond missingOrders, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond missingOrdersService.get(id)
    }

    def update(MissingOrders missingOrders) {
        if (missingOrders == null) {
            notFound()
            return
        }

        try {
            missingOrdersService.save(missingOrders)
        } catch (ValidationException e) {
            respond missingOrders.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'missingOrders.label', default: 'MissingOrders'), missingOrders.id])
                redirect missingOrders
            }
            '*'{ respond missingOrders, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        missingOrdersService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'missingOrders.label', default: 'MissingOrders'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'missingOrders.label', default: 'MissingOrders'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

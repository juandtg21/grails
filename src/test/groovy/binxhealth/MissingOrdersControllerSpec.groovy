package binxhealth

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.*

class MissingOrdersControllerSpec extends Specification implements ControllerUnitTest<MissingOrdersController> {


    def fillFields(fields) {
        fields["first_name"] = "test1"
        fields["last_name"] = "test1"
        fields["dob"] = 17-11-2020
        fields["barcode"] = "1"
        fields["received_date"] = 17-11-2020
        fields["email"] = "test1@gmail.com"
        fields["error_code"] = "1"

        assert fields != null

        return fields
    }

    void "Test index return a correct model" () {
        given: "a mock Missing Orders Service and a list of missing orders"
        List<MissingOrders> missingOrders = [new MissingOrders(first_name: "test1", last_name: "test1", dob: 17-11-2020,
                barcode: "1",received_date: 17-11-2020, email: "test1@gmail.com", error_code: "1")]
        MissingOrdersService missingOrderService = Mock(MissingOrdersService)
        controller.missingOrdersService = missingOrderService
        2 * missingOrderService.list(_) >> missingOrders
        1 * missingOrderService.count() >> missingOrders.size()

        when: "The index is executed"
        controller.index(1)

        then:
        model.missingOrdersList
        model.missingOrdersList.find { it.first_name == 'test1'}
        model.missingOrdersCount == 1
    }

    void "Test save method Missing Orders"() {
        given: "a mock Missing Orders Service"
        MissingOrdersService missingOrderService = Mock(MissingOrdersService)
        controller.missingOrdersService = missingOrderService
        1 * missingOrderService.save(_)

        when: "The save method is executed with valid fields"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def missingOrders = new MissingOrders(fillFields(params))
        missingOrders.id = 1
        controller.save(missingOrders)

        then: "Show the values saved in /missingOrders/show/1"
        response.redirectedUrl == '/missingOrders/show/1'
    }
    void "Test Show method with a valid id"() {
        given: "a mock Missing Orders Service and a valid id"
        MissingOrdersService missingOrderService = Mock(MissingOrdersService)
        controller.missingOrdersService = missingOrderService
        1 * missingOrderService.get(1) >> new MissingOrders()

        when:"the model is pass to the show method"
        controller.show(1)

        then:"A model is populated properly with the domain"
        model.missingOrders instanceof MissingOrders
    }
    void "Test the update action correctly persists"() {
        given: "a mock Missing Orders Service"
        MissingOrdersService missingOrderService = Mock(MissingOrdersService)
        controller.missingOrdersService = missingOrderService
        1 * missingOrderService.save(_)

        when: "The update method is executed with valid fields"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        def missingOrders = new MissingOrders(fillFields(params))
        missingOrders.id = 1
        controller.update(missingOrders)

        then: "Show the values saved in /missingOrders/show/1"
        response.redirectedUrl == '/missingOrders/show/1'
    }
    void "Test the edit method with a valid id"() {
        given: "a mock Missing Orders Service"
        MissingOrdersService missingOrderService = Mock(MissingOrdersService)
        controller.missingOrdersService = missingOrderService
        1 * missingOrderService.get(1) >> new MissingOrders()

        when:"A domain instance is passed to the show action"
        controller.edit(1)

        then:"A model is populated containing the domain instance"
        model.missingOrders instanceof MissingOrders
    }
    void "Test the delete method with a valid id" () {
        given: "a mock Missing Orders Service"
        MissingOrdersService missingOrderService = Mock(MissingOrdersService)
        controller.missingOrdersService = missingOrderService
        1 * missingOrderService.delete(1)

        when:"the model id is send to the delete method"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(1)

        then:"The user is redirected to index"
        response.redirectedUrl == '/missingOrders/index'
    }

}







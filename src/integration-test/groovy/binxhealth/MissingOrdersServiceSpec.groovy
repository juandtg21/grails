package binxhealth

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MissingOrdersServiceSpec extends Specification {

    MissingOrdersService missingOrdersService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MissingOrders(...).save(flush: true, failOnError: true)
        //new MissingOrders(...).save(flush: true, failOnError: true)
        //MissingOrders missingOrders = new MissingOrders(...).save(flush: true, failOnError: true)
        //new MissingOrders(...).save(flush: true, failOnError: true)
        //new MissingOrders(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //missingOrders.id
    }

    void "test get"() {
        setupData()

        expect:
        missingOrdersService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MissingOrders> missingOrdersList = missingOrdersService.list(max: 2, offset: 2)

        then:
        missingOrdersList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        missingOrdersService.count() == 5
    }

    void "test delete"() {
        Long missingOrdersId = setupData()

        expect:
        missingOrdersService.count() == 5

        when:
        missingOrdersService.delete(missingOrdersId)
        sessionFactory.currentSession.flush()

        then:
        missingOrdersService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MissingOrders missingOrders = new MissingOrders()
        missingOrdersService.save(missingOrders)

        then:
        missingOrders.id != null
    }
}

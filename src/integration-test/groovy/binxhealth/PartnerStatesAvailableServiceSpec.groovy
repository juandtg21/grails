package binxhealth

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PartnerStatesAvailableServiceSpec extends Specification {

    PartnerStatesAvailableService partnerStatesAvailableService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PartnerStatesAvailable(...).save(flush: true, failOnError: true)
        //new PartnerStatesAvailable(...).save(flush: true, failOnError: true)
        //PartnerStatesAvailable partnerStatesAvailable = new PartnerStatesAvailable(...).save(flush: true, failOnError: true)
        //new PartnerStatesAvailable(...).save(flush: true, failOnError: true)
        //new PartnerStatesAvailable(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //partnerStatesAvailable.id
    }

    void "test get"() {
        setupData()

        expect:
        partnerStatesAvailableService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PartnerStatesAvailable> partnerStatesAvailableList = partnerStatesAvailableService.list(max: 2, offset: 2)

        then:
        partnerStatesAvailableList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        partnerStatesAvailableService.count() == 5
    }

    void "test delete"() {
        Long partnerStatesAvailableId = setupData()

        expect:
        partnerStatesAvailableService.count() == 5

        when:
        partnerStatesAvailableService.delete(partnerStatesAvailableId)
        sessionFactory.currentSession.flush()

        then:
        partnerStatesAvailableService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PartnerStatesAvailable partnerStatesAvailable = new PartnerStatesAvailable()
        partnerStatesAvailableService.save(partnerStatesAvailable)

        then:
        partnerStatesAvailable.id != null
    }
}

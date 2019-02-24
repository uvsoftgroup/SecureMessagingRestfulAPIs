package uvsoftgroup.securemessagingrestfulapis

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AddressLocationInfoServiceSpec extends Specification {

    AddressLocationInfoService addressLocationInfoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AddressLocationInfo(...).save(flush: true, failOnError: true)
        //new AddressLocationInfo(...).save(flush: true, failOnError: true)
        //AddressLocationInfo addressLocationInfo = new AddressLocationInfo(...).save(flush: true, failOnError: true)
        //new AddressLocationInfo(...).save(flush: true, failOnError: true)
        //new AddressLocationInfo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //addressLocationInfo.id
    }

    void "test get"() {
        setupData()

        expect:
        addressLocationInfoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AddressLocationInfo> addressLocationInfoList = addressLocationInfoService.list(max: 2, offset: 2)

        then:
        addressLocationInfoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        addressLocationInfoService.count() == 5
    }

    void "test delete"() {
        Long addressLocationInfoId = setupData()

        expect:
        addressLocationInfoService.count() == 5

        when:
        addressLocationInfoService.delete(addressLocationInfoId)
        sessionFactory.currentSession.flush()

        then:
        addressLocationInfoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AddressLocationInfo addressLocationInfo = new AddressLocationInfo()
        addressLocationInfoService.save(addressLocationInfo)

        then:
        addressLocationInfo.id != null
    }
}

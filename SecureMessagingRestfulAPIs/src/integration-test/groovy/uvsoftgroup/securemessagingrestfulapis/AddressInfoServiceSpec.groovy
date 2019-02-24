package uvsoftgroup.securemessagingrestfulapis

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AddressInfoServiceSpec extends Specification {

    AddressInfoService addressInfoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AddressInfo(...).save(flush: true, failOnError: true)
        //new AddressInfo(...).save(flush: true, failOnError: true)
        //AddressInfo addressInfo = new AddressInfo(...).save(flush: true, failOnError: true)
        //new AddressInfo(...).save(flush: true, failOnError: true)
        //new AddressInfo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //addressInfo.id
    }

    void "test get"() {
        setupData()

        expect:
        addressInfoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AddressInfo> addressInfoList = addressInfoService.list(max: 2, offset: 2)

        then:
        addressInfoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        addressInfoService.count() == 5
    }

    void "test delete"() {
        Long addressInfoId = setupData()

        expect:
        addressInfoService.count() == 5

        when:
        addressInfoService.delete(addressInfoId)
        sessionFactory.currentSession.flush()

        then:
        addressInfoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AddressInfo addressInfo = new AddressInfo()
        addressInfoService.save(addressInfo)

        then:
        addressInfo.id != null
    }
}

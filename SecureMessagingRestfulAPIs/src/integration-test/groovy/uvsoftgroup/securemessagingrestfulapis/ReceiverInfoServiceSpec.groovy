package uvsoftgroup.securemessagingrestfulapis

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReceiverInfoServiceSpec extends Specification {

    ReceiverInfoService receiverInfoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ReceiverInfo(...).save(flush: true, failOnError: true)
        //new ReceiverInfo(...).save(flush: true, failOnError: true)
        //ReceiverInfo receiverInfo = new ReceiverInfo(...).save(flush: true, failOnError: true)
        //new ReceiverInfo(...).save(flush: true, failOnError: true)
        //new ReceiverInfo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //receiverInfo.id
    }

    void "test get"() {
        setupData()

        expect:
        receiverInfoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ReceiverInfo> receiverInfoList = receiverInfoService.list(max: 2, offset: 2)

        then:
        receiverInfoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        receiverInfoService.count() == 5
    }

    void "test delete"() {
        Long receiverInfoId = setupData()

        expect:
        receiverInfoService.count() == 5

        when:
        receiverInfoService.delete(receiverInfoId)
        sessionFactory.currentSession.flush()

        then:
        receiverInfoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ReceiverInfo receiverInfo = new ReceiverInfo()
        receiverInfoService.save(receiverInfo)

        then:
        receiverInfo.id != null
    }
}

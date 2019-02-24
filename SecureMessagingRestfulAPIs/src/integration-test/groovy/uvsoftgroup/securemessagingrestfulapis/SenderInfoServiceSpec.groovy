package uvsoftgroup.securemessagingrestfulapis

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SenderInfoServiceSpec extends Specification {

    SenderInfoService senderInfoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SenderInfo(...).save(flush: true, failOnError: true)
        //new SenderInfo(...).save(flush: true, failOnError: true)
        //SenderInfo senderInfo = new SenderInfo(...).save(flush: true, failOnError: true)
        //new SenderInfo(...).save(flush: true, failOnError: true)
        //new SenderInfo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //senderInfo.id
    }

    void "test get"() {
        setupData()

        expect:
        senderInfoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SenderInfo> senderInfoList = senderInfoService.list(max: 2, offset: 2)

        then:
        senderInfoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        senderInfoService.count() == 5
    }

    void "test delete"() {
        Long senderInfoId = setupData()

        expect:
        senderInfoService.count() == 5

        when:
        senderInfoService.delete(senderInfoId)
        sessionFactory.currentSession.flush()

        then:
        senderInfoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SenderInfo senderInfo = new SenderInfo()
        senderInfoService.save(senderInfo)

        then:
        senderInfo.id != null
    }
}

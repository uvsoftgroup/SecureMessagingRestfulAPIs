package uvsoftgroup.securemessagingrestfulapis

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UserRegistrationServiceSpec extends Specification {

    UserRegistrationService userRegistrationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UserRegistration(...).save(flush: true, failOnError: true)
        //new UserRegistration(...).save(flush: true, failOnError: true)
        //UserRegistration userRegistration = new UserRegistration(...).save(flush: true, failOnError: true)
        //new UserRegistration(...).save(flush: true, failOnError: true)
        //new UserRegistration(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //userRegistration.id
    }

    void "test get"() {
        setupData()

        expect:
        userRegistrationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UserRegistration> userRegistrationList = userRegistrationService.list(max: 2, offset: 2)

        then:
        userRegistrationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        userRegistrationService.count() == 5
    }

    void "test delete"() {
        Long userRegistrationId = setupData()

        expect:
        userRegistrationService.count() == 5

        when:
        userRegistrationService.delete(userRegistrationId)
        sessionFactory.currentSession.flush()

        then:
        userRegistrationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UserRegistration userRegistration = new UserRegistration()
        userRegistrationService.save(userRegistration)

        then:
        userRegistration.id != null
    }
}

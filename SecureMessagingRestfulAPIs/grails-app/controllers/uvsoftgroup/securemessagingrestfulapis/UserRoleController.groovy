package uvsoftgroup.securemessagingrestfulapis

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UserRoleController {

    UserRoleService userRoleService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userRoleService.list(params), model:[userRoleCount: userRoleService.count()]
    }

    def show(Long id) {
        respond userRoleService.get(id)
    }

    def save(UserRole userRole) {
        if (userRole == null) {
            render status: NOT_FOUND
            return
        }

        try {
            userRoleService.save(userRole)
        } catch (ValidationException e) {
            respond userRole.errors, view:'create'
            return
        }

        respond userRole, [status: CREATED, view:"show"]
    }

    def update(UserRole userRole) {
        if (userRole == null) {
            render status: NOT_FOUND
            return
        }

        try {
            userRoleService.save(userRole)
        } catch (ValidationException e) {
            respond userRole.errors, view:'edit'
            return
        }

        respond userRole, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        userRoleService.delete(id)

        render status: NO_CONTENT
    }


}

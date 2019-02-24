package uvsoftgroup.securemessagingrestfulapis

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AddressInfoController {

    AddressInfoService addressInfoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond addressInfoService.list(params), model:[addressInfoCount: addressInfoService.count()]
    }

    def show(Long id) {
        respond addressInfoService.get(id)
    }

    def save(AddressInfo addressInfo) {
        if (addressInfo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            addressInfoService.save(addressInfo)
        } catch (ValidationException e) {
            respond addressInfo.errors, view:'create'
            return
        }

        respond addressInfo, [status: CREATED, view:"show"]
    }

    def update(AddressInfo addressInfo) {
        if (addressInfo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            addressInfoService.save(addressInfo)
        } catch (ValidationException e) {
            respond addressInfo.errors, view:'edit'
            return
        }

        respond addressInfo, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        addressInfoService.delete(id)

        render status: NO_CONTENT
    }
}

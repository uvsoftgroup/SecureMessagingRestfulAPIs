package uvsoftgroup.securemessagingrestfulapis

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/userregistrations"(resources:'userRegistration') {
            collection {
                "/userroles"(action:"index")
            }
        }
        "/userregistrations"(resources:'userRegistration') {
            collection {
                "/senderinfos"(action:"index")
            }
        }

        "/userregistrations"(resources:'userRegistration') {
            collection {
                "/receiverinfos"(action:"index")
            }
        }

        "/userregistrations"(resources:'userRegistration') {
            collection {
                "/addressinfos"(action:"index")
            }
        }

        "/userregistrations"(resources:'userRegistration') {
            collection {
                "/addresslocationinfos"(action:"index")
            }
        }

        "/userregistrations"(resources:'userRegistration') {
            "/addressinfos"(resources:"AddressInfo"){
                        "/addresslocationinfos"(resources:"addressLocationInfo")
                    }
            "/receiverinfos"(resources:"receiverInfo")
            "/senderinfos"(resources:"senderInfo")
            "/userroles"(resources:"userRole")
            "/addressinfos"(resources:"addressInfo")
            "/addresslocationinfos"(resources:"addressLocationInfo")
        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}

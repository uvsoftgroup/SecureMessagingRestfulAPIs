package uvsoftgroup.securemessagingrestfulapis

import java.util.Date
import grails.rest.Resource
import grails.databinding.BindingFormat

@Resource(uri = '/userroles')
class UserRole implements Serializable {
 Long userRoleId
 String userRoleName,userRoleType
 @BindingFormat('yyyy-MM-dd')
 Date userRoleDate

 static constraints = {
  userRoleId()
  userRoleName(inList: ["Admin Tasks", "Officer Tasks", "Web General User"])
  userRoleType(inList: ["Admin", "Officer", "General User"])
  userRoleDate()
    }
 static belongsTo =[userRegistrations:UserRegistration]

 static mapping = {
  table 'user_role'
  version true
  columns {
   id generator: 'uvsoftgroup.securemessagingrestfulapis.utility.UserRoleIdGenerator'
  }
 }

}


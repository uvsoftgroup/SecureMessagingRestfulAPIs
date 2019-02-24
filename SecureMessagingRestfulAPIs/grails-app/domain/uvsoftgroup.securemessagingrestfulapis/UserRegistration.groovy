package uvsoftgroup.securemessagingrestfulapis

import java.util.Date
import grails.rest.Resource
import grails.databinding.BindingFormat

@Resource(uri = '/userregistrations')
class UserRegistration implements  Serializable {
 Long userRegistrationId,userAddressId
 String userRegistrationFName,userRegistrationMName,userRegistrationLName
 String userRegistrationfullName,userRegistrationName,userRegistrationPassword
 @BindingFormat('yyyy-MM-dd')
 Date userRegistrationCrDate,userRegistrationLDate

 static hasMany =[roles:UserRole,addresses:AddressInfo,senders:SenderInfo,receivers:ReceiverInfo]

 static constraints = {
  userRegistrationId()
  userAddressId()
  userRegistrationFName()
  userRegistrationMName()
  userRegistrationLName()
  userRegistrationfullName()
  userRegistrationCrDate()
  userRegistrationLDate()
  userRegistrationName(unique: true)
  userRegistrationPassword(password: true)
  roles()
  addresses()
  senders()
  receivers()
 }
 static mapping = {
  table 'user_registration'
  version true
  columns {
   id generator: 'uvsoftgroup.securemessagingrestfulapis.utility.UserRegistrationIdGenerator'
  }
 }

}

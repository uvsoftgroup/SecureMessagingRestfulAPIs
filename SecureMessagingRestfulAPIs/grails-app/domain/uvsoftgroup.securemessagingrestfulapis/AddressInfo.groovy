package uvsoftgroup.securemessagingrestfulapis

import java.util.Date
import grails.rest.Resource
import grails.databinding.BindingFormat

@Resource(uri = '/addressinfos')
class AddressInfo implements Serializable {
 Long adId,adalId,adJobId
 String adFirstName,adMiddleName,adLastName,adBirthCertificateNumber
 @BindingFormat('yyyy-MM-dd')
 Date adBirthDate,adJoiningDate
 byte[] adBirthCertificateNumberPic,adNationalIdNumberPic,adPassportNumberPic
 String adNationalIdNumber,adPassportNumber,adSexStatus,adMobileNumber
 String adLandNumber,adEMail,adWeb,adWifeOrHaFullName,adWifeOrHusbandNationalId
 String adFamilySize,adEducationLevel,adJobStatus,adJobPosition,adJobProvider
 String adJobType,adFatherFullName,adFatherNationalId,adMotherFullName,adMotherNationalId

 static hasMany =[addressLocation:AddressLocationInfo]

 static constraints = {
  adId()
  adalId()
  adFirstName()
  adMiddleName()
  adLastName()
  adBirthDate()
  adBirthCertificateNumber()
  adBirthCertificateNumberPic()
  adNationalIdNumber()
  adNationalIdNumberPic()
  adPassportNumber()
  adPassportNumberPic()
  adSexStatus()
  adMobileNumber()
  adLandNumber()
  adEMail()
  adWeb()
  adWifeOrHaFullName()
  adWifeOrHusbandNationalId()
  adFamilySize()
  adEducationLevel()
  adJobId()
  adJobStatus()
  adJobPosition()
  adJobProvider()
  adJobType()
  adJoiningDate()
  adFatherFullName()
  adFatherNationalId()
  adMotherFullName()
  adMotherNationalId()
    }

 static mapping = {
      table 'addressinfo'
      version true
 columns {
  id generator:'uvsoftgroup.securemessagingrestfulapis.utility.AddressIdGenerator'
  adId cloumn:'ad_id'
  adalId cloumn:'adal_id'
  adFirstName column:'ad_fir_name'
  adMiddleName column:'ad_mid_name'
  adLastName column:'ad_las_name'
  adBirthDate column:'ad_bir_date'
  adBirthCertificateNumber column:'ad_bc_num'
  adBirthCertificateNumberPic column:'ad_bc_num_pic'
  adNationalIdNumber column:'ad_nid_num'
  adNationalIdNumberPic column:'ad_nid_pic'
  adPassportNumber column:'ad_pass_num'
  adPassportNumberPic column:'ad_pass_num_pic'
  adSexStatus column:'ad_sex_status'
  adMobileNumber column:'ad_mo_num'
  adLandNumber column:'ad_la_num'
  adEMail column:'ad_email'
  adWeb column:'ad_web'
  adWifeOrHaFullName column:'ad_worh_name'
  adWifeOrHusbandNationalId column:'ad_worh_nid'
  adFamilySize column:'ad_fa_size'
  adEducationLevel column:'ad_edu_level'
  adJobId column:'ad_job_id'
  adJobStatus column:'ad_job_status'
  adJobPosition column:'ad_job_pos'
  adJobProvider column:'ad_job_pro'
  adJobType column:'ad_job_type'
  adJoiningDate column:'ad_joi_date'
  adFatherFullName column:'ad_faf_name'
  adFatherNationalId column:'ad_fa_nid'
  adMotherFullName column:'ad_mof_name'
  adMotherNationalId column:'ad_wo_nid'
      }
  }
}

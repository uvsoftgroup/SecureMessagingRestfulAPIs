package uvsoftgroup.securemessagingrestfulapis

import grails.rest.Resource
import grails.databinding.BindingFormat

@Resource(uri = '/addresslocationinfos')
class AddressLocationInfo implements Serializable {
 Long alId,adId,alReferenceId,alThanaCode,alDistictCode
 String alDivisionName,alDistictName,alUpzillaOrThanaName,alUnionName,alWardNumber
 String alBlockNumber,alSectionNumber,alRoadName,alRoadType,alRoadNumber
 String alBuildingNumber,alBuildingFloorNumber,alBuildingFloorUnitNumber,alType
 byte [] alLocationPic

 static belongsTo =[address:AddressInfo]
 static hasOne =[address:AddressInfo]

 String toString() { "${id}"}
 static constraints = {
    alId()
	adId()
 alReferenceId()
 alType()
 alThanaCode()
 alDistictCode()
 alDivisionName()
 alDistictName()
 alUpzillaOrThanaName()
 alUnionName()
 alWardNumber()
 alBlockNumber()
 alSectionNumber()
 alRoadName()
 alRoadType()
 alRoadNumber()
 alBuildingNumber()
 alBuildingFloorNumber()
 alBuildingFloorUnitNumber()
 alLocationPic()
  
    }
    
 static mapping = {
      table 'address_location_info'
      version true
 columns {
  id generator:'uvsoftgroup.securemessagingrestfulapis.utility.AddressLocationIdGenerator'
  alId column:'al_id'
  adId columnn:'ad_id'
 alReferenceId column:'al_ref_id' 
 alThanaCode column:'al_th_code', nullable:true
 alDistictCode column:'al_di_code'  , nullable:true
 alDivisionName column:'al_di_name' , nullable:true
 alDistictName  column:'al_dis_name', nullable:true
 alUpzillaOrThanaName column:'al_upth_name', nullable:true
 alUnionName column:'al_uni_name', nullable:true
 alWardNumber column:'al_war_num', nullable:true
 alBlockNumber column:'al_blo_num', nullable:true
 alSectionNumber column:'al_sec_num', nullable:true
 alRoadName column:'al_roa_name', nullable:true
 alRoadType column:'al_roa_type', nullable:true
 alRoadNumber column:'al_roa_num', nullable:true
 alBuildingNumber column:'al_bui_num', nullable:true
 alBuildingFloorNumber column:'al_bf_num', nullable:true
 alBuildingFloorUnitNumber column:'al_bfu_num', nullable:true
 alLocationPic column:'al_loc_pic', nullable:true
 address column:'al_ad_id', insertable:true , updateable:true, nullable:true
        
      }
  }
}

package com.spsolutions.grand.mappers.event;

import com.spsolutions.grand.dao.*;
import com.spsolutions.grand.domain.enquiry.Enquiry;
import com.spsolutions.grand.domain.location.EdgeLocation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventMapper {
    void saveEnquiry(Enquiry enquiry);

    List<Enquiry> getNotAllocatedEnquiry();

    List<VenueSpacesDao> findAvailableSpaces(SearchEnquiryDao enquiryDao);

    void allocateEnquiry(EnquiryAllocationDao allocationDao);

    void saveEnquiryAllocation(EnquiryAllocationDao allocationDao);

    List<Enquiry> getAllocatedEnquiry();

    List<Enquiry> getAllocatedEnquiryByUsers(String username);

    List<Enquiry> getEnquiry(@Param("status") String status);

    Enquiry getEnquiryById(Long id);

    void saveWalkThroughSetup(WalkThroughTime throughTime);

    void updateEnquiryStatus(@Param("id") Long id, @Param("status") int i);

    List<Enquiry> findLatestWalkthrough(int count);

    List<EdgeLocation> findWalkThroughMapLocation(int count);

    void saveDriverAllocation(EnquiryAllocationDao allocationDao);

    void updateDriverAllocation(EnquiryAllocationDao allocationDao);

    void deactivateDriverAllocation(Long enquiry);

    List<EnquiryDriverAllocationDao> getEnquiryByIdForDriverAllocation();

    void unAllocateTransport(Enquiry enquiry);

    void saveClientStory(EnquiryClientStory clientStory);

    WalkThroughTime findReserveTimeWalkThrough(Long id);

    void deactivateWalkThroughSetup(Long fkEnquiry);

    void saveTransportVoucher(TransportVoucherDao transportVoucherDao);

    String findClientStory(Long id);

    List<Enquiry> getEnquiryAllocated();

    void updateWalkThroughSetupForDriver(@Param("fkEnquiry") Long fkEnquiry,
                                @Param("fkDriverAllocation") Long fkDriverAllocation);

    void changeEnquiryToProcessed(Long fkWalkThrough);

    Enquiry getEnquiryByWalkThroughId(Long id);
    
}

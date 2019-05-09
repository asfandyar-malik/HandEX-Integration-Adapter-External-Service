package com.handex.integration.service;

import com.handex.integration.model.*;

import java.util.List;

public interface ExternalServiceClientService {

    List<ExternalServiceResult> findByCountryAndRecordName(ExternalServiceRequestCriteria externalServiceRequestCriteria);

}

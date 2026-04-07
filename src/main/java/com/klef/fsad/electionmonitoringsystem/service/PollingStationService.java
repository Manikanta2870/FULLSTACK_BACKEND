package com.klef.fsad.electionmonitoringsystem.service;

import java.util.List;

import com.klef.fsad.electionmonitoringsystem.entity.PollingStation;

public interface PollingStationService
{
    String addPollingStation(PollingStation station);

    List<PollingStation> getAllPollingStations();

    PollingStation getPollingStationById(Long id);

    String deletePollingStation(Long id);

    List<PollingStation> getPollingStationsByDistrict(String district);
}

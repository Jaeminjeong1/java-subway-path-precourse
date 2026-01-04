package subway.service;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class SubwayService {

    public void init() {
        StationRepository.init();
        LineRepository.init();
    }
}

package subway;

import subway.controller.SubwayController;
import subway.service.SubwayService;


public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        SubwayService subwayService = new SubwayService();
        SubwayController subwayController = new SubwayController(subwayService);
        subwayController.start();
    }
}

package subway;

import subway.controller.SubwayController;
import subway.service.SubwayService;


public class Application {
    public static void main(String[] args) {
        SubwayService subwayService = new SubwayService();
        SubwayController subwayController = new SubwayController(subwayService);
        subwayController.start();
    }
}

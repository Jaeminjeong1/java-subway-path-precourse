package subway.controller;

import subway.service.SubwayService;

public class SubwayController {

    private final SubwayService subwayService;

    public SubwayController(SubwayService subwayService) {
        this.subwayService = subwayService;
    }

    public void start() {
        //프로그램 순서대로 작성
        // 입력 1
        // 입력 1
        // 계산
        // 출력
    }

    // 반환 타입 정하기
    // 메서드명 input~ 으로 짓기
//    private 반환타입 메서드명() {
//        while (true) {
//            try {
//                // 서비스 메서드 호출
//
//                return *;
//
//            } catch (IllegalArgumentException e) {
//                OutputView.printErrorMessage(e);
//            }
//        }
//    }
}

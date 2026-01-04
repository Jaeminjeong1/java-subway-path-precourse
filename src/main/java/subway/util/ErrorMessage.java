package subway.util;

public enum ErrorMessage {

    INPUT_ERROR("유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n"),
    RANGE_ERROR("최소 두글자 이상입니다. 다시 입력해 주세요."),
    NOT_CONTAINS_STATION_ERROR("존재하지 않은 역입니다."),
    DUPLICATE_STATION_ERROR("출발역과 도착역이 동일합니다.");

    private final static String PREFIX = "\n[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
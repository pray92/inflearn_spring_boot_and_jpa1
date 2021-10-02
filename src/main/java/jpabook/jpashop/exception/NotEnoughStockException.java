package jpabook.jpashop.exception;

public class NotEnoughStockException extends RuntimeException{
    // Ctrl + O : override 함수 자동 생성
    public NotEnoughStockException() {
        super();
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }

}

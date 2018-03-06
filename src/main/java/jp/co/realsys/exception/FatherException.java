package jp.co.realsys.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 public class FatherException extends RuntimeException {

        private Integer code;

        protected FatherException(String message){
            super(message);
        }

        protected FatherException(Integer code,String message){
        super(message);
        this.code = code;
         }


}

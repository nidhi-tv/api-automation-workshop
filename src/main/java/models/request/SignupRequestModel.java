package models.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SignupRequestModel {
    private String email;
    private String password;
}

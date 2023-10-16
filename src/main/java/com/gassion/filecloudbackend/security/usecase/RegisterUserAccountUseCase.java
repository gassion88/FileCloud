package com.gassion.filecloudbackend.security.usecase;

import com.gassion.filecloudbackend.security.web.model.RegisterRequest;

public interface RegisterUserAccountUseCase {

    void register(RegisterRequest registerRequest);

}

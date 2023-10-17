package com.gassion.filecloudbackend.security.api.service;

import com.gassion.filecloudbackend.security.api.model.CurrentUserApiModel;

import java.util.Optional;

public interface IdentityApiService {

    Optional<CurrentUserApiModel> getCurrentUserAccount();

}

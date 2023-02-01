package com.calpyte.livabl.service.impl;


import com.calpyte.livabl.configuration.KeycloakToken;
import com.calpyte.livabl.dto.RegistrationResponse;
import com.calpyte.livabl.dto.UserBasicDTO;
import com.calpyte.livabl.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private KeycloakToken keycloakToken;

    @Override
    public Map<String, String> getToken(String token) throws IOException {
        String authToken = keycloakToken.getRefreshToken(token).getAuth();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", authToken);
        return tokenMap;
    }

    @Override
    public RegistrationResponse getAccessToken(UserBasicDTO user) throws IOException {
        RegistrationResponse authToken = keycloakToken.getUserToken(user);
        return authToken;
    }
}

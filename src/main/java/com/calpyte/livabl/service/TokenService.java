package com.calpyte.livabl.service;




import com.calpyte.livabl.dto.RegistrationResponse;
import com.calpyte.livabl.dto.UserBasicDTO;

import java.io.IOException;
import java.util.Map;

public interface TokenService {

    Map<String, String> getToken(String token) throws IOException;

    RegistrationResponse getAccessToken(UserBasicDTO user) throws IOException;
}

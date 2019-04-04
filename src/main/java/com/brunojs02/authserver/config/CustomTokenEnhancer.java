package com.brunojs02.authserver.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		UserCustomDetails user = (UserCustomDetails) authentication.getPrincipal();
		Map<String, Object> info = new HashMap<>();
		if (user.getId() != null) {
			info.put("user_id", user.getId());
		}
		DefaultOAuth2AccessToken oAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);
		oAuth2AccessToken.setAdditionalInformation(info);
		return super.enhance(oAuth2AccessToken, authentication);
	}

}

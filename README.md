# spring-boot-auth-server
##### Generate JKS Java KeyStore File
- keytool -genkeypair -alias oauth -keyalg RSA -keypass 123456 -keystore oauth.jks -storepass 123456
- keytool -importkeystore -srckeystore oauth.jks -destkeystore oauth.jks -deststoretype pkcs12
- rm oauth.jks.old
- mv oauth.jks ${workspace}/spring-boot-auth-server/src/main/resources/
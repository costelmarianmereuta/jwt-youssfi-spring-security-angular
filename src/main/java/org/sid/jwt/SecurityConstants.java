package org.sid.jwt;

/**
 * pour les constantes on pourra très bien les stoker dans le fichier application.properties
 */

public class SecurityConstants {

    public static final String SECRET="marian";
    public static final long EXPIRATION_TIME=864_000_000;
    public static final String TOKEN_PREFIX="Bearer";
    public static final String HEADER_STRING="Authorization";

}

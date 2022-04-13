package by.kustarev.crm.service;

public class TokenService {

    private static final Long secretKey = 9862769234L;

    /**
     * This method create access token to system
     * algorithm is [(secretKey * 31) + "ks" + (secretKey * 823) + (userID * userID)]
     *
     * @param userID is second number for generating token
     * @return access token to system
     */
    public static String createToken(Long userID) {
        return (secretKey * 31) + "ks" + (secretKey * 823) + (userID * userID);
    }

}

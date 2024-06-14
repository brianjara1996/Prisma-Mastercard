package com.prismamp.api.coupons.mastercard.services;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.prismamp.api.coupons.mastercard.repository.IEncrytorService;
import com.prismamp.encrypt.cipher.PrismaCipher;
import com.prismamp.encrypt.model.CipherEncrypt;

@Service
public class IEncrytorServiceImpl implements IEncrytorService {


    private String password;
    private String iv;

    // Constructor que permite inyección de valores de application.yml
    public IEncrytorServiceImpl(@Value("${ENCRIPTAR.ENC_KEY}") String password,
                                 @Value("${ENCRIPTAR.IV}") String iv) {
        this.password = password;
        this.iv = iv;
    }
    
    @Override
    public String encrypted(String data) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        try{
            CipherEncrypt cipherEncrypt= PrismaCipher.encrypt(data, password.getBytes(), iv.getBytes());
            return Base64.getEncoder().encodeToString(cipherEncrypt.getTextCipher());
        } catch (Exception ex){
            throw ex;
        }
    }
    
    @Override
    public String decryptString(String data) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        try{
            byte[] decodedData = Base64.getDecoder().decode(data);
            byte[] decryptedData = PrismaCipher.decrypt(decodedData, password.getBytes(), iv.getBytes());
            return new String(decryptedData);
        } catch (Exception ex){
            throw ex;
        }
    }

}

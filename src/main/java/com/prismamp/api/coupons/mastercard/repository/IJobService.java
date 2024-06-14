package com.prismamp.api.coupons.mastercard.repository;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public interface IJobService {
       String encrypt(String numtar) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException;
       
       String decryptString(String data) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException,NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException;
}

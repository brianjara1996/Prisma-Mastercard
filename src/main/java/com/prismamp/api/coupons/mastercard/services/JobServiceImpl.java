package com.prismamp.api.coupons.mastercard.services;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prismamp.api.coupons.mastercard.repository.IEncrytorService;
import com.prismamp.api.coupons.mastercard.repository.IJobService;

@Service
public class JobServiceImpl implements IJobService {
	
    @Autowired
    private IEncrytorService encrytorService;
	
    @Override
    public String encrypt(String numtar) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        return encrytorService.encrypted(numtar);
    }

	@Override
	public String decryptString(String data)
			throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException,
			NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
		// TODO Auto-generated method stub
		return encrytorService.decryptString(data);
	}

}

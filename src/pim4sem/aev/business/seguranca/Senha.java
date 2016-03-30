package pim4sem.aev.business.seguranca;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Senha {
	
	private String senhaCriptografada;
	
	public Senha(){
		
	}
	
	public String criptografaSenha(String recebeSenha) throws NoSuchAlgorithmException
	{
		StringBuffer hexa = new StringBuffer();
		
		byte[] pass = new byte[1024];
		
		final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
		sha512.update(recebeSenha.getBytes());
		
		pass = sha512.digest();
		
		for(int i = 0; i < pass.length; i++){
			hexa.append(Integer.toString((pass[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		senhaCriptografada = hexa.toString();
		
		return senhaCriptografada;
	}
	
}

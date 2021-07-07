package com.indigo.fashion.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<String> getProducts() {
		// TODO Auto-generated method stub
		String[] chars = new String[] {"A","B","C","F","G","D"};
		List<String> lst = Arrays.asList(chars);
		lst.sort((a,b)->a.compareTo(b));
		
		
		return   lst;
	}

}

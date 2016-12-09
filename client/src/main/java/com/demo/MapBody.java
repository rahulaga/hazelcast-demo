package com.demo;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapBody implements Serializable{

	private static final long serialVersionUID = 5904499911047542635L;
	
	@XmlElement
	public Map<String,String> body;

	// required by framework
	protected MapBody() {
	}

}

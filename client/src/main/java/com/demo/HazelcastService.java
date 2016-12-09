package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Service
public class HazelcastService {

	private HazelcastInstance client;
	private IMap<String, MapBody> map1;
	
	@PostConstruct
	public void init(){
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.getNetworkConfig().addAddress("127.0.0.1");
		client = HazelcastClient.newHazelcastClient(clientConfig);
		System.out.println("Cl server instance=" + client.getName());

		map1 = client.getMap("testmap1");
		
	}
	
	@PreDestroy
	public void cleanup(){
		client.shutdown();
	}

	public void put(String key, MapBody body) {
		map1.put(key, body);
	}

	public MapBody get(String key) {
		return map1.get(key);
	}
	
	
}

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class Client {
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.getNetworkConfig().addAddress("127.0.0.1");

		HazelcastInstance client = HazelcastClient
				.newHazelcastClient(clientConfig);
		System.out.println("Cl instance=" + client.getName());

		IMap<String, String> map = client.getMap("testmap");

		map.put("foo", "bar");

		System.out.println("get value=" + map.get("foo"));

		HazelcastClient.shutdownAll();
	}
}

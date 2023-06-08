package com.ck.scmproject.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private KafkaTemplate<String, String> kafkaTemplate;

    // initialize socket and input - null
    private Socket socket = null;
    private BufferedReader input = null;
    @SuppressWarnings("unused")
	private BufferedWriter output = null;

    public void produceData(String address, int port) throws Exception {
        // establish a connection with try and catch if any exception occurs
        try {

            socket = new Socket(address, port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("Socket Connected!");

            String streamData = "";
            while (!streamData.equals("Over")) {

                streamData = input.readLine();
                JSONArray array = new JSONArray(streamData);
                for (int data = 0; data < array.length(); data++) {

                    JSONObject object = array.getJSONObject(data);

                    // create Kafka template (key, value - message)
                    if (kafkaTemplate == null) {
                        this.kafkaTemplate = kafkaTemplate();
                    }

                    // send data to topic (with environment variables)
                    String topics = System.getenv("topic");

                    kafkaTemplate.send(topics, object.toString());

                }
            }
        } catch (UnknownHostException exception) {
            throw new IllegalArgumentException("Unknown host: " + address);
        } catch (IOException exception) {
            throw new IllegalArgumentException("Error while reading data from the socket: " + exception.getMessage());
        }
    }

    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerConfig());
    }

    public ProducerFactory<String, String> producerConfig() {
        Map<String, Object> config = new HashMap<>();
      

        // To connect with localhost
        // config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    
        // configure Bootstrap servers, key and value serializer config
        // Environment variables
        String bootstrapServer = System.getenv("bootstrapServer");

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }
}

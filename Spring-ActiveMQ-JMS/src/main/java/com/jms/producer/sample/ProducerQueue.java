//package com.jms.producer.sample;
//
//import javax.annotation.Resource;
//import javax.jms.Connection;
//import javax.jms.ConnectionFactory;
//import javax.jms.Destination;
//import javax.jms.JMSException;
//import javax.jms.MessageProducer;
//import javax.jms.Queue;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jms.JmsException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ProducerQueue {
//
//	private static final Logger log = LoggerFactory.getLogger(ProducerQueue.class);
//
//	@Resource(lookup = "jms/queue")
//	private static Queue queue;
//
//	@Resource(lookup = "jms/ConnectionFactory")
//	private static ConnectionFactory connectionFactory;
//
//	@PostMapping("/produce")
//	public void produceMessage(@RequestParam int number) {
//
//		Destination dest = null;
//		Connection connection = null;
//		try {
//			// create the domain into destination
//			dest = (Destination) queue;
//
//			// create Connection from connectionFactory
//			connection = connectionFactory.createConnection();
//
//			// create session from the connection
//			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//			// Create the MESSAGEPRODUCER
//
//			MessageProducer producer = session.createProducer(dest);
//			TextMessage message = session.createTextMessage();
//
//			// sending message to queue
//
//			for (int i = 0; i < number; i++) {
//				message.setText("This message from producer =" + i);
//				producer.send(message);
//			}
//			producer.send(session.createMessage());
//
//		} catch (Exception e) {
//			log.error("Exception Occured ::", e);
//		} finally {
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (JmsException | JMSException jms) {
//					log.error("Exception Occured ::", jms);
//
//				}
//			}
//		}
//
//	}
//
//}

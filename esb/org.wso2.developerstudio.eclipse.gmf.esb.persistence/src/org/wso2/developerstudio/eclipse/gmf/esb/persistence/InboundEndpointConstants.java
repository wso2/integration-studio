package org.wso2.developerstudio.eclipse.gmf.esb.persistence;

public class InboundEndpointConstants {

	public static final String SEQUENCE = "sequence";
	public static final String ON_ERROR = "onError";

	public static final String INBOUND_HTTP_PORT = "inbound.http.port";
	public static final String API_DISPATCHING_ENABLED = "api.dispatching.enabled";
	
	public static final String INBOUND_WORKER_POOL_SIZE_CORE = "inbound.worker.pool.size.core";
	public static final String INBOUND_WORKER_POOL_SIZE_MAX = "inbound.worker.pool.size.max";
	public static final String INBOUND_WORKER_THREAD_KEEP_ALIVE_SEC = "inbound.worker.thread.keep.alive.sec";
	public static final String INBOUND_WORKER_POOL_QUEUE_LENGTH = "inbound.worker.pool.queue.length";
	public static final String INBOUND_THREAD_GROUOP_ID = "inbound.thread.group.id";
	public static final String INBOUND_THREAD_ID = "inbound.thread.id";
	public static final String DISPATCH_FILTER_PATTERN = "dispatch.filter.pattern";

	public static final String INTERVAL = "interval";
	public static final String SEQUENTIAL = "sequential";
	public static final String COORDINATION = "coordination";

	public static final String VFS_FILE_URI = "transport.vfs.FileURI";
	public static final String VFS_CONTENT_TYPE = "transport.vfs.ContentType";
	public static final String VFS_FILE_NAME_PATTERN = "transport.vfs.FileNamePattern";
	public static final String VFS_FILE_PROCESS_INTERVAL = "transport.vfs.FileProcessInterval";
	public static final String VFS_FILE_PROCESS_COUNT = "transport.vfs.FileProcessCount";
	public static final String VFS_LOCKING = "transport.vfs.Locking";
	public static final String VFS_MAX_RETRY_COUNT = "transport.vfs.MaxRetryCount";
	public static final String VFS_RECONNECT_TIMEOUT = "transport.vfs.ReconnectTimeout";
	public static final String VFS_ACTION_AFTER_PROCESS = "transport.vfs.ActionAfterProcess";
	public static final String VFS_MOVE_AFTER_PROCESS = "transport.vfs.MoveAfterProcess";
	public static final String VFS_ACTION_AFTER_ERRORS = "transport.vfs.ActionAfterErrors";
	public static final String VFS_MOVE_AFTER_ERRORS = "transport.vfs.MoveAfterErrors";
	public static final String VFS_ACTION_AFTER_FAILURE = "transport.vfs.ActionAfterFailure";
	public static final String VFS_MOVE_AFTER_FAILURE = "transport.vfs.MoveAfterFailure";
	public static final String VFS_MOVE_TIMESTAMP_FORMAT = "transport.vfs.MoveTimestampFormat";
	public static final String VFS_AUTO_LOCK_RELEASE = "transport.vfs.AutoLockRelease";
	public static final String VFS_AUTO_LOCK_RELEASE_INTERVAL = "transport.vfs.AutoLockReleaseInterval";
	public static final String VFS_LOCK_RELEASE_SAME_NODE = "transport.vfs.LockReleaseSameNode";
	public static final String VFS_DISTRIBUTED_LOCK = "transport.vfs.DistributedLock";
	public static final String VFS_DISTRIBUTED_TIMEOUT = "transport.vfs.DistributedTimeout";
	public static final String VFS_FILESORT_ATTRIBUTE = "transport.vfs.FileSortAttribute";
	public static final String VFS_FILESORT_ASCENDING = "transport.vfs.FileSortAscending";
	public static final String VFS_SUBFOLDER_TIMESTAMP_FORMAT = "transport.vfs.SubFolderTimestampFormat";
	public static final String VFS_CREATE_FOLDER = "transport.vfs.CreateFolder";	
	public static final String VFS_STREAMING = "transport.vfs.Streaming";
	public static final String VFS_BUILD = "transport.vfs.Build";
	

	public static final String JMS_JAVA_NAMING_FACTORY_INITIAL = "java.naming.factory.initial";
	public static final String JMS_JAVA_NAMING_PROVIDER_URL = "java.naming.provider.url";
	public static final String JMS_CONNECTION_FACTORY_JNDI_NAME = "transport.jms.ConnectionFactoryJNDIName";
	public static final String JMS_CONNECTION_FACTORY_TYPE = "transport.jms.ConnectionFactoryType";
	public static final String JMS_DESTINATION = "transport.jms.Destination";
	public static final String JMS_SESSION_TRANSACTED = "transport.jms.SessionTransacted";
	public static final String JMS_SESSION_ACKNOWLEDGEMENT = "transport.jms.SessionAcknowledgement";
	public static final String JMS_CACHE_LEVEL = "transport.jms.CacheLevel";
	public static final String JMS_USERNAME = "transport.jms.UserName";
	public static final String JMS_PASSWORD = "transport.jms.Password";
	public static final String JMS_JMS_SPEC_VERSION = "transport.jms.JMSSpecVersion";
	public static final String JMS_SUBSCRIPTION_DURABLE = "transport.jms.SubscriptionDurable";
	public static final String JMS_DURABLE_SUBSCRIBER_CLIENT_ID = "transport.jms.DurableSubscriberClientID";
	public static final String JMS_MESSAGE_SELECTOR = "transport.jms.MessageSelector";
	public static final String JMS_RECIEVE_TIMEOUT = "transport.jms.ReceiveTimeout";
	public static final String JMS_CONTENT_TYPE = "transport.jms.ContentType";
	
	public static final String JMS_REPLY_DESTINATION = "transport.jms.ReplyDestination";
	public static final String JMS_PUB_SUB_NO_LOCAL = "transport.jms.PubSubNoLocal";

	public static final String KEYSTORE = "keystore";
	public static final String TRUSTSTORE = "truststore";
	public static final String SSL_VERIFY_CLIENT = "SSLVerifyClient";
	public static final String SSL_PROTOCOL = "SSLProtocol";
	public static final String HTTPS_PROTOCOLS = "HttpsProtocols";
	public static final String CERTIFICATE_REVOCATION_VERIFIER = "CertificateRevocationVerifier";

	public static final String INBOUND_HL7_PORT = "inbound.hl7.Port";
	public static final String INBOUND_HL7_AUTOACK = "inbound.hl7.AutoAck";
	public static final String INBOUND_HL7_TIMEOUT = "inbound.hl7.TimeOut";
	public static final String INBOUND_HL7_MESSAGE_PRE_PROCESSOR = "inbound.hl7.MessagePreProcessor";
	public static final String INBOUND_HL7_CHARSET = "inbound.hl7.CharSet";
	public static final String INBOUND_HL7_VALIDATE_MESSAGE = "inbound.hl7.ValidateMessage";
	public static final String INBOUND_HL7_BUILD_INVALID_MESSAGES = "inbound.hl7.BuildInvalidMessages";
	public static final String INBOUND_HL7_PASSTHROUHG_INVALID_MESSAGES = "inbound.hl7.PassThroughInvalidMessages";

	public static final String ZOOKEEPER_CONNECT = "zookeeper.connect";
	public static final String GROUP_ID = "group.id";
	public static final String CONSUMER_TYPE = "consumer.type";
	public static final String CONTENT_TYPE = "content.type";
	public static final String TOPICS = "topics";
	public static final String SIMPLE_TOPIC = "simple.topic";
	public static final String SIMPLE_BROKERS = "simple.brokers";
	public static final String SIMPLE_PORT = "simple.port";
	public static final String SIMPLE_PARTITION = "simple.partition";
	public static final String SIMPLE_MAX_MESSAGE_TOREAD = "simple.max.messages.to.read";
	public static final String THREAD_COUNT = "thread.count";
	public static final String ZOOKEEPER_SEESION_TIMEOUT_MS = "zookeeper.session.timeout.ms";
	public static final String ZOOKEEPER_SYNC_TIME_MS = "zookeeper.sync.time.ms";
	public static final String AUTO_COMMIY_INTERVAL_MS = "auto.commit.interval.ms";
	public static final String AUTO_OFFSET_REST = "auto.offset.reset";

	public static final String INBOUND_CXF_RM_HOST = "inbound.cxf.rm.host";
	public static final String INBOUND_CXF_RM_PORT = "inbound.cxf.rm.port";
	public static final String INBOUND_CXF_RM_CONFIG_FILE = "inbound.cxf.rm.config-file";
	public static final String ENABLE_SSL = "enableSSL";	
	
	public static final String INBOUND_MQTT_CONNECTION_FACTORY = "mqtt.connection.factory";
	public static final String INBOUND_MQTT_SERVER_HOST_NAME = "mqtt.server.host.name";
	public static final String INBOUND_MQTT_SERVER_PORT = "mqtt.server.port";	
	public static final String INBOUND_MQTT_TOPIC_NAME = "mqtt.topic.name";
	public static final String INBOUND_MQTT_CONTENT_TYPE = "content.type";
	public static final String INBOUND_MQTT_SUBSCRIPTION_QOS = "mqtt.subscription.qos";
	public static final String INBOUND_MQTT_SESSION_CLEAN = "mqtt.session.clean";
	public static final String INBOUND_MQTT_SSL_ENABLE = "mqtt.ssl.enable";
	public static final String INBOUND_MQTT_TEMPORARY_STORE_DIRECTORY = "mqtt.temporary.store.directory";
	public static final String INBOUND_MQTT_SUBSCRIPTION_USERNAME = "mqtt.subscription.username";
	public static final String INBOUND_MQTT_SUBSCRIPTION_PASSWORD = "mqtt.subscription.password";
	public static final String INBOUND_MQTT_CLIENT_ID = "mqtt.client.id";
	public static final String INBOUND_MQTT_RECONNECTION_INTERVAL = "mqtt.reconnection.interval";
}

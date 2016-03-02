package org.wso2.developerstudio.eclipse.gmf.esb.persistence;

public class InboundEndpointConstants {

	public static final String HTTP = "http";
	public static final String FILE = "file";
	public static final String JMS = "jms";
	public static final String HTTPS = "https";
	public static final String HL7 = "hl7";
	public static final String KAFKA = "kafka";
	public static final String CUSTOM = "custom";
	public static final String CXF_WS_RM = "cxf_ws_rm";
	public static final String MQTT = "mqtt";
	public static final String RABBITMQ = "rabbitmq";
	public static final String FEED = "feed";

	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String NONE = "none";
	public static final String DELETE = "DELETE";
	public static final String ENABLE = "enable";
	public static final String NAME = "name";
	public static final String SIZE = "size";
	public static final String TOPIC = "topic";
	public static final String AUTO_ACKNOWLEDGE = "AUTO_ACKNOWLEDGE";
	public static final String CLIENT_ACKNOWLEDGE = "CLIENT_ACKNOWLEDGE";
	public static final String DUPS_OK_ACKNOWLEDGE = "DUPS_OK_ACKNOWLEDGE";
	public static final String HIGHLEVEL = "highlevel";
	public static final String APPLICATION_XML = "application/xml";
	
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
	public static final String INBOUND_BEHAVIOUR = "inbound.behavior";

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
	public static final String JMS_DURABLE_SUBSCRIBER_NAME = "transport.jms.DurableSubscriberName";
	public static final String JMS_CONTENT_TYPE_PROPERTY = "transport.jms.ContentTypeProperty";


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
	public static final String TOPIC_FILTER = "topic.filter";
	public static final String FILTER_FROM_WHITELIST = "filter.from.whitelist";
	public static final String FILTER_FROM_BLACKLIST = "filter.from.blacklist";
	public static final String SIMPLE_TOPIC = "simple.topic";
	public static final String SIMPLE_BROKERS = "simple.brokers";
	public static final String SIMPLE_PORT = "simple.port";
	public static final String SIMPLE_PARTITION = "simple.partition";
	public static final String SIMPLE_MAX_MESSAGES_TO_READ = "simple.max.messages.to.read";
	public static final String THREAD_COUNT = "thread.count";
	public static final String CONSUMER_ID = "consumer.id";
	public static final String SOCKET_TIMEOUT_MS = "socket.timeout.ms";
	public static final String SOCKET_RECEIVE_BUFFER_BYTES = "socket.receive.buffer.bytes";
	public static final String FETCH_MESSAGE_MAX_BYTES = "fetch.message.max.bytes";
	public static final String NUM_CONSUMER_FETCHES = "num.consumer.fetchers";
	public static final String AUTO_COMMIT_ENABLE = "auto.commit.enable";
	public static final String AUTO_COMMIT_INTERVAL_MS = "auto.commit.interval.ms";
	public static final String QUEUED_MAX_MESSAGE_CHUNKS = "queued.max.message.chunks";
	public static final String REBALANCE_MAX_RETRIES = "rebalance.max.retries";
	public static final String FETCH_MIN_BYTES = "fetch.min.bytes";
	public static final String FETCH_WAIT_MAX_MS = "fetch.wait.max.ms";
	public static final String REBALANCE_BACKOFF_MS = "rebalance.backoff.ms";
	public static final String REFRESH_LEADER_BACKOFF_MS = "refresh.leader.backoff.ms";
	public static final String AUTO_OFFSET_RESET = "auto.offset.reset";
	public static final String CONSUMER_TIMEOUT_MS = "consumer.timeout.ms";
	public static final String EXCLUDE_INTERNAL_TOPICS = "exclude.internal.topics";
	public static final String PARTITION_ASSIGNMENT_STRATEGY = "partition.assignment.strategy";
	public static final String CLIENT_ID = "client.id";
	public static final String ZOOKEEPER_SESSION_TIMEOUT_MS = "zookeeper.session.timeout.ms";
	public static final String ZOOKEEPER_CONNECTION_TIMEOUT_MS = "zookeeper.connection.timeout.ms";
	public static final String ZOOKEEPER_SYNC_TIME_MS = "zookeeper.sync.time.ms";
	public static final String OFFSETS_STORAGE = "offsets.storage";
	public static final String OFFSETS_CHANNEL_BACKOFF_MS = "offsets.channel.backoff.ms";
	public static final String OFFSETS_CHANNEL_SOCKET_TIMEOUT_MS = "offsets.channel.socket.timeout.ms";
	public static final String OFFSETS_COMMIT_MAX_RETRIES = "offsets.commit.max.retries";
	public static final String DUAL_COMMIT_ENABLED = "dual.commit.enabled";

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

	public static final String RABBITMQ_CONNECTION_FACTORY = "rabbitmq.connection.factory";
	public static final String RABBITMQ_SERVER_HOST_NAME = "rabbitmq.server.host.name";
	public static final String RABBITMQ_SERVER_PORT = "rabbitmq.server.port";
	public static final String RABBITMQ_SERVER_USER_NAME = "rabbitmq.server.user.name";
	public static final String RABBITMQ_SERVER_PASSWORD = "rabbitmq.server.password";
	public static final String RABBITMQ_QUEUE_NAME = "rabbitmq.queue.name";
	public static final String RABBITMQ_EXCHANGE_NAME = "rabbitmq.exchange.name";
	public static final String RABBITMQ_QUEUE_DURABLE = "rabbitmq.queue.durable";
	public static final String RABBITMQ_QUEUE_EXCLUSIVE = "rabbitmq.queue.exclusive";
	public static final String RABBITMQ_QUEUE_AUTO_DELETE = "rabbitmq.queue.auto.delete";
	public static final String RABBITMQ_QUEUE_AUTO_ACK = "rabbitmq.queue.auto.ack";
	public static final String RABBITMQ_QUEUE_ROUTING_KEY = "rabbitmq.queue.routing.key";
	public static final String RABBITMQ_QUEUE_DELIVERY_MODE = "rabbitmq.queue.delivery.mode";
	public static final String RABBITMQ_EXCHANGE_TYPE = "rabbitmq.exchange.type";
	public static final String RABBITMQ_EXCHANGE_DURABLE = "rabbitmq.exchange.durable";
	public static final String RABBITMQ_EXCHANGE_AUTO_DELETE = "rabbitmq.exchange.auto.delete";
	public static final String RABBITMQ_SERVER_VIRTUAL_HOST = "rabbitmq.server.virtual.host";
	public static final String RABBITMQ_FACTORY_HEARTBEAT = "rabbitmq.factory.heartbeat";
	public static final String RABBITMQ_CONNECTION_SSL_ENABLED = "rabbitmq.connection.ssl.enabled";
	public static final String RABBITMQ_CONNECTION_SSL_KEYSTORE_LOCATION = "rabbitmq.connection.ssl.keystore.location";
	public static final String RABBITMQ_CONNECTION_SSL_KEYSTORE_TYPE = "rabbitmq.connection.ssl.keystore.type";
	public static final String RABBITMQ_CONNECTION_SSL_KEYSTORE_PASSWORD = "rabbitmq.connection.ssl.keystore.password";
	public static final String RABBITMQ_CONNECTION_SSL_TRUSTSTORE_LOCATION = "rabbitmq.connection.ssl.truststore.location";
	public static final String RABBITMQ_CONNECTION_SSL_TRUSTSTORE_TYPE = "rabbitmq.connection.ssl.truststore.type";
	public static final String RABBITMQ_CONNECTION_SSL_TRUSTSTORE_PASSWORD = "rabbitmq.connection.ssl.truststore.password";
	public static final String RABBITMQ_CONNECTION_SSL_VERSION = "rabbitmq.connection.ssl.version";
	
	public static final String INBOUND_FEED_URL = "feed.url";
	public static final String INBOUND_FEED_TYPE = "feed.type";
	public static final String ATOM = "Atom";
}

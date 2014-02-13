How to run shoppingcart in a secured environment
================================================

First build the security module (mvn clean install). You can find the com.acme.shoppingcart.security.pwcb-1.0.0-SNAPSHOT.jar and ReOrderProcess.zip in pwcb and bpel target directoies, respectively.

DS Server 
---------

1. ShoppingCartDS Service must be secured using security scenario-5

ESB Server
----------

1. Copy com.acme.shoppingcart.security.pwcb-1.0.0-SNAPSHOT.jar into ESB_HOME/repository/component/lib and restart the server.
2. Upload signAndEncrypt.xml security policy file to config registry  (_system/config/SignAndEncrypt.xml)
3. Copy the synapse configuration of secured-shopping-cart-synapse-config.xml to ESB or Update your synapse configuration by adding a policy location to your endpoint

ex- <endpoint name="AdminServiceEP">
        <address uri="http://localhost:9763/services/ShoppingCartDS/"/>
    </endpoint>

After configuring policy for endpoint

    <endpoint name="AdminServiceEP">
        <address uri="http://localhost:9763/services/ShoppingCartDS/">
		<enableSec policy="conf:/SignAndEncrypt.xml"/>
	</address>
    </endpoint>


BPS Server
----------

1. Copy com.acme.shoppingcart.security.pwcb-1.0.0-SNAPSHOT.jar into BPS_HOME/repository/component/lib restart the server.
2. Deployed ReOrderProcess BPEL package

WSAS Server
-----------

1. FinanceConnectorService and SupplierService must be secured using security scenario-5

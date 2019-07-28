# VODACOM BRIDGE


This is a corba client that connects to the vodacom ICAP corba server confirming to the idl interface specified in `Vodacom Interface control documentation.

## idl

The *HighSpeedExt.idl* has been changed to support **20 character password**.

```

void PerformLogOn(
  in string<2> originId, // Origin ID
  in string<255> userName,  // User Name
  in string<20> passWord, // Password (changed to support 20 characters)
  out long userId, // User Id
  out string<255> securityKey) // Security Key
  raises(Isis::InterfaceError);

```


## Tools

Java (8.0), Maven

## Build (unit test)

The following allows to just compile.

```

mkdir -p code/simha/java/vodacom

cd code/simha/java/vodacom

git clone https://gitlab.com/simha/corba

cd corba

mvn clean

mvn compile


```

### Jar


```

mvn jar:jar


```

## Release (vodacom_bridge.tar.xz)

Builds a new vodacom_bridge.tar.xz

```

./c

```

Comprises of

- `t` script to test the java jar

```
./vodacom_bridger/
./vodacom_bridger/t
./vodacom_bridger/vodacom.ior
./vodacom_bridger/lib/
./vodacom_bridger/lib/vodacom.ior
./vodacom_bridger/lib/highspeed_isis.jar
./vodacom_bridger/lib/com.simha.vodacom.bridge-1.0.1.jar

```

## Test vodacom_bridge.tar.xz

sftp to the vpn server

```
rm vodacom_bridge

tar -xvf vodacom_bridge.tar.xz

cd vodacom_bridge

./t

```

## Usage

### Setup

#### 1. libraries

- google gson 2.8
- highspeed_isis.jar
- com.simha.vodacom.bridge-1.0.1.jar

If you use maven, then you can include gson

```
<!--  Gson: Java to Json conversion -->
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.0</version>
  <scope>compile</scope>
</dependency>

```
2. Copy the rest of jars into the lib directory

3. Copy the vodacom.ior into a directory where you can load. (You can observe FileNotFound exception to fine tune it).

### Check the `tests` directory for the usage as well.

There are two steps though

1. `Authenticate`

```

import com.simha.vodacom.bridge.*;

Authenticator auth = Factory.newInstance().lazyAuthenticator(new Credentials("PY","xyz", "xyz_password"));

SecurityKey key = auth.logon();

```

**From the Vodacom Interface control documentation**

`PerformLogOn method` is used to log the external user onto the High Speed Server. A userID
and key is returned to the client. The return values are used in further requests to the High Speed
Server.

2. `Perform Function call`

Refer the test code.

```

import com.simha.vodacom.bridge.*;

//String function code
//Map of attributesMap
Result result = Factory.lazy(key).newClient().perform(new Input(function, attrMap));

```

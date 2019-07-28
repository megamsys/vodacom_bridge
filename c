cd src/main/idl

idlj HighSpeedExt.idl
idlj IsisCommon.idl

javac -classpath . ./Isis/*.java
javac -classpath . ./HighSpeed/*.java

jar -cvf highspeed_isis.jar ./HighSpeed ./Isis

mv highspeed_isis.jar ../../../lib

cd ../../../

mvn clean

mvn compile

mvn jar:jar

mv target/com.simha.vodacom.bridge-*.jar ./lib

rm vodacom_bridger.tar.xz

rm -rf vodacom_bridger

mkdir vodacom_bridger

cp t ./vodacom_bridger

cp vodacom.ior ./vodacom_bridger

cp -rf lib ./vodacom_bridger/

tar -cvf vodacom_bridger.tar.xz ./vodacom_bridger

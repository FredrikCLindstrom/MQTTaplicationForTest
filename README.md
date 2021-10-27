# MQTTaplicationForTest
mqtt basic setup for next group

Syfte: att ni får en liten inblick i MQTT. detta program innehåller 2 applications, där den ena pratar med den andra
genom MQTT. Ni kommer förmodligen använda er av det när dt kommmer till att få telefon appen att prata med tablet appen.

ni behöver använda er av 2 terminaler.
så använd först intellij local och skriv in "cd MQTTApplications" sen " "cd first/", sen "cd FirstJavaFXMQTTApplication/",
gör sedan en "mvn clean install" sedan "cd Main/" sedan "mvn gluonfx:run".
nu ska första applicationen vara uppe.

då kan ni trycka på plus tecknet vid terminalen så ni får en till terminal.

skriv in "cd MQTTApplications" sen " "cd second/", sen "cd SecondJavaFXMQTTApplication/"
gör sedan en "mvn clean install" sedan "cd Main/" sedan "mvn gluonfx:run".

nu så ska både subscriber (first) och publisher (second) vara uppe, 
nu kan man skicka medelande via mqtt broker. just nu så är brokern eclipse test sida.
ni kommer förmodligen sätta upp en egen server. test sidan går långsamt och är helt öppen.

vi kommenterar koden så gott vi kan och ni får googla det som är frågetecken.
("basicJavaFX" i kommentarer betyder att det är basic javafx så det får ni googla.)


länkar som kanske hjälper
MQTT playlist med genomgång av tekniken.
https://www.youtube.com/playlist?list=PLRkdoPznE1EMXLW6XoYLGd4uUaB6wB0wd

Paho biblioteket verkar vara rekommenderat för java, läggs till i maven fil.
”The Paho Android Service is an MQTT client library written in Java for developing applications on Android.”
https://partners-intl.aliyun.com/help/doc-detail/146631.htm

Broker Eclipse mosquitto
https://mosquitto.org
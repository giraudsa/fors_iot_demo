
for f in fors.jar 
do
	cp /home/giraudsa/fors/$f $f
done

echo "code generation"
java -jar fors.jar IOT.fors

echo "compilation"
LIBS=libs/objectsManagement.jar
javac -classpath $LIBS JavaServer/*.java

echo "lancement"
java  -classpath $LIBS:. JavaServer.Application


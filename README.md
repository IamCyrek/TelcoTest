# TelcoTest

    1. Check
        
        $ java -version
        
        $ mvn -version
        
    2. Build
        
        $ mvn clean package
        
    3. Run example (as parameter you should specify path to settings file)
        java -cp target/TelcoTest-1.0-SNAPSHOT.jar com.telco.app.App src/main/resources/config.properties
        
    4. My output after coping 3 files
        FileRecordObject{id=1, dateAndTime=2019-03-01 at 00:29:17.908 MSK, filePathAndName='/home/user/Downloads/test/task3.txt'}
        FileRecordObject{id=2, dateAndTime=2019-03-01 at 00:29:17.910 MSK, filePathAndName='/home/user/Downloads/test/task1.txt'}
        FileRecordObject{id=3, dateAndTime=2019-03-01 at 00:29:17.913 MSK, filePathAndName='/home/user/Downloads/test/task2.txt'}

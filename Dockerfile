# Dockerfile

FROM openjdk:8-jre-slim
#RUN apt-get update ; apt-get dist-upgrade -y
#RUN apt-get install -y openjdk-8-jre-headless

ADD /build/libs/Test-Pipeline-all-1.0.jar Parcel-Config-Size-Service.jar
#ADD /database/parcelsize.db /database/parcelsize.db
CMD java -jar Parcel-Config-Size-Service.jar





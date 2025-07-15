FROM ubuntu:20.04

RUN apt-get update && apt-get install -y openjdk-17-jdk wget unzip

RUN apt-get update && apt-get install -y openjfx wget unzip
COPY . Booking/

WORKDIR /Booking

RUN chmod +x /Booking/deploy-rest.sh

CMD ["/Booking/deploy-rest.sh"]

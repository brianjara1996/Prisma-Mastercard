FROM eclipse-temurin:17-jdk-alpine
LABEL name=ms-mastercard-coupons

RUN apk add --no-cache bash
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
RUN mkdir -p /opt/ms-mastercard-coupons && chown javauser:javauser /opt/ms-mastercard-coupons

WORKDIR /opt/ms-mastercard-coupons
USER javauser

COPY /target/*.jar /opt/ms-mastercard-coupons/app.jar

CMD ["java", "-jar", "app.jar"]
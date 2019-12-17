Borsa Uygulaması

-Java Spring-boot'ta yazılmış basit bir borsa uygulamasıdır.
-Rest api için  Swagger kullanılabilir.
-Database olarak H2 inmemory database kullanıldı.


-Hisseler listeleme, güncelleme ve silme yapılabilecek.
-Sistem yöneticisi sistem kullanıcısı ekleyecek (İsim, soy isim ve mail)
-Uygulama kullanıcıları login olduktan sonra tanımlı hisselerden miktarını belirleyerek alabilecekler, Alım satım yapabilecekler.

-"mvn clean package" komutu ile docker imajı oluşturulabilir.

 `docker-compose.yml` dosyası aşağıdaki gibidir:

    version: '3.0'

    services:
      web:
        image: stock-market:0.0.1
        ports:
         - "8080:8080"

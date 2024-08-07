
  Feature: US1014 Guru99 sayfasindaki tablodan istenen sutunu yazdirma
    Scenario: TC20 kullanini tablodan istedigi sutunu yazdirabilmeli
      Given kullanici "guruUrl" anasayfaya gider
      And "Prev Close (Rs)" , sutunundaki degerleri yazdirir
      And tum sayfa screenshot alip "guruWebTableTest" ismi ile kaydeder
      And sayfayi kapatir
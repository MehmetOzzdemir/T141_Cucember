Feature: US1006 kullanic fake bilgilerle facebook'ta kayit olusturur

@smoke
  Scenario: TC12 kullanici fake bilgilerle facebook'ta kayit olusturabilmeli
    Given kullanici "faceURl" anasayfaya gider
    And facebook'da yeni hesap olustur butonna basar
    And 1 saniye bekler
    When Faker class'indan bilgilerle facebook kayit formunu doldurur
    Then 2 saniye bekler
    And facebook kayit ol butonuna basar
    Then 8 saniye bekler
    And sayfayi kapatir
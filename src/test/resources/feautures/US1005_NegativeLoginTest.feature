Feature: US1005 kullanici geversiz bilgilerle giris yapamaz

  Scenario: TC09 Kullanici gecersiz password ile giris yapamamali
    Given kullanici "toURL" anasayfaya gider
    Then account butonuna basar
    And email olarak "toValidEmail" girer
    And password olarak "toInvalidPassword" girer
    Then signIn butonuna basar
    Then giris yapilamadigini test eder
    And 3 saniye bekler
    And sayfayi kapatir

  Scenario: TC10 Kullanici gecersiz email ile giris yapamamali
    Given kullanici "toURL" anasayfaya gider
    Then account butonuna basar
    And email olarak "toInvalidEmail" girer
    And password olarak "toValidPassword" girer
    Then signIn butonuna basar
    Then giris yapilamadigini test eder
    And 3 saniye bekler
    And sayfayi kapatir

  @E2E
  Scenario: TC10 Kullanici gecersiz email ve gecersiz password ile giris yapamamali
    Given kullanici "toURL" anasayfaya gider
    Then account butonuna basar
    And email olarak "toInvalidEmail" girer
    And password olarak "toInvalidPassword" girer
    Then signIn butonuna basar
    Then giris yapilamadigini test eder
    And 3 saniye bekler
    And sayfayi kapatir
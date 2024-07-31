Feature: Kullanici gecerli bilgilerler sisteme giris yapabilir


  @regression @smoke @wip # Work In Progress
  Scenario: TC08 Gecerli bilgilerle sisteme giris yapabilmeli
    Given kullanici "toURL" anasayfaya gider
    Then account butonuna basar
    And email olarak "toValidEmail" girer
    And password olarak "toValidPassword" girer
    Then signIn butonuna basar
    And basarili giris yapilabildigini test eder
    And 3 saniye bekler
    And sayfayi kapatir
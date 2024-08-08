@smoke
Feature: US1001 TestOtomasyonu search test

  Scenario: TC01 Kullanici sitede phone aratabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When  arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir


  Scenario: TC02 Kullanici Sitede dress aratabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna dress yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And  sayfayi kapatir

  Scenario: TC03 Kullanici Sitede samsung aratabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna samsung yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And  sayfayi kapatir

Feature:
  @smoke
  Scenario:
    Given kullanici "webUniUrl" anasayfaya gider
    Then Login Portal a  kadar asagi iner
    And Login Portal a tiklar
    When acilan diger window'a gecer
    And username ve password kutularina fake degerler yazdirir
    And login butonuna basar
    Then popup'ta cikan yazinin "validation failed" oldugunu test eder
    And Ok diyerek Popup'i kapatir
    Then ilk window'a geri doner
    And ilk window a donuldugunu test eder

Feature: Validar producto en el carrito de compras

  Scenario: Validar que el producto se muestran correctamente en la opción Carro
    Given que he agregado el producto de la categoría Agradecimientos al carrito
    When doy clic en la opción CARRO
    Then se deberán visualizar el producto agregado

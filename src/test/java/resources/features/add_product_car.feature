Feature: Añadir productos al carrito de compras

  Scenario: Añadir producto de la categoría Agradecimientos al carrito de compras
    Given que estoy en la categoría Agradecimientos
    When doy clic en la opción “Añadir al carrito”
    Then el producto se agregará al carrito de compras

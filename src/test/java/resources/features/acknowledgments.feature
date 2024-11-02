Feature: Visualización de productos en la categoría Agradecimientos

    Scenario: Ver productos de la categoría "Agradecimientos"
        Given que estoy en la página principal de la tienda
        When selecciono la categoría Agradecimientos
        Then se visualizarán los productos para esta categoría
